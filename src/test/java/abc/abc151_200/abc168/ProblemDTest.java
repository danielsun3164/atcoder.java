package abc.abc151_200.abc168;

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
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(4, 4, new int[] { 1, 2, 3, 4 }, new int[] { 2, 3, 4, 2 });
	}

	@Test
	void case2() {
		check(6, 9, new int[] { 3, 6, 2, 5, 4, 1, 6, 4, 5 }, new int[] { 4, 1, 4, 3, 6, 5, 2, 5, 6 });
	}

	void check(int n, int m, int[] a, int[] b) {
		in.input(n + " " + m);
		IntStream.range(0, m).forEach(i -> in.input(a[i] + " " + b[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(n, lines.length);
		@SuppressWarnings("unchecked")
		Set<Integer>[] paths = new Set[n];
		IntStream.range(0, n).forEach(i -> paths[i] = new HashSet<>());
		IntStream.range(0, m).forEach(i -> {
			paths[a[i] - 1].add(b[i] - 1);
			paths[b[i] - 1].add(a[i] - 1);
		});
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			assertEquals("Yes", scanner.next());
			int[] result = IntStream.range(1, n).map(i -> {
				int exp = scanner.nextInt();
				assertTrue(paths[i].contains(exp - 1));
				return exp;
			}).toArray();
			assertArrayEquals(dijkstra(n, paths), convert(result));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	private int[] dijkstra(int n, Set<Integer>[] paths) {
		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[0] = 0;
		Queue<Integer> que = new ArrayDeque<>();
		que.add(0);
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int next : paths[now]) {
				if (dist[next] > dist[now] + 1) {
					dist[next] = dist[now] + 1;
					que.add(next);
				}
			}
		}
		return dist;
	}

	/**
	 * 親の配列から各ノードの深さの配列を計算する
	 *
	 * @param parents 親の配列
	 * @return 各ノードの深さの配列
	 */
	private int[] convert(int[] parents) {
		int[] result = new int[parents.length + 1];
		Arrays.fill(result, -1);
		result[0] = 0;
		IntStream.range(0, parents.length).forEach(i -> calc(parents, result, i));
		return result;
	}

	private void calc(int[] parents, int[] result, int now) {
		if (-1 == result[now + 1]) {
			if (-1 == result[parents[now] - 1]) {
				calc(parents, result, parents[now] - 2);
			}
			result[now + 1] = result[parents[now] - 1] + 1;
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC168/D", (inputIs, expectedIs) -> {
			try (Scanner scanner = new Scanner(inputIs)) {
				int n = scanner.nextInt(), m = scanner.nextInt();
				int[] a = new int[m], b = new int[m];
				IntStream.range(0, m).forEach(i -> {
					a[i] = scanner.nextInt();
					b[i] = scanner.nextInt();
				});
				check(n, m, a, b);
			}
		});
	}
}
