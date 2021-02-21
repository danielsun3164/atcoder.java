package abc.abc151_200.abc192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
			@SuppressWarnings("unchecked")
			List<Path>[] pathLists = new List[n];
			IntStream.range(0, n).forEach(i -> pathLists[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, t = scanner.nextInt(), k = scanner.nextInt();
				pathLists[a].add(new Path(b, t, k));
				pathLists[b].add(new Path(a, t, k));
			});
			// d[i]はiからiへの最短距離
			long[] d = dijkstra(pathLists, x, n);
			System.out.println((INF == d[y]) ? -1 : d[y]);
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
		Arrays.fill(distances, INF);
		Queue<Path> queue = new PriorityQueue<>();
		queue.add(new Path(src, 0L, 0L));
		distances[src] = 0L;
		while (!queue.isEmpty()) {
			Path p = queue.poll();
			int now = p.to;
			if (distances[now] == p.cost) {
				for (Path path : pathLists[now]) {
					if (distances[path.to] > (distances[now] + path.k - 1) / path.k * path.k + path.cost) {
						distances[path.to] = (distances[now] + path.k - 1) / path.k * path.k + path.cost;
						queue.add(new Path(path.to, distances[path.to], 0L));
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
		long cost;
		/** 発車時刻 */
		long k;

		Path(int to, long cost, long k) {
			super();
			this.to = to;
			this.cost = cost;
			this.k = k;
		}

		@Override
		public int compareTo(Path path) {
			return Long.compare(cost, path.cost);
		}
	}
}
