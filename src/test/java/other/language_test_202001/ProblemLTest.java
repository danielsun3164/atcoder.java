package other.language_test_202001;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemLTest extends TestBase {

	@Test
	void case1() {
		check(5, 7, "ADCBE");
	}

	@Test
	void case2() {
		check(5, 7, "AEDBC");
	}

	@Test
	void case3() {
		check(26, 100, "TXGQNUJPWFRMVOZHKIAYLCBSDE");
	}

	@Test
	void case4() {
		check(26, 100, "CSBNGZXDRJMLOFQAWTYUIEPHKV");
	}

	void check(int n, int q, String expected) {
		try (PipedOutputStream pos = new PipedOutputStream();
				TestPrintStream myPs = new TestPrintStream(pos, expected)) {
			System.setOut(myPs);
			in.input(n + " " + q);
			execute();
			assertEquals(expected, myPs.result);
			assertTrue(myPs.count <= q, "count is" + myPs.count);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * 対話型プログラムのための出力を受け取るクラス
	 */
	private static class TestPrintStream extends PrintStream {
		/** プログラムの実行結果 */
		String result;
		/** 比較回数 */
		int count;

		private PipedInputStream pis;
		private Scanner scanner;

		/** 各文字のインデックス */
		private final int[] indexes;

		/**
		 * コンストラクター
		 *
		 * @param pos
		 * @param expected 期待された結果
		 * @throws IOException 例外
		 */
		public TestPrintStream(PipedOutputStream pos, String expected) throws IOException {
			super(pos);
			count = 0;
			pis = new PipedInputStream(pos);
			scanner = new Scanner(pis);
			char[] array = expected.toCharArray();
			indexes = new int[array.length];
			IntStream.range(0, array.length).forEach(i -> indexes[array[i] - 'A'] = i);
		}

		/**
		 * テスト対象プログラムはprintlnしか使用しないため、このメソッドだけを上書きする
		 *
		 * @param x プログラムのprintlnの内容
		 */
		@Override
		public void println(String x) {
			super.println(x);
			String s = scanner.next();
			if ("!".equals(s)) {
				result = scanner.next();
			} else {
				int a = scanner.next().charAt(0) - 'A';
				assertTrue((a >= 0) && (a < indexes.length), "a is " + a);
				int b = scanner.next().charAt(0) - 'A';
				assertTrue((b >= 0) && (b < indexes.length), "b is " + b);
				in.input((indexes[a] > indexes[b]) ? ">" : "<");
				count++;
			}
		}

		/**
		 * クローズ
		 */
		@Override
		public void close() {
			super.close();
			scanner.close();
			try {
				pis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
