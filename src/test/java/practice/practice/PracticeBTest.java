package practice.practice;

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

class PracticeBTest extends TestBase {

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
				ProblemLTestPrintStream myPs = new ProblemLTestPrintStream(pos, expected)) {
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

	private static class ProblemLTestPrintStream extends PrintStream {
		String result;
		int count;

		private PipedInputStream pis;
		private Scanner scanner;

		private final int[] indexes;

		public ProblemLTestPrintStream(PipedOutputStream pos, String expected) throws IOException {
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
		 * @param x
		 */
		@Override
		public void println(String x) {
			super.println(x);
			String s = scanner.next();
			if ("!".equals(s)) {
				result = scanner.next();
			} else {
				int a = scanner.next().charAt(0) - 'A';
				int b = scanner.next().charAt(0) - 'A';
				in.input((indexes[a] > indexes[b]) ? ">" : "<");
				count++;
			}
			TestBase.out.reset();
		}

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
