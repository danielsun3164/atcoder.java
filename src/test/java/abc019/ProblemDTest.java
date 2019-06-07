package abc019;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import practice.TestBase;

/**
 * 対話型プログラムのため、独自のクラスを作成
 */
class ProblemDTest extends TestBase {

	@Test
	void test_Case1() throws IOException {
		try (ProblemDTestPrintStream myPs = new ProblemDTestPrintStream(out)) {
			System.setOut(myPs);
			in.input("5");
			ProblemD.main(null);
			assertEquals(14, myPs.result);
		}
	}

	private static class ProblemDTestPrintStream extends PrintStream {

		final static int[][] DATA = { { 0, 5, 14, 6, 8 }, { 5, 0, 9, 1, 3 }, { 14, 9, 0, 10, 12 }, { 6, 1, 10, 0, 2 },
				{ 8, 3, 12, 2, 0 } };

		int result;

		public ProblemDTestPrintStream(OutputStream out) {
			super(out);
		}

		/**
		 * テスト対象プログラムはprintlnしか使用しないため、このメソッドだけを上書きする
		 * 
		 * @param x
		 */
		@Override
		public void println(String x) {
			super.println(x);
			try (PipedOutputStream pos = new PipedOutputStream();
					PipedInputStream pis = new PipedInputStream(pos);
					Scanner scanner = new Scanner(pis)) {

				TestBase.out.writeTo(pos);
				String s = scanner.next();
				if ("!".equals(s)) {
					result = scanner.nextInt();
				} else {
					int a = scanner.nextInt() - 1;
					int b = scanner.nextInt() - 1;
					in.input(DATA[a][b]);
				}
				TestBase.out.reset();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
