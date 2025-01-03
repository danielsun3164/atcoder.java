package abc.abc101_150.abc137;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc137/submissions/16983535 にも参考
 */
public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), p = scanner.nextInt();
			BellmanFord bf = new BellmanFord(n);
			IntStream.range(0, m)
					.forEach(i -> bf.addEdge(scanner.nextInt() - 1, scanner.nextInt() - 1, p - scanner.nextInt()));
			if (bf.existNegativeCycle(0, n - 1)) {
				System.out.println(-1);
				return;
			}
			System.out.println(Math.max(0, -bf.distances()[n - 1]));
		}
	}

	/**
	 * ベルマン–フォード法 を実装するクラス
	 */
	private static class BellmanFord {

		List<Edge> edges;
		List<Integer>[] graph, reverseGraph;
		boolean[] reachableFromStart, reachableGoal;
		long[] distances;
		boolean existNegativeCycle = false, hasCalledExistNegativeCycle = false;

		/**
		 * コンストラクター
		 *
		 * @param n ノード数
		 */
		@SuppressWarnings("unchecked")
		BellmanFord(int n) {
			edges = new ArrayList<>();
			graph = new List[n];
			reverseGraph = new List[n];
			IntStream.range(0, n).forEach(i -> {
				graph[i] = new ArrayList<>();
				reverseGraph[i] = new ArrayList<>();
			});
			reachableFromStart = new boolean[n];
			reachableGoal = new boolean[n];
			distances = new long[n];
		}

		/**
		 * 辺を追加する
		 *
		 * @param from 始点
		 * @param to   終点
		 * @param cost コスト
		 */
		void addEdge(int from, int to, long cost) {
			graph[from].add(to);
			reverseGraph[to].add(from);
			edges.add(new Edge(from, to, cost));
		}

		/**
		 * startからgoalへの移動中に負のサイクルが存在するかどうかを計算する
		 *
		 * @param start
		 * @param goal
		 * @return startからgoalへの移動中に負のサイクルが存在するかどうか
		 */
		boolean existNegativeCycle(int start, int goal) {
			reachCheck(start, graph, reachableFromStart);
			reachCheck(goal, reverseGraph, reachableGoal);
			Arrays.fill(distances, INF);
			distances[start] = 0L;
			boolean ok = true;
			int count = 0;
			while (ok) {
				ok = false;
				for (Edge e : edges) {
					if (!(reachableFromStart[e.from] && reachableGoal[e.to])) {
						continue;
					}
					if (distances[e.from] + e.cost < distances[e.to]) {
						distances[e.to] = distances[e.from] + e.cost;
						ok = true;
					}
				}
				count++;
				if (count > graph.length) {
					existNegativeCycle = true;
					break;
				}
			}
			hasCalledExistNegativeCycle = true;
			return existNegativeCycle;
		}

		/**
		 * 距離の配列を取得する
		 *
		 * @return 距離の配列
		 */
		long[] distances() {
			if (!hasCalledExistNegativeCycle) {
				throw new UnsupportedOperationException(
						"Call BellmanFord#existNegativeCycle at least once before BellmanFord#dist.");
			}
			return distances;
		}

		/**
		 * ノードvからの到着可能かどうかを計算する
		 *
		 * @param v
		 * @param graph
		 * @param reachable
		 */
		private void reachCheck(int v, List<Integer> graph[], boolean reachable[]) {
			reachable[v] = true;
			graph[v].stream().filter(next -> !reachable[next]).forEach(next -> reachCheck(next, graph, reachable));
		}
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge {
		int from, to;
		long cost;

		public Edge(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
