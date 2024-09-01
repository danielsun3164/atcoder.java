package abc.abc101_150.abc126;

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
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				long w = scanner.nextLong();
				pathLists[u].add(new Path(v, w));
				pathLists[v].add(new Path(u, w));
			});
			long[] distances = dijkstra(pathLists, 0, n);
			Arrays.stream(distances).map(l -> l & 1L).forEach(System.out::println);
		}
	}

	/**
	 * @param pathLists ノード間の連結パス一覧の配列
	 * @param src       開始ノード
	 * @param n         ノードの数
	 * @return 開始ノードからの距離の配列
	 */
	private static long[] dijkstra(List<Path>[] pathLists, int src, int n) {
		long[] distances = new long[n];
		Arrays.fill(distances, Long.MAX_VALUE);
		// 最短距離が確定したかどうか
		boolean[] fixed = new boolean[n];
		Arrays.fill(fixed, false);
		// 出発地点までの距離を0とする
		distances[src] = 0;
		Queue<Path> queue = new PriorityQueue<>();
		queue.add(new Path(src, 0));
		while (!queue.isEmpty()) {
			int now = queue.poll().to;
			if (!fixed[now]) {
				fixed[now] = true;
				for (Path path : pathLists[now]) {
					if (!fixed[path.to] && distances[path.to] > distances[now] + path.cost) {
						distances[path.to] = distances[now] + path.cost;
						queue.add(new Path(path.to, distances[path.to]));
					}
				}
			}
		}
		return distances;
	}

	/**
	 * ノード間の一つのパスを表すクラス
	 */
	static class Path implements Comparable<Path> {
		/** 終了ノード */
		int to;
		/** 移動コスト */
		long cost;

		Path(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Path path) {
			return Long.compare(cost, path.cost);
		}
	}
}
