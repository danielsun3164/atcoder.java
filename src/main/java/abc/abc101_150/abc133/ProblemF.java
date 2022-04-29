package abc.abc101_150.abc133;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc133/submissions/15583598 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Edge>[] edgeLists = new List[n];
			IntStream.range(0, n).forEach(i -> edgeLists[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.nextInt(), d = scanner.nextInt();
				edgeLists[a].add(new Edge(b, c, d));
				edgeLists[b].add(new Edge(a, c, d));
			});
			Lca lca = new Lca(edgeLists);
			@SuppressWarnings("unchecked")
			List<Query>[] queryLists = new List[n];
			long[] answers = new long[q];
			IntStream.range(0, n).forEach(i -> queryLists[i] = new ArrayList<>());
			IntStream.range(0, q).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt(), u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				int c = lca.get(u, v);
				answers[i] = lca.cost(u, v);
				queryLists[u].add(new Query(x, i, 1, y));
				queryLists[v].add(new Query(x, i, 1, y));
				queryLists[c].add(new Query(x, i, -2, y));
			});
			int[] sums = new int[n], counts = new int[n];
			Arrays.fill(sums, 0);
			Arrays.fill(counts, 0);
			dfs2(0, -1, edgeLists, queryLists, sums, counts, answers);
			Arrays.stream(answers).forEach(System.out::println);
		}
	}

	/**
	 * 各問いの結果を計算する
	 *
	 * @param now        現在の処理対象のノード
	 * @param pre        遷移元のノード
	 * @param edgeLists  辺の一覧
	 * @param queryLists 問いの一覧
	 * @param sums
	 * @param counts
	 * @param answers    計算結果
	 */
	private static void dfs2(int now, int pre, final List<Edge>[] edgeLists, final List<Query>[] queryLists, int[] sums,
			int[] counts, long[] answers) {
		for (Query q : queryLists[now]) {
			long x = (long) q.y * counts[q.color] - sums[q.color];
			answers[q.qid] += x * q.coeff;
		}
		for (Edge e : edgeLists[now]) {
			if (e.to != pre) {
				counts[e.color]++;
				sums[e.color] += e.cost;
				dfs2(e.to, now, edgeLists, queryLists, sums, counts, answers);
				counts[e.color]--;
				sums[e.color] -= e.cost;
			}
		}
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge {
		/** 宛先 */
		int to;
		/** 色 */
		int color;
		/** コスト */
		int cost;

		Edge(int to, int color, int cost) {
			super();
			this.to = to;
			this.color = color;
			this.cost = cost;
		}
	}

	/**
	 * 問いを表すクラス
	 */
	private static class Query {
		/** 色 */
		int color;
		/** 番号 */
		int qid;
		int coeff;
		/** 変更後のコスト */
		int y;

		Query(int color, int qid, int coeff, int y) {
			this.color = color;
			this.qid = qid;
			this.coeff = coeff;
			this.y = y;
		}
	}

	/**
	 * LCAのクラス
	 */
	private static class Lca {
		/** log(n) */
		int l;
		/** ノードの数 */
		int n;
		/** 親の配列 */
		int[][] parents;
		/** ノード0から各ノードへのステップ数 */
		int[] dists;
		/** ノード0から各ノードへの距離 */
		int[] costs;
		/** 辺の一覧 */
		List<Edge>[] edgeLists;

		/**
		 * コンストラクター
		 *
		 * @param edgeLists 辺の一覧
		 */
		Lca(List<Edge>[] edgeLists) {
			n = edgeLists.length;
			l = 0;
			while ((1 << l) < n) {
				l++;
			}
			parents = new int[n][l];
			dists = new int[n];
			costs = new int[n];
			this.edgeLists = edgeLists;
			init();
		}

		/**
		 * 各ノードを再帰的初期化
		 *
		 * @param now  現在のノード
		 * @param pre  遷移元のノード
		 * @param dist ステップ数
		 * @param cost コスト
		 */
		void dfs(int now, int pre, int dist, int cost) {
			if (pre != -1) {
				parents[now][0] = pre;
			}
			dists[now] = dist;
			costs[now] = cost;
			for (Edge e : edgeLists[now]) {
				if (e.to != pre) {
					dfs(e.to, now, dist + 1, cost + e.cost);
				}
			}
		}

		/**
		 * 初期化処理
		 */
		private void init() {
			dfs(0, -1, 0, 0);
			IntStream.range(0, l - 1)
					.forEach(i -> IntStream.range(0, n).forEach(j -> parents[j][i + 1] = parents[parents[j][i]][i]));
		}

		/**
		 * aとbの共通の親を取得する
		 *
		 * @param a
		 * @param b
		 * @return aとbの共通の親
		 */
		int get(int a, int b) {
			if (dists[a] > dists[b]) {
				return get(b, a);
			}
			int gap = dists[b] - dists[a];
			for (int i = l - 1; i >= 0; i--) {
				int len = 1 << i;
				if (gap >= len) {
					gap -= len;
					b = parents[b][i];
				}
			}
			if (a == b) {
				return a;
			}
			for (int i = l - 1; i >= 0; i--) {
				int na = parents[a][i];
				int nb = parents[b][i];
				if (na != nb) {
					a = na;
					b = nb;
				}
			}
			return parents[a][0];
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
			return dists[a] + dists[b] - 2 * dists[get(a, b)];
		}

		/**
		 * aからbへの移動コストを取得する
		 *
		 * @param a
		 * @param b
		 * @return aからbへの移動コスト
		 */
		int cost(int a, int b) {
			return costs[a] + costs[b] - 2 * costs[get(a, b)];
		}
	}
}
