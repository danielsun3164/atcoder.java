package abc.abc201_250.abc222;

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
 * https://atcoder.jp/contests/abc222/editorial/2749 の直径を利用した解き方の実装
 */
public class ProblemF {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.nextInt();
				edges[a].add(new Edge(b, c));
				edges[b].add(new Edge(a, c));
			});
			int[] d = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int s = 0, t = -1, u = -1;
			{
				long[] dist = dijkstra(s, edges);
				long max = -1;
				for (int i = 0; i < n; i++) {
					if ((i != s) && (dist[i] + d[i] > max)) {
						max = dist[i] + d[i];
						t = i;
					}
				}
			}
			{
				long[] dist = dijkstra(t, edges);
				long max = -1;
				for (int i = 0; i < n; i++) {
					if ((i != t) && (dist[i] + d[i] > max)) {
						max = dist[i] + d[i];
						u = i;
					}
				}
			}
			long[] dt = dijkstra(t, edges), du = dijkstra(u, edges);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				long cost = -1L;
				if (i != t) {
					cost = Math.max(cost, dt[i] + d[t]);
				}
				if (i != u) {
					cost = Math.max(cost, du[i] + d[u]);
				}
				sb.append(cost).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * dijkstraで開始ノードからの距離一覧を計算する
	 *
	 * @param start 開始ノード
	 * @param edges 辺の一覧
	 * @return 開始ノードからの距離一覧
	 */
	private static long[] dijkstra(int start, List<Edge>[] edges) {
		int n = edges.length;
		long[] dist = new long[n];
		Arrays.fill(dist, INF);
		dist[start] = 0L;
		Queue<Edge> que = new PriorityQueue<>((x, y) -> Long.compare(x.cost, y.cost));
		que.add(new Edge(start, 0L));
		while (!que.isEmpty()) {
			Edge now = que.poll();
			if (dist[now.to] == now.cost) {
				for (Edge edge : edges[now.to]) {
					if (dist[now.to] + edge.cost < dist[edge.to]) {
						dist[edge.to] = dist[now.to] + edge.cost;
						que.add(new Edge(edge.to, dist[edge.to]));
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
