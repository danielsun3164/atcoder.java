package abc.abc001_050.abc019;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

/**
 * 対話型プログラムのため、独自のクラスを作成
 */
class ProblemDTest extends TestBase {

	@Test
	void case1() {
		try (PipedOutputStream pos = new PipedOutputStream(); TestPrintStream myPs = new TestPrintStream(pos)) {
			System.setOut(myPs);
			in.input(5);
			execute();
			assertEquals(14, myPs.result);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * 対話型プログラムのための出力を受け取るクラス
	 */
	private static class TestPrintStream extends PrintStream {

		/** データ */
		final static int[][] DATA = { { 0, 5, 14, 6, 8 }, { 5, 0, 9, 1, 3 }, { 14, 9, 0, 10, 12 }, { 6, 1, 10, 0, 2 },
				{ 8, 3, 12, 2, 0 } };

		/** プログラムの実行結果 */
		int result;

		private static PipedInputStream pis;
		private static Scanner scanner;

		/**
		 * コンストラクター
		 *
		 * @param pos
		 * @throws IOException 例外
		 */
		public TestPrintStream(PipedOutputStream pos) throws IOException {
			super(pos);
			pis = new PipedInputStream(pos);
			scanner = new Scanner(pis);
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
				result = scanner.nextInt();
			} else {
				int a = scanner.nextInt() - 1;
				assertTrue((a >= 0) && (a < DATA.length), "a is " + a);
				int b = scanner.nextInt() - 1;
				assertTrue((b >= 0) && (b < DATA[a].length), "b is " + b);
				in.input(DATA[a][b]);
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
