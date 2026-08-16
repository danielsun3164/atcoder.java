package abc.abc201_250.abc239;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	@Test
	void case1() {
		check(5, 5, new int[] { 1, 2, 3, 2, 4 }, new int[] { 2, 3, 5, 4, 5 }, new int[] { 0, 8, 3, 4, 0 }, 7L);
	}

	@Test
	void case2() {
		check(3, 2, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 0, 1, 0 }, 1L);
	}

	@Test
	void case3() {
		check(5, 9, new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 4 }, new int[] { 2, 3, 4, 3, 4, 5, 4, 5, 5 },
				new int[] { 0, 1000000000, 1000000000, 1000000000, 0 }, 3_000_000_000L);
	}

	void check(int n, int m, int[] a, int[] b, int[] c, long expectedC) {
		in.input(n + " " + m);
		IntStream.range(0, m).forEach(i -> in.input(a[i] + " " + b[i]));
		in.input(Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(3, lines.length);
		long actualC = Long.parseLong(lines[0]);
		assertEquals(expectedC, actualC);
		int k = Integer.parseInt(lines[1]);
		String[] strings = lines[2].split("\\p{javaWhitespace}");
		assertEquals(k, strings.length);
		int[] p = new int[k];
		Set<Integer> pSet = new HashSet<>();
		assertEquals(expectedC, IntStream.range(0, k).mapToLong(i -> {
			p[i] = Integer.parseInt(strings[i]);
			pSet.add(p[i]);
			assertTrue((1 != p[i]) && (n != p[i]));
			return c[p[i] - 1];
		}).sum());
		@SuppressWarnings("unchecked")
		List<Integer>[] edges = new List[n];
		IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
		IntStream.range(0, m).forEach(i -> {
			if (!pSet.contains(a[i]) && !pSet.contains(b[i])) {
				edges[a[i] - 1].add(b[i] - 1);
				edges[b[i] - 1].add(a[i] - 1);
			}
		});
		assertEquals(INF, dijkstra(edges, 0)[n - 1]);
	}

	/**
	 * ダイクストラ法
	 *
	 * @param edges  辺の一覧
	 * @param source 開始ノード
	 * @return 開始ノードから各ノードへの距離一覧
	 */
	private int[] dijkstra(List<Integer>[] edges, int source) {
		int n = edges.length;
		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[source] = 0;
		Queue<Integer> que = new ArrayDeque<>();
		que.add(source);
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int next : edges[now]) {
				if (dist[next] > dist[now] + 1) {
					dist[next] = dist[now] + 1;
					que.add(next);
				}
			}
		}
		return dist;
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc239/G");
	}
}
