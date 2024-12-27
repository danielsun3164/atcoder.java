package abc.abc201_250.abc237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc237/editorial/3346 の実装
 */
public class ProblemE別回答 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[] h = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(new Edge(v, Math.abs(h[v] - h[u])));
				edges[v].add(new Edge(u, Math.abs(h[u] - h[v])));
			});
			long[] dist = new long[n];
			Arrays.fill(dist, INF);
			dist[0] = 0L;
			Queue<Edge> que = new PriorityQueue<>((x, y) -> Long.compare(x.cost, y.cost));
			que.add(new Edge(0, 0L));
			while (!que.isEmpty()) {
				Edge now = que.poll();
				if (now.cost == dist[now.to]) {
					for (Edge next : edges[now.to]) {
						if (dist[next.to] > dist[now.to] + next.cost) {
							dist[next.to] = dist[now.to] + next.cost;
							que.add(new Edge(next.to, dist[next.to]));
						}
					}
				}
			}
			System.out.println(
					IntStream.range(0, n).mapToLong(i -> h[0] - h[i] - (dist[i] - h[0] + h[i]) / 2).max().getAsLong());
		}
	}

	/**
	 * to, costを格納するクラス
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
