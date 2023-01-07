package abc.abc051_100.abc069;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** X座標の差分 */
	private static final int[] XS = { 1, -1, 0, 0 };
	/** Y座標の差分 */
	private static final int[] YS = { 0, 0, 1, -1 };

	@Test
	void case1() {
		check(2, 2, 3, new int[] { 2, 1, 1 });
	}

	void check(int h, int w, int n, int[] a) {
		in.input(h + " " + w);
		in.input(n);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(h, lines.length);
		IntStream.range(0, h).forEach(i -> {
			String[] numbers = lines[i].split("\\s+");
			assertEquals(w, numbers.length);
		});
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int[][] c = new int[h][w];
			int[] counts = new int[n], x = new int[n], y = new int[n];
			Arrays.fill(counts, 0);
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> {
				c[i][j] = scanner.nextInt() - 1;
				assertTrue((c[i][j] >= 0) && (c[i][j] < n), "c[" + i + "][" + j + "]=" + (c[i][j] + 1));
				counts[c[i][j]]++;
				x[c[i][j]] = i;
				y[c[i][j]] = j;
			}));
			assertArrayEquals(a, counts);
			boolean[][] visited = new boolean[h][w];
			IntStream.range(0, n).filter(i -> counts[i] > 1).forEach(i -> {
				IntStream.range(0, h).forEach(j -> Arrays.fill(visited[j], false));
				Queue<Data> que = new ArrayDeque<>();
				que.add(new Data(x[i], y[i]));
				visited[x[i]][y[i]] = true;
				int count = 1;
				while (!que.isEmpty()) {
					Data now = que.poll();
					for (int j = 0; j < XS.length; j++) {
						int nx = now.x + XS[j], ny = now.y + YS[j];
						if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w) && (i == c[nx][ny]) && (!visited[nx][ny])) {
							que.add(new Data(nx, ny));
							visited[nx][ny] = true;
							count++;
						}
					}
				}
				assertEquals(a[i], count);
			});
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	void case2() {
		check(3, 5, 5, new int[] { 1, 2, 3, 4, 5 });
	}

	@Test
	void case3() {
		check(1, 1, 1, new int[] { 1 });
	}

	@Test
	void case4() {
		check(3, 5, 5, new int[] { 1, 1, 1, 1, 11 });
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC080/D", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner scanner = new Scanner(inputIs)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			check(h, w, n, a);
		}
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Data {
		int x, y;

		Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
