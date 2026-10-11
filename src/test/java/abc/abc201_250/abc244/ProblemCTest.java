package abc.abc201_250.abc244;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

/**
 * 対話型プログラムのため、独自のクラスを作成
 */
class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check(2);
	}

	/**
	 * 対話型プログラムのための出力を受け取るクラス
	 */
	private static class TestPrintStream extends PrintStream {
		/** データ */
		final NavigableSet<Integer> data;
		/** データの数 */
		final int n;

		/** プログラムの実行結果 */
		int result;

		private final InputSnatcher in;

		/**
		 * コンストラクター
		 *
		 * @param pos
		 * @param in  入力用
		 * @param n   数字の数
		 */
		public TestPrintStream(PipedOutputStream pos, InputSnatcher in, int n) {
			super(pos);
			this.in = in;
			this.n = (n << 1) | 1;
			data = IntStream.rangeClosed(1, this.n).boxed().collect(Collectors.toCollection(TreeSet::new));
		}

		/**
		 * テスト対象プログラムはprintlnしか使用しないため、このメソッドだけを上書きする
		 *
		 * @param x プログラムのprintlnの内容
		 */
		@Override
		public void println(Object x) {
			if (x instanceof Integer) {
				int ix = ((Integer) x).intValue();
				if (0 == ix) {
					result = 0;
				} else {
					assertTrue((ix >= 1) && (ix <= n), "next is " + x);
					assertTrue(data.contains(x), "cannot use " + x);
					in.input(data.pollFirst());
				}
			}
		}

		/**
		 * クローズ
		 */
		@Override
		public void close() {
			super.close();
		}
	}

	void check(int n) {
		try (InterpreterInputSnatcher in = new InterpreterInputSnatcher();
				PipedOutputStream pos = new PipedOutputStream();
				TestPrintStream myPs = new TestPrintStream(pos, in, n)) {
			System.setIn(in);
			System.setOut(myPs);
			in.input(n);
			execute();
			assertEquals(0, myPs.result);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc244/C", (inputIs, expectedIs) -> {
			try (Scanner inScanner = new Scanner(inputIs)) {
				check(inScanner.nextInt());
			}
		});
	}
}
