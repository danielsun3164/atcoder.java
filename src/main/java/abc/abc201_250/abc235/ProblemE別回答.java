package abc.abc201_250.abc235;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc235/editorial/3258 の実装<br/>
 * https://atcoder.jp/contests/abc235/submissions/28552787 にも参考
 */
public class ProblemE別回答 {

	/** 深さの最大値 */
	private static final int N = 20;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			Edge[] edges = IntStream.range(0, m)
					.mapToObj(i -> new Edge(scanner.nextInt() - 1, scanner.nextInt() - 1, scanner.nextInt()))
					.sorted((x, y) -> Integer.compare(x.cost, y.cost)).toArray(Edge[]::new);
			boolean[] saishou = new boolean[m];
			Arrays.fill(saishou, false);
			int count = kurasukaru(n, edges, saishou);
			Edge[] newEdges = new Edge[count << 1];
			int index = 0;
			for (int i = 0; i < m; i++) {
				if (saishou[i]) {
					newEdges[index] = edges[i];
					newEdges[count + (index++)] = new Edge(edges[i].to, edges[i].from, edges[i].cost);
				}
			}
			Arrays.sort(newEdges,
					(x, y) -> (x.from == y.from) ? Integer.compare(x.to, y.to) : Integer.compare(x.from, y.from));
			int[] id = new int[n + 1];
			int p = 0, m2 = count << 1;
			for (int i = 0; i < n; i++) {
				while ((p < m2) && (newEdges[p].from < i)) {
					p++;
				}
				id[i] = p;
			}
			id[n] = m2;
			int[] depth = new int[n];
			int[][] parents = new int[N][n], ws = new int[N][n];
			lcaInit(n, 0, id, newEdges, depth, parents, ws);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1, w = scanner.nextInt();
				sb.append(w < lcaWeight(u, v, depth, parents, ws) ? "Yes" : "No").append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 辺の一覧から最小全域木を作成する
	 *
	 * @param n       ノードの数
	 * @param edges   辺の一覧
	 * @param saishou 辺が使われるかどうかの一覧
	 * @return 使われた辺の数
	 */
	private static int kurasukaru(int n, Edge[] edges, boolean[] saishou) {
		DisjointSetUnion dsu = new DisjointSetUnion(n);
		return IntStream.range(0, edges.length).filter(i -> !dsu.same(edges[i].from, edges[i].to)).map(i -> {
			dsu.merge(edges[i].from, edges[i].to);
			saishou[i] = true;
			return 1;
		}).sum();
	}

	/**
	 * 最小共通祖先の初期化を行う
	 *
	 * @param n       ノードの数
	 * @param root    ルートのノード
	 * @param id      idの一覧
	 * @param edges   辺の一覧
	 * @param depth   深さの一覧
	 * @param parents 親の一覧
	 * @param ws      辺の重みの一覧
	 */
	private static void lcaInit(int n, int root, int[] id, Edge[] edges, int[] depth, int[][] parents, int[][] ws) {
		depth[root] = 1;
		lcaInitDfs(root, id, edges, depth, parents, ws);
		IntStream.range(1, N).forEach(i -> IntStream.range(0, n).forEach(v -> {
			parents[i][v] = parents[i - 1][parents[i - 1][v]];
			ws[i][v] = Math.max(ws[i - 1][v], ws[i - 1][parents[i - 1][v]]);
		}));
	}

	/**
	 * 最小共通祖先の初期化を再帰的に行う
	 *
	 * @param v       現在処理中のノード
	 * @param id      idの一覧
	 * @param edges   辺の一覧
	 * @param depth   深さの一覧
	 * @param parents 親の一覧
	 * @param ws      辺の重みの一覧
	 */
	private static void lcaInitDfs(int v, int[] id, Edge[] edges, int[] depth, int[][] parents, int[][] ws) {
		IntStream.range(id[v], id[v + 1]).filter(i -> 0 == depth[edges[i].to]).forEach(i -> {
			parents[0][edges[i].to] = v;
			ws[0][edges[i].to] = edges[i].cost;
			depth[edges[i].to] = depth[v] + 1;
			lcaInitDfs(edges[i].to, id, edges, depth, parents, ws);
		});
	}

