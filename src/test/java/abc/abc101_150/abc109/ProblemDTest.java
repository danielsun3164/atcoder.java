package abc.abc101_150.abc109;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(2, 3, new int[][] { { 1, 2, 3 }, { 0, 1, 1 } }, 6L);
	}

	@Test
	void case2() {
		check(3, 2, new int[][] { { 1, 0 }, { 2, 1 }, { 1, 0 } }, 5L);
	}

	@Test
	void case3() {
		check(1, 5, new int[][] { { 9, 9, 9, 9, 9 } }, 4L);
	}

	private void check(int h, int w, int[][] a, long expected) {
		in.input(h + " " + w);
		in.input(toString(a));
		execute();
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int n = scanner.nextInt();
			Set<Pair> set = new HashSet<>();
			IntStream.range(0, n).forEach(i -> {
				int x1 = scanner.nextInt() - 1, y1 = scanner.nextInt() - 1;
				int x2 = scanner.nextInt() - 1, y2 = scanner.nextInt() - 1;
				assertTrue(x1 >= 0, "x1=" + x1);
				assertTrue(x1 < h, "x1=" + x1);
				assertTrue(y1 >= 0, "y1=" + y1);
				assertTrue(y1 < w, "y1=" + y1);
				assertTrue(x2 >= 0, "x1=" + x1);
				assertTrue(x2 < h, "x2=" + x2);
				assertTrue(y2 >= 0, "y2=" + y2);
				assertTrue(y2 < w, "y2=" + y2);
				Pair pair = new Pair(x1, y1);
				assertFalse(set.contains(pair), "set is " + set + ", pair.x=" + x1 + ", pair.y=" + y1);
				assertTrue(a[x1][y1] > 0, "a[" + x1 + "][" + y1 + "]=" + a[x1][y1]);
				a[x1][y1]--;
				a[x2][y2]++;
				set.add(pair);
			});
			assertEquals(expected, IntStream.range(0, h)
					.mapToLong(i -> IntStream.range(0, w).filter(j -> 0 == (a[i][j] & 1)).count()).sum());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * 数字の配列を文字列へ変換する
	 * 
	 * @param a 数字の配列
	 * @return 数字の配列から変換される文字列
	 */
	private String toString(int[][] a) {
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, a.length).forEach(i -> {
			IntStream.range(0, a[i].length).forEach(j -> sb.append(a[i][j]).append(" "));
			// 最後のスペースを削除
			sb.deleteCharAt(sb.length() - 1);
			sb.append(LF);
		});
		// 最後の改行を削除
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * x,y を表すクラス
	 */
	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair pair = (Pair) o;
				return (x == pair.x) && (y == pair.y);
			}
			return false;
		}
	}
}
