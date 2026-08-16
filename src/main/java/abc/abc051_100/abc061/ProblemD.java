package abc.abc051_100.abc061;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Path[] paths = new Path[m];
			IntStream.range(0, m).forEach(
					// 最長距離を計算するため、距離をマイナスにする
					i -> paths[i] = new Path(scanner.nextInt() - 1, scanner.nextInt() - 1, -scanner.nextLong()));
			long[] distances = new long[n];
			if (bellmanFord(paths, 0, n, distances)) {
				System.out.println("inf");
			} else {
				System.out.println(-distances[n - 1]);
			}
		}
	}

	/**
	 * https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/ を参考に作成
	 *
	 * @param paths     ノード間の連結パス一覧の配列
	 * @param src       開始ノード
	 * @param n         ノードの数
	 * @param distances 開始ノードから各ノードへの最短距離の配列
	 * @return グラフにはループが含まれているかどうか
	 */
	private static boolean bellmanFord(final Path[] paths, final int src, final int n, final long[] distances) {
		Arrays.fill(distances, Long.MAX_VALUE);
		distances[src] = 0;

		IntStream.range(1, n).forEach(i -> IntStream.range(0, paths.length).forEach(j -> {
			int from = paths[j].from, to = paths[j].to;
			long cost = paths[j].cost;
			if (distances[from] != Long.MAX_VALUE && distances[from] + cost < distances[to]) {
				distances[to] = distances[from] + cost;
			}
		}));

		// マイナスのループが含まれているかどうかを判定
		// 解説に参考して作成
		boolean[] negative = new boolean[n];
		Arrays.fill(negative, false);
		IntStream.range(0, n).forEach(i -> IntStream.range(0, paths.length).forEach(j -> {
			int from = paths[j].from, to = paths[j].to;
			if (distances[from] != Long.MAX_VALUE && distances[from] + paths[j].cost < distances[to]) {
				distances[to] = distances[from] + paths[j].cost;
				negative[to] = true;
			}
			if (negative[from]) {
				negative[to] = true;
			}
		}));
		return negative[n - 1];
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
		long cost;

		Path(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Path path) {
			long costDiff = cost - path.cost;
			return (costDiff > 0) ? 1 : (costDiff < 0) ? -1 : 0;
		}
	}
}
