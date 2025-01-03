package abc.abc151_200.abc191;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] pathLists = new List[n];
			IntStream.range(0, n).forEach(i -> pathLists[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.nextInt();
				pathLists[a].add(new Path(b, c));
			});
			// d[i]はiからiへの最短距離
			int[] d = IntStream.range(0, n).map(i -> dijkstra(pathLists, i, n)[i]).toArray();
			Arrays.stream(d).forEach(di -> System.out.println((INF == di) ? -1 : di));
		}
	}

	/**
	 * @param pathLists ノード間の連結パス一覧の配列
	 * @param src       開始ノード
	 * @param n         ノードの数
	 * @return 開始ノードからの距離の配列
	 */
	private static int[] dijkstra(List<Path>[] pathLists, int src, int n) {
		int[] distances = new int[n];
		Arrays.fill(distances, INF);
		// 最短距離が確定したかどうか
		boolean[] fixed = new boolean[n];
		Arrays.fill(fixed, false);
		Queue<Path> queue = new PriorityQueue<>();
		queue.addAll(pathLists[src]);
		while (!queue.isEmpty()) {
			Path now = queue.poll();
			int to = now.to;
			if (!fixed[to]) {
				distances[to] = Math.min(distances[to], now.cost);
				fixed[to] = true;
				for (Path path : pathLists[to]) {
					if (!fixed[path.to] && distances[path.to] > distances[to] + path.cost) {
						queue.add(new Path(path.to, distances[to] + path.cost));
					}
				}
			}
		}
		return distances;
	}

	/**
	 * ノード間の一つのパスを表すクラス
	 */
	private static class Path implements Comparable<Path> {
		/** 終了ノード */
		int to;
		/** 移動コスト */
		int cost;

		Path(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Path path) {
			return Integer.compare(cost, path.cost);
		}
	}
}
