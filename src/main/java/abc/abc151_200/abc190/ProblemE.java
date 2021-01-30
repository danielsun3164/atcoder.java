package abc.abc151_200.abc190;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m], b = new int[m];
			Set<Integer> set = new HashSet<>();
			@SuppressWarnings("unchecked")
			List<Path>[] pathLists = new List[n];
			IntStream.range(0, n).forEach(i -> pathLists[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				set.add(a[i]);
				set.add(b[i]);
				pathLists[a[i]].add(new Path(b[i], 1));
				pathLists[b[i]].add(new Path(a[i], 1));
			});
			int k = scanner.nextInt();
			int[] c = IntStream.range(0, k).map(i -> scanner.nextInt() - 1).toArray();
			if (1 == k) {
				System.out.println(1);
				return;
			}
			for (int ci : c) {
				if (!set.contains(ci)) {
					System.out.println(-1);
					return;
				}
			}
			// d[i][j]はc[i]からc[j]への最短距離
			int[][] d = new int[k][];
			IntStream.range(0, k).forEach(i -> {
				int[] t = dijkstra(pathLists, c[i], n);
				d[i] = IntStream.range(0, k).map(j -> t[c[j]]).toArray();
			});
			// dp[i][j]はiのビット表現で最後の魔法石がc[j]の個数の最小値
			int[][] dp = new int[1 << k][k];
			IntStream.range(0, 1 << k).forEach(i -> Arrays.fill(dp[i], INF));
			IntStream.range(0, k).forEach(i -> dp[1 << i][i] = 1);
			IntStream.range(2, 1 << k).forEach(i -> {
				for (int j = 0; j < k; j++) {
					if ((i & (1 << j)) > 0) {
						for (int l = 0; l < k; l++) {
							if ((j != l) && ((i & (1 << l)) > 0)) {
								dp[i][j] = Math.min(dp[i][j], dp[i - (1 << j)][l] + d[l][j]);
							}
						}
					}
				}
			});
			int ans = Arrays.stream(dp[(1 << k) - 1]).min().getAsInt();
			System.out.println((INF == ans) ? -1 : ans);
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
	private static class Path implements Comparable<Path> {
		/** 終了ノード */
		int to;
		/** 移動コスト */
		int cost;

		Path(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Path path) {
			return Integer.compare(cost, path.cost);
		}
	}
}
