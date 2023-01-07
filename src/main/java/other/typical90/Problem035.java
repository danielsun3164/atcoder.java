package other.typical90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem035 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			Lca lca = new Lca(edges);
			int q = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int k = scanner.nextInt();
				int[] v = IntStream.range(0, k).map(j -> scanner.nextInt() - 1).boxed()
						.sorted((a, b) -> Integer.compare(lca.ids[a], lca.ids[b])).mapToInt(j -> j).toArray();
				sb.append(IntStream.range(0, k).map(j -> lca.depths[v[j]] - lca.depths[lca.get(v[j], v[(j + 1) % k])])
						.sum()).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * LCAのクラス
	 */
	private static class Lca {
		/** log(n) */
		private int l;
		/** ノードの数 */
		int n;
		/** 親の配列 */
		int[][] parents;
		/** ノード0から各ノードへのステップ数 */
		int[] depths;
		/** ノード0から各ノードへのアクセス順番 */
		int[] ids;
		/** 辺の一覧 */
		List<Integer>[] edges;
		/** idのカウンター */
		private int id = 0;

		/**
		 * コンストラクター
		 *
		 * @param edges 辺の一覧
		 */
		Lca(List<Integer>[] edges) {
			n = edges.length;
			l = 0;
			while ((1 << l) < n) {
				l++;
			}
			parents = new int[l][n];
			depths = new int[n];
			ids = new int[n];
			this.edges = edges;
			init();
		}

		/**
		 * 各ノードを再帰的初期化
		 *
		 * @param now   現在のノード
		 * @param pre   遷移元のノード
		 * @param depth ステップ数
		 */
		void dfs(int now, int pre, int depth) {
			parents[0][now] = pre;
			depths[now] = depth;
			ids[now] = id++;
			for (int next : edges[now]) {
				if (next != pre) {
					dfs(next, now, depth + 1);
				}
			}
		}

		/**
		 * 初期化処理
		 */
		private void init() {
			dfs(0, 0, 0);
			IntStream.range(0, l - 1)
					.forEach(i -> IntStream.range(0, n).forEach(j -> parents[i + 1][j] = parents[i][parents[i][j]]));
		}

		/**
		 * aとbの共通の親を取得する
		 *
		 * @param a
		 * @param b
		 * @return aとbの共通の親
		 */
		int get(int a, int b) {
			if (depths[a] > depths[b]) {
				return get(b, a);
			}
			int gap = depths[b] - depths[a];
			for (int i = l - 1; i >= 0; i--) {
				int len = 1 << i;
				if (gap >= len) {
					gap -= len;
					b = parents[i][b];
				}
			}
			if (a == b) {
				return a;
			}
			for (int i = l - 1; i >= 0; i--) {
				int na = parents[i][a];
				int nb = parents[i][b];
				if (na != nb) {
					a = na;
					b = nb;
				}
			}
			return parents[0][a];
		}

		/**
		 * aからbへの移動ステップ数を取得する
		 *
		 * @param a
		 * @param b
		 * @return aからbへの移動ステップ数
		 */
		@SuppressWarnings("unused")
		int dist(int a, int b) {
			return depths[a] + depths[b] - 2 * depths[get(a, b)];
		}
	}
}
