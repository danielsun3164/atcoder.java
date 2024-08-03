package abc.abc201_250.abc232;

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
 * https://kanpurin.hatenablog.com/entry/2021/12/20/045651 の実装<br/>
 * https://atcoder.jp/contests/abc232/submissions/28024157 にも参考
 */
public class ProblemG別回答 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long m = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			Edge[] b = IntStream.range(0, n).mapToObj(i -> new Edge(i, scanner.nextLong()))
					.sorted((x, y) -> Long.compare(x.cost, y.cost)).toArray(Edge[]::new);
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n << 1];
			IntStream.range(0, n << 1).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1)
					.forEach(i -> edges[n + b[i].to].add(new Edge(n + b[i + 1].to, b[i + 1].cost - b[i].cost)));
			IntStream.range(0, n).forEach(i -> {
				edges[i].add(new Edge(n + b[0].to, a[i] + b[0].cost));
				edges[i + n].add(new Edge(i, 0L));
				int index = ~Arrays.binarySearch(b, new Edge(0, m - a[i]),
						(x, y) -> (Long.compare(x.cost, y.cost) >= 0) ? 1 : -1);
				if (index < n) {
					edges[i].add(new Edge(b[index].to + n, a[i] + b[index].cost - m));
				}
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
