package abc.abc001_050.abc035;

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
 * https://atcoder.jp/contests/abc035/submissions/2509685 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), t = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			@SuppressWarnings("unchecked")
			List<Edge>[] goEdgeLists = new List[n], backEdgeLists = new List[n];
			IntStream.range(0, n).forEach(i -> {
				goEdgeLists[i] = new ArrayList<>();
				backEdgeLists[i] = new ArrayList<>();
			});
			IntStream.range(0, m).forEach(i -> {
				int from = scanner.nextInt() - 1;
				int to = scanner.nextInt() - 1;
				int cost = scanner.nextInt();
				goEdgeLists[from].add(new Edge(to, cost));
				backEdgeLists[to].add(new Edge(from, cost));
			});
			int[] goDistances = dijkstra(goEdgeLists, 0, n);
			int[] backDistances = dijkstra(backEdgeLists, 0, n);
			System.out.println(IntStream.range(0, n)
					.mapToLong(i -> ((long) t - goDistances[i] - backDistances[i]) * a[i]).max().getAsLong());
		}
	}

	/**
	 * @param edgeLists 辺のリスト一覧
	 * @param src       開始ノード
	 * @param n         ノードの数
	 * @return 開始ノードからの距離一覧
	 */
	private static int[] dijkstra(List<Edge>[] edgeLists, int src, int n) {
		// 開始ノードからの距離の配列
		int[] distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		// 最短距離が確定したかどうか
		boolean[] fixed = new boolean[n];
		Arrays.fill(fixed, false);
		// 出発地点までの距離を0とする
		distances[src] = 0;
		Queue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(src, 0));
		while (!queue.isEmpty()) {
			int now = queue.poll().to;
			if (!fixed[now]) {
				fixed[now] = true;
				for (Edge ei : edgeLists[now]) {
					if (!fixed[ei.to] && distances[ei.to] > distances[now] + ei.cost) {
						distances[ei.to] = distances[now] + ei.cost;
						queue.add(new Edge(ei.to, distances[ei.to]));
					}
				}
			}
		}
		return distances;
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge implements Comparable<Edge> {
		/** 終了ノード */
		int to;
		/** コスト */
		int cost;

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return cost - e.cost;
		}
	}
}
