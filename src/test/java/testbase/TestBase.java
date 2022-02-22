package testbase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestBase {

	private static InputStream systemIn = System.in;
	private static PrintStream systemOut = System.out;

	protected static StandardInputSnatcher in = new StandardInputSnatcher();
	protected static ByteArrayOutputStream out = new ByteArrayOutputStream();
	private static PrintStream mySystemOut;

	/** システムの改行コード */
	protected static String LF = System.lineSeparator();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setIn(in);
		System.setOut(mySystemOut = new PrintStream(out));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.setOut(systemOut);
		System.setIn(systemIn);
		mySystemOut.close();
		out.close();
	}

	@BeforeEach
	void clearInAndOut() throws IOException {
		out.reset();
		in.clear();
	}

	/**
	 * テストケースを実行した結果をチェック
	 *
	 * @param expected 予定される結果
	 */
	protected void assertResultIs(String expected) {
		assertEquals(replaceLineSeparator(expected + LF), replaceLineSeparator(out.toString()));
	}

	/**
	 * テストケースを実行した結果をチェック
	 *
	 * @param expecteds 予定される結果の一覧
	 */
	protected void assertResultIn(String... expecteds) {
		String actualResult = replaceLineSeparator(out.toString());
		assertTrue(Arrays.stream(expecteds).filter(s -> replaceLineSeparator(s + LF).equals(actualResult)).count() > 0,
				"result is " + actualResult);
	}

	/**
	 * テストケースを実行した結果をチェック
	 *
	 * @param regexp 予定される結果の正規表現
	 */
	protected void assertResultMatches(String regexp) {
		assertTrue(replaceLineSeparator(out.toString()).matches(replaceLineSeparator(regexp + LF)),
				"result is " + out.toString());
	}

	/**
	 * テストケースを実行した結果をチェック
	 *
	 * @param expected 予定される結果
	 */
	protected void assertResultIs(double expected) {
		assertEquals(expected, Double.parseDouble(out.toString()));
	}

	/**
	 * テストケースを実行した結果をチェック
	 *
	 * @param expected  予定される結果
	 * @param tolerance 誤差範囲
	 */
	protected void assertResultIsAbout(double expected, double tolerance) {
		assertTrue(Math.abs(Double.parseDouble(out.toString()) - expected) < tolerance, "number is " + out.toString());
	}

	/**
	 * テスト対象のメソッドを実行
	 */
	protected void execute() {
		try {
			// テストクラス名から末尾の「Test」を取ったクラス名のクラスを取得し、mainメソッドを実行
			Class<?> clazz = Class.forName(this.getClass().getName().replaceFirst("Test$", ""));
			Method method = clazz.getDeclaredMethod("main", String[].class);
			method.invoke(null, (Object) null);
		} catch (ClassNotFoundException | SecurityException | IllegalArgumentException | NoSuchMethodException
				| IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * テストを実施する
	 *
	 * @param input    入力文字列
	 * @param expected 予想される実行結果
	 */
	protected void check(String input, String expected) {
		in.input(input);
		execute();
		assertResultIs(expected);
	}

	/**
	 * テストを実施する
	 *
	 * @param input    入力文字列を保存するファイル
	 * @param expected 予想される実行結果
	 */
	protected void check(File input, String expected) {
		try (FileReader fr = new FileReader(input)) {
			char[] buffer = new char[8192];
			int length = 0;
			while (-1 != (length = fr.read(buffer))) {
				in.buffer.append(buffer, 0, length);
			}
			in.buffer.append(LF);
			execute();
			assertResultIs(expected);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * テストを実施する
	 *
	 * @param input    入力文字列を保存するファイル
	 * @param expected 予想される実行結果を保存するファイル
	 */
	protected void check(File input, File expected) {
		try (FileReader inFr = new FileReader(input); FileReader expectedFr = new FileReader(expected)) {
			char[] buffer = new char[8192];
			int length = 0;
			while (-1 != (length = inFr.read(buffer))) {
				in.buffer.append(buffer, 0, length);
			}
			in.buffer.append(LF);
			StringBuilder expectedSb = new StringBuilder();
			while (-1 != (length = expectedFr.read(buffer))) {
				expectedSb.append(buffer, 0, length);
			}
			execute();
			assertEquals(replaceLineSeparator(expectedSb.toString()), replaceLineSeparator(out.toString()));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * テストを実施する
	 *
	 * @param input    入力文字列
	 * @param expected 予想される実行結果の一覧
	 */
	protected void checkResultIn(String input, String... expected) {
		in.input(input);
		execute();
		assertResultIn(expected);
	}

	/**
	 * テストを実施する
	 *
	 * @param input     入力文字列
	 * @param expected  予想される実行結果
	 * @param tolerance 誤差範囲
	 */
	protected void checkResultIsAbout(String input, double expected, double tolerance) {
		in.input(input);
		execute();
		assertResultIsAbout(expected, tolerance);
	}

	/**
	 * テストを実施する
	 *
	 * @param input          入力文字列
	 * @param expectedRegexp 予想される実行結果の正規表現
	 */
	protected void checkResultMatches(String input, String expectedRegexp) {
		in.input(input);
		execute();
		assertResultMatches(expectedRegexp);
	}

	/**
	 * テストを実施する
	 *
	 * @param input    入力文字列
	 * @param expected 予想される実行結果
	 */
	protected void check(String input, double expected) {
		in.input(input);
		execute();
		assertResultIs(expected);
	}

	/**
	 * テストケースを実行した結果をチェック
	 *
	 * @param number    実行結果の数字形式の文字列
	 * @param expected  予定した結果
	 * @param tolerance 誤差範囲
	 */
	protected void assertNumberIsAbout(String number, double expected, double tolerance) {
		assertTrue(Math.abs(Double.parseDouble(number) - expected) < tolerance,
				"number is " + number + ", expected is " + expected);
	}

	/**
	 * 入力文字列の改行コードをすべてLFに置き換える
	 *
	 * @param string 入力文字列
	 * @return 入力文字列の改行コードをすべてLFに置き換えた文字列
	 */
	protected String replaceLineSeparator(String string) {
		return string.replaceAll("\\R", LF);
	}

	/**
	 * 標準入力を代替するクラス
	 */
	protected static class StandardInputSnatcher extends InputStream {

		private StringBuilder buffer = new StringBuilder();

		private ByteArrayInputStream inputStream = null;

		/**
		 * 文字列を入力する。
		 *
		 * @param str 入力文字列
		 */
		public void input(String str) {
			clearIfInputStreamExists();
			buffer.append(str).append(LF);
		}

		/**
		 * 数字を入力する。
		 *
		 * @param num 入力数字
		 */
		public void input(Number num) {
			clearIfInputStreamExists();
			buffer.append(num).append(LF);
		}

		@Override
		public int read() throws IOException {
			if (null == inputStream) {
				initInputStream();
			}
			return inputStream.read();
		}

		/**
		 * inputStreamを作成する
		 */
		private void initInputStream() {
			inputStream = new ByteArrayInputStream(buffer.toString().getBytes());
		}

		/**
		 * inputStreamが存在する場合、バッファーをクリアする
		 */
		private void clearIfInputStreamExists() {
			if (null != inputStream) {
				clear();
			}
		}

		/**
		 * 未使用のバッファーをクリアする
		 */
		public void clear() {
			buffer.setLength(0);
			closeInputStream();
		}

		/**
		 * inputStreamをクローズする
		 */
		private void closeInputStream() {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				inputStream = null;
			}
		}

		@Override
		public void close() throws IOException {
			if (null != inputStream) {
				inputStream.close();
			}
		}
	}
}
