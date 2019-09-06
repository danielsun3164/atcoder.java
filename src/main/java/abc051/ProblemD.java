package abc051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通り実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			Path[] paths = new Path[m];
			@SuppressWarnings("unchecked")
			List<Path>[] pathLists = new List[n];
			IntStream.range(0, n).forEach(i -> pathLists[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				paths[i] = new Path(scanner.nextInt() - 1, scanner.nextInt() - 1, scanner.nextInt());
				pathLists[paths[i].from].add(paths[i]);
				pathLists[paths[i].to].add(new Path(paths[i].to, paths[i].from, paths[i].cost));
			});
			int[][] dist = new int[n][];
			IntStream.range(0, n).forEach(i -> dist[i] = dijkstra(pathLists, i, n));
			int answer = m;
			for (Path path : paths) {
				boolean shortest = false;
				for (int j = 0; j < n; j++) {
					if (dist[j][path.from] + path.cost == dist[j][path.to]) {
						shortest = true;
					}
				}
				if (shortest) {
					answer--;
				}
			}
			System.out.println(answer);
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
		Arrays.fill(distances, Integer.MAX_VALUE);
		// 最短距離が確定したかどうか
		boolean[] fixed = new boolean[n];
		Arrays.fill(fixed, false);
		// 出発地点までの距離を0とする
		distances[src] = 0;
		Queue<Path> queue = new PriorityQueue<>();
		queue.add(new Path(src, src, 0));
		while (!queue.isEmpty()) {
			int now = queue.poll().to;
			if (!fixed[now]) {
				fixed[now] = true;
				for (Path path : pathLists[now]) {
					if (!fixed[path.to] && distances[path.to] > distances[now] + path.cost) {
						distances[path.to] = distances[now] + path.cost;
						queue.add(new Path(path.to, path.to, distances[path.to]));
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
		/** 開始ノード */
		int from;
		/** 終了ノード */
		int to;
		/** 移動コスト */
		int cost;

		Path(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Path path) {
			return this.cost - path.cost;
		}
	}
}
