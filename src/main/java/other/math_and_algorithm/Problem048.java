package other.math_and_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem048 {

	/** 10 */
	private static final int TEN = 10;
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] edges = new List[k];
			IntStream.range(0, k).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, k).forEach(i -> IntStream.range((0 == i) ? 1 : 0, TEN)
					.forEach(j -> edges[i].add(new Path((i * TEN + j) % k, j))));
			int[] dist = dijkstra(edges, 0);
			System.out.println(dist[0]);
		}
	}

	/**
	 * ダイクストラ法の実施
	 *
	 * @param edges 辺の一覧
	 * @param start 開始ノード
	 * @return 開始ノードから各ノードへの距離一覧
	 */
	private static int[] dijkstra(List<Path>[] edges, int start) {
		int[] dist = new int[edges.length];
		Arrays.fill(dist, INF);
		Queue<Path> que = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
		que.add(new Path(start, 0));
		while (!que.isEmpty()) {
			Path now = que.poll();
			for (Path next : edges[now.to]) {
				if (dist[next.to] > now.cost + next.cost) {
					dist[next.to] = now.cost + next.cost;
					que.add(new Path(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}

	/**
	 * to,costを格納するクラス
	 */
	private static class Path {
		int to, cost;

		Path(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