	/**
	 * uとvの重みを計算する
	 *
	 * @param u
	 * @param v
	 * @param depth   深さの一覧
	 * @param parents 親の一覧
	 * @param ws      辺の重みの一覧
	 * @return uとvの重み
	 */
	private static int lcaWeight(int u, int v, int[] depth, int[][] parents, int[][] ws) {
		int du = depth[u], dv = depth[v];
		if (du < dv) {
			int t = du;
			du = dv;
			dv = t;
			t = u;
			u = v;
			v = t;
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (1 == (1 & ((du - dv) >> i))) {
				answer = Math.max(answer, ws[i][u]);
				u = parents[i][u];
			}
		}
		if (u == v) {
			return answer;
		}
		for (int i = N - 1; i >= 0; i--) {
			if (parents[i][u] != parents[i][v]) {
				answer = Math.max(answer, Math.max(ws[i][u], ws[i][v]));
				u = parents[i][u];
				v = parents[i][v];
			}
		}
		return Math.max(answer, Math.max(ws[0][u], ws[0][v]));
	}

	/**
	 * from,to,costを格納するクラス
	 */
	private static class Edge {
		int from, to, cost;

		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/dsu.hpp のJava実装
	 */
	private static class DisjointSetUnion {
		/** 項目数 */
		final int n;
		/** 親のidかグループのサイズ */
		final int[] parentOrSize;
		/** グループの数 */
		int groupNum;

		/**
		 * コンストラクター
		 *
		 * @param n 項目数
		 */
		DisjointSetUnion(int n) {
			if (!(0 <= n)) {
				throw new IllegalArgumentException("n is " + n);
			}
			this.n = n;
			parentOrSize = new int[n];
			Arrays.fill(parentOrSize, -1);
			groupNum = n;
		}

		/**
		 * aとbを同じグループにマージする
		 *
		 * @param a
		 * @param b
		 * @return マージ後のグループリーダー
		 */
		int merge(int a, int b) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (!((0 <= b) && (b < n))) {
				throw new IllegalArgumentException("b is " + b);
			}
			int x = leader(a), y = leader(b);
			if (x == y) {
				return x;
			}
			int max = (-parentOrSize[x] < -parentOrSize[y]) ? y : x;
			int min = (-parentOrSize[x] < -parentOrSize[y]) ? x : y;
			parentOrSize[max] += parentOrSize[min];
			parentOrSize[min] = max;
			groupNum--;
			return max;
		}

		/**
		 * aとbが同じグループに所属しているかを判定する
		 *
		 * @param a
		 * @param b
		 * @return aとbが同じグループに所属しているか
		 */
		boolean same(int a, int b) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (!((0 <= b) && (b < n))) {
				throw new IllegalArgumentException("b is " + b);
			}
			return leader(a) == leader(b);
		}

		/**
		 * aのグループリーダーを取得する
		 *
		 * @param a
		 * @return aのグループリーダー
		 */
		int leader(int a) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			if (parentOrSize[a] < 0) {
				return a;
			}
			return parentOrSize[a] = leader(parentOrSize[a]);
		}

		/**
		 * aの所属グループのメンバー数を取得する
		 *
		 * @param a
		 * @return aの所属グループのメンバー数
		 */
		@SuppressWarnings("unused")
		int size(int a) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			return -parentOrSize[leader(a)];
		}

		/**
		 * @return グループの一覧
		 */
		@SuppressWarnings("unused")
		int[][] groups() {
			// leaderBuf[i]はiのリーダー、groupSize[i]はiの所在groupのサイズ
			int[] leaderBuf = new int[n], groupSize = new int[n];
			for (int i = 0; i < n; i++) {
				leaderBuf[i] = leader(i);
				groupSize[leaderBuf[i]]++;
			}
			Set<Integer> leaderSet = new HashSet<>();
			int count = 0;
			// groupNo[i]はiの所在グループの番号、groupLeader[i]はグループiのリーダー
			int[] groupNo = new int[n], groupLeader = new int[groupNum];
			for (int i = 0; i < n; i++) {
				if (!leaderSet.contains(leaderBuf[i])) {
					groupNo[leaderBuf[i]] = count;
					groupLeader[count] = leaderBuf[i];
					count++;
					leaderSet.add(leaderBuf[i]);
				}
				groupNo[i] = groupNo[leaderBuf[i]];
			}
			int[] indexes = new int[groupNum];
			int[][] result = new int[groupNum][];
			for (int i = 0; i < groupNum; i++) {
				result[i] = new int[groupSize[groupLeader[i]]];
			}
			Arrays.fill(indexes, 0);
			for (int i = 0; i < n; i++) {
				result[groupNo[i]][indexes[groupNo[i]]++] = i;
			}
			return result;
		}
	}
}
