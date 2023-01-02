package abc.abc051_100.abc092;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 白いコマの文字 */
	private static final char WHITE = '.';

	@Test
	void case1() {
		check(2, 3);
	}

	@Test
	void case2() {
		check(7, 8);
	}

	@Test
	void case3() {
		check(1, 1);
	}

	@Test
	void case4() {
		check(1, 500);
	}

	@Test
	void case5() {
		check(500, 500);
	}

	/**
	 * テストを実施
	 *
	 * @param a 白いコマの数
	 * @param b 黒いコマの数
	 */
	private void check(int a, int b) {
		in.input(a + " " + b);
		execute();
		String[] lines = out.toString().split("\\R");
		assertTrue(lines.length > 0, "line is empty");
		String[] numbers = lines[0].split("\\s+");
		assertEquals(2, numbers.length);
		try {
			int h = Integer.parseInt(numbers[0]), w = Integer.parseInt(numbers[1]);
			assertEquals(h + 1, lines.length);
			IntStream.rangeClosed(1, h).forEach(i -> assertEquals(w, lines[i].length()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			int[][] t = calc(h, w, s);
			assertEquals(a,
					(int) IntStream.range(0, h)
							.flatMap(i -> IntStream.range(0, w).filter(j -> s[i][j] == WHITE).map(j -> t[i][j]))
							.distinct().count());
			assertEquals(b,
					(int) IntStream.range(0, h)
							.flatMap(i -> IntStream.range(0, w).filter(j -> s[i][j] != WHITE).map(j -> t[i][j]))
							.distinct().count());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * コマの分布を計算する
	 *
	 * @param h 高さ
	 * @param w 幅
	 * @param s コマを表す配列
	 * @return コマの分布を表す配列
	 */
	private int[][] calc(final int h, final int w, final char[][] s) {
		int[][] t = new int[h][w];
		IntStream.range(0, h).forEach(i -> Arrays.fill(t[i], -1));
		int count = 1;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				count = calc(h, w, s, t, i, j, count);
			}
		}
		return t;
	}

	/**
	 * コマの(i,j)部分の分布を計算する
	 *
	 * @param h     高さ
	 * @param w     幅
	 * @param s     コマを表す配列
	 * @param t     コマの分布を表す配列
	 * @param i     縦index
	 * @param j     横index
	 * @param count 分布に使用する数字
	 * @return 次のコマの分布に使用する数字
	 */
	private int calc(final int h, final int w, final char[][] s, final int[][] t, final int i, final int j,
			final int count) {
		if (t[i][j] <= 0) {
			char now = s[i][j];
			t[i][j] = count;
			if ((i > 0) && (now == s[i - 1][j])) {
				calc(h, w, s, t, i - 1, j, count);
			}
			if ((i < h - 1) && (now == s[i + 1][j])) {
				calc(h, w, s, t, i + 1, j, count);
			}
			if ((j > 0) && (now == s[i][j - 1])) {
				calc(h, w, s, t, i, j - 1, count);
			}
			if ((j < w - 1) && (now == s[i][j + 1])) {
				calc(h, w, s, t, i, j + 1, count);
			}
			return count + 1;
		}
		return count;
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC093/D", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner scanner = new Scanner(inputIs)) {
			check(scanner.nextInt(), scanner.nextInt());
		}
	}
}
