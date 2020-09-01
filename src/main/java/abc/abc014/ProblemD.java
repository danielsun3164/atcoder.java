package abc.abc014;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc014/submissions/4722902 を参考に作成
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] lists = new List[n];
			IntStream.range(0, n).forEach(i -> lists[i] = new ArrayList<>());
			IntStream.range(1, n).forEach(i -> {
				int x = scanner.nextInt() - 1;
				int y = scanner.nextInt() - 1;
				lists[x].add(y);
				lists[y].add(x);
			});
			Lca lca = new Lca(n, lists, 0);
			int q = scanner.nextInt();
			int[] a = new int[q], b = new int[q];
			IntStream.range(0, q).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
			});
			IntStream.range(0, q).forEach(i -> System.out
					.println(lca.depths[a[i]] + lca.depths[b[i]] - 2 * lca.depths[lca.get(a[i], b[i])] + 1));
		}
	}

	/**
	 * LCAを計算するクラス
	 */
	private static class Lca {
		List<Integer>[] lists;
		int[] depths;
		int[][] parents;
		int log2_n;

		Lca(int n, List<Integer>[] lists, int root) {
			this.lists = lists;
			depths = new int[n];
			log2_n = (int) (Math.log(n) / Math.log(2)) + 1;
			parents = new int[log2_n][n];

			dfs(root, -1, 0);
			IntStream.range(1, log2_n).forEach(i -> IntStream.range(0, n).forEach(j -> {
				if (parents[i - 1][j] < 0) {
					parents[i][j] = -1;
				} else {
					parents[i][j] = parents[i - 1][parents[i - 1][j]];
				}
			}));
		}

		/**
		 * ノードの深さを再帰的に計算
		 * 
		 * @param current 現在処理しているノード
		 * @param parent  親ノード
		 * @param depth   深さ
		 */
		private void dfs(int current, int parent, int depth) {
			parents[0][current] = parent;
			depths[current] = depth;
			// 隣接するノードの計算
			lists[current].stream().filter(i -> (i != parent)).forEach(i -> dfs(i, current, depth + 1));
		}

		/**
		 * @param from
		 * @param to
		 * @return fromとtoの共通の深さ
		 */
		int get(int from, int to) {
			if (depths[from] > depths[to]) {
				return get(to, from);
			}
			for (int k = 0; k < log2_n; k++) {
				if (((depths[to] - depths[from]) >> k & 1) == 1) {
					to = parents[k][to];
				}
			}
			if (from == to)
				return from;
			for (int k = log2_n - 1; k >= 0; k--) {
				if (parents[k][from] != parents[k][to]) {
					from = parents[k][from];
					to = parents[k][to];
				}
			}
			return parents[0][from];
		}
	}
}
