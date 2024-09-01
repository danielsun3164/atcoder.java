package abc.abc201_250.abc232;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc232/editorial/3141 の実装<br/>
 * https://atcoder.jp/contests/abc232/submissions/33368232 にも参考
 */
public class ProblemG {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long m = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray(),
					b = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] c = LongStream.concat(Arrays.stream(a).map(ai -> (m - ai) % m), Arrays.stream(b)).sorted().distinct()
					.toArray();
			int p = c.length;
			Map<Long, Integer> map = new HashMap<>();
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n + p];
			IntStream.range(0, n + p).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, p).forEach(i -> {
				map.put(c[i], n + i);
				edges[n + i].add(new Edge(n + (i + 1) % p, (c[(i + 1) % p] - c[i] + m) % m));
			});
			IntStream.range(0, n).forEach(i -> {
				edges[map.get(b[i])].add(new Edge(i, 0L));
				edges[i].add(new Edge(map.get((m - a[i]) % m), 0L));
			});
			System.out.println(dijkstra(edges, 0)[n - 1]);
		}
	}

	/**
	 * ダイクストラ法
	 *
	 * @param edges 辺の一覧
	 * @param start 開始ノード
	 * @return 開始ノードからの距離一覧
	 */
	private static long[] dijkstra(List<Edge>[] edges, int start) {
		long[] dist = new long[edges.length];
		Arrays.fill(dist, INF);
		dist[start] = 0L;
		Queue<Edge> que = new PriorityQueue<>((x, y) -> Long.compare(x.cost, y.cost));
		que.add(new Edge(start, 0L));
		while (!que.isEmpty()) {
			Edge now = que.poll();
			if (dist[now.to] == now.cost) {
				for (Edge next : edges[now.to]) {
					if (dist[next.to] > dist[now.to] + next.cost) {
						dist[next.to] = dist[now.to] + next.cost;
						que.add(new Edge(next.to, dist[next.to]));
					}
				}
			}
		}
		return dist;
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge {
		int to;
		long cost;

		Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
