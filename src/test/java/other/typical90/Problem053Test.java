package other.typical90;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

/**
 * 対話型プログラムのため、独自のクラスを作成
 */
class Problem053Test extends TestBase {

	private static final int MAX = 1_000_000_000;

	@Test
	void case1() {
		check(new int[][] { { 1, 2, 3, 4, 5, 6, 9, 1 }, { 7, 8, 9, 8, 7, 6, 5, 4 } });
	}

	@Test
	void case2() {
		check(new int[][] { { 0 }, { 1_000_000_000 } });
	}

	void check(int[][] datas) {
		try (InterpreterInputSnatcher in = new InterpreterInputSnatcher();
				PipedOutputStream pos = new PipedOutputStream();
				TestPrintStream myPs = new TestPrintStream(pos, in, datas)) {
			System.setIn(in);
			System.setOut(myPs);
			in.input(datas.length);
			in.input(datas[0].length);
			execute();
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * 対話型プログラムのための出力を受け取るクラス
	 */
	private static class TestPrintStream extends PrintStream {

		/** 実行用のテストデータ */
		final int[][] datas;
		/** クエリの数 */
		int count;
		/** 現在の処理対象の行数 */
		int line;

		private final PipedInputStream pis;
		private final Scanner scanner;
		private final InputSnatcher in;

		/**
		 * コンストラクター
		 *
		 * @param pos
		 * @param in    入力用
		 * @param datas チェック用データ
		 * @throws IOException
		 */
		public TestPrintStream(PipedOutputStream pos, InputSnatcher in, int[][] datas) throws IOException {
			super(pos);
			pis = new PipedInputStream(pos);
			scanner = new Scanner(pis);
			this.in = in;
			this.datas = datas;
			count = 0;
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
				// 結果をチェック
				int result = scanner.nextInt();
				assertEquals(Arrays.stream(datas[line]).max().getAsInt(), result);
				assertTrue(count <= 15, "count is " + count);
				line++;
				// 次の行の件数を入力する
				if (line < datas.length) {
					in.input(datas[line].length);
					count = 0;
				}
			} else {
				int i = scanner.nextInt() - 1;
				assertTrue((i >= 0) && (i < datas[line].length), "i is " + i);
				in.input(datas[line][i]);
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

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/053", (inputIs, expectedIs) -> {
			try (Scanner scanner = new Scanner(inputIs)) {
				int t = scanner.nextInt();
				int[][] data = new int[t][];
				for (int i = 0; i < t; i++) {
					String s = scanner.next();
					if ("deterministic-judge".equals(s)) {
						int n = scanner.nextInt();
						data[i] = IntStream.range(0, n).map(j -> scanner.nextInt()).toArray();
					} else {
						int n = scanner.nextInt(), maxIndex = scanner.nextInt() - 1;
						Random random = new Random(Long.parseUnsignedLong(scanner.next()));
						data[i] = new int[n];
						NavigableSet<Integer> set = new TreeSet<>();
						// 前半
						while (set.size() <= maxIndex) {
							set.add(random.nextInt(MAX - 1) + 1);
						}
						int index = 0, max = set.last();
						while (!set.isEmpty()) {
							data[i][index++] = set.pollFirst();
						}
						// 後半
						while (set.size() < n - 1 - maxIndex) {
							set.add(random.nextInt(max - 1) + 1);
						}
						while (!set.isEmpty()) {
							data[i][index++] = set.pollLast();
						}
					}
				}
				check(data);
			}
		});
	}
}
