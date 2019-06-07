package practice;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestBase {

	private static InputStream systemIn = System.in;
	private static PrintStream systemOut = System.out;

	protected static StandardInputSnatcher in = new StandardInputSnatcher();
	protected static ByteArrayOutputStream out = new ByteArrayOutputStream();

	/** システムの改行コード */
	protected static String LF = System.lineSeparator();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setIn(in);
		System.setOut(new PrintStream(out));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.setOut(systemOut);
		System.setIn(systemIn);
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
	 * @param expected 予定した結果
	 */
	protected void assertResultIs(String expected) {
		assertEquals(expected + LF, out.toString());
	}

	/**
	 * テストケースを実行した結果をチェック
	 * 
	 * @param regexp 予定した結果の正規表現
	 */
	protected void assertResultMatches(String regexp) {
		assertTrue(out.toString().matches(regexp + LF));
	}

	/**
	 * テストケースを実行した結果をチェック
	 * 
	 * @param expected 予定した結果
	 */
	protected void assertResultIs(double expected) {
		assertEquals(expected, Double.parseDouble(out.toString()));
	}

	/**
	 * テストケースを実行した結果をチェック
	 * 
	 * @param expected  予定した結果
	 * @param tolerance 誤差範囲
	 */
	protected void assertResultIsAbout(double expected, double tolerance) {
		assertTrue(Math.abs(Double.parseDouble(out.toString()) - expected) < tolerance);
	}

	protected static class StandardInputSnatcher extends InputStream {

		private StringBuilder buffer = new StringBuilder();

		/**
		 * 文字列を入力する。
		 * 
		 * @param str 入力文字列
		 */
		public void input(String str) {
			buffer.append(str).append(LF);
		}

		/**
		 * 数字を入力する。
		 * 
		 * @param num 入力数字
		 */
		public void input(Number num) {
			buffer.append(num).append(LF);
		}

		@Override
		public int read() throws IOException {
			if (buffer.length() == 0) {
				return -1;
			}
			int result = buffer.charAt(0);
			buffer.deleteCharAt(0);
			return result;
		}

		/**
		 * 未使用のバッファーをクリアする
		 */
		public void clear() {
			buffer.setLength(0);
		}
	}
}
