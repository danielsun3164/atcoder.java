package abc.abc051_100.abc067;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] pathLists = new List[n];
			IntStream.range(0, n).forEach(i -> pathLists[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int from = scanner.nextInt() - 1, to = scanner.nextInt() - 1;
				pathLists[from].add(new Path(from, to, 1));
				pathLists[to].add(new Path(to, from, 1));
			});
			// ノード1からの距離の配列
			int[] distances1 = dijkstra(pathLists, 0, n);
			// ノードnからの距離の配列
			int[] distancesn = dijkstra(pathLists, n - 1, n);
			// 黒と白に塗られたマスの数
			int black = 0, white = 0;
			for (int i = 0; i < n; i++) {
				if (distances1[i] <= distancesn[i]) {
					black++;
				} else {
					white++;
				}
			}
			System.out.println((black > white) ? "Fennec" : "Snuke");
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
		@SuppressWarnings("unused")
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
			return Integer.compare(cost, path.cost);
		}
	}
}
