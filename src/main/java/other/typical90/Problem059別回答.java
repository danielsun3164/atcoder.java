package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * 解説03 SCC+DAGの実装
 */
public class Problem059別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			SccGraph graph = new SccGraph(n);
			Path[] paths = IntStream.range(0, m).mapToObj(i -> {
				int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
				graph.addEdge(x, y);
				return new Path(x, y);
			}).sorted((u, v) -> (u.y == v.y) ? Integer.compare(u.x, u.x) : Integer.compare(u.y, v.y))
					.toArray(Path[]::new);
			DisjointSetUnion dsu = new DisjointSetUnion(n);
			Arrays.stream(graph.scc()).filter(list -> list.size() > 1)
					.forEach(list -> IntStream.range(1, list.size()).forEach(i -> dsu.merge(list.get(0), list.get(i))));
			int[] a = new int[q], b = new int[q];
			String[] answers = new String[q];
			IntStream.range(0, q).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				if (dsu.same(a[i], b[i])) {
					answers[i] = "Yes";
				}
			});
			List<Integer> indexes = new ArrayList<>();
			long[] dp = new long[n];
			for (int i = 0; i < q; i++) {
				if (null == answers[i]) {
					indexes.add(i);
				}
				if ((Long.SIZE == indexes.size()) || ((q - 1 == i) && !indexes.isEmpty())) {
					Arrays.fill(dp, 0L);
					for (int j = 0; j < indexes.size(); j++) {
						dp[a[indexes.get(j)]] |= 1L << j;
					}
					IntStream.range(0, m).forEach(j -> dp[paths[j].y] |= dp[paths[j].x]);
					for (int j = 0; j < indexes.size(); j++) {
						answers[indexes.get(j)] = (1L == (1L & (dp[b[indexes.get(j)]] >> j))) ? "Yes" : "No";
					}
					indexes.clear();
				}
			}
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answers).forEach(answer -> sb.append(answer).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Path {
		int x, y;

		Path(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/scc.hpp<br/>
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/internal_scc.hpp をもとに作成
	 */
	private static class SccGraph {
		/** ノード数 */
		final int n;
		/** 辺の一覧 */
		private final List<LEdge> edges;

		/**
		 * コンストラクター
		 *
		 * @param n ノード数
		 */
		SccGraph(int n) {
			this.n = n;
			edges = new ArrayList<>();
		}

		/**
		 * 辺を追加
		 *
		 * @param from 始点
		 * @param to   終点
		 */
		void addEdge(int from, int to) {
			if (!((0 <= from) && (from < n))) {
				throw new IllegalArgumentException("from is " + from);
			}
			if (!((0 <= to) && (to < n))) {
				throw new IllegalArgumentException("to is " + to);
			}
			edges.add(new LEdge(from, to));
		}

		int nowOrd;
		int groupNum;

		// @return pair of (# of scc, scc id)
		private LGraph sccIds() {
			Csr g = new Csr(n, edges);
			nowOrd = 0;
			groupNum = 0;
			Stack<Integer> visited = new Stack<>();
			int[] low = new int[n], ord = new int[n], ids = new int[n];
			Arrays.fill(low, 0);
			Arrays.fill(ord, -1);
			Arrays.fill(ids, 0);
			for (int i = 0; i < n; i++) {
				if (-1 == ord[i]) {
					dfs(i, g, visited, low, ord, ids);
				}
			}
			for (int i = 0; i < ids.length; i++) {
				ids[i] = groupNum - 1 - ids[i];
			}
			return new LGraph(groupNum, ids);
		}

		private void dfs(int v, Csr g, Stack<Integer> visited, int[] low, int[] ord, int[] ids) {
			low[v] = ord[v] = nowOrd++;
			visited.add(v);
			for (int i = g.start[v]; i < g.start[v + 1]; i++) {
				int to = g.elist[i];
				if (-1 == ord[to]) {
					dfs(to, g, visited, low, ord, ids);
					low[v] = Math.min(low[v], low[to]);
				} else {
					low[v] = Math.min(low[v], ord[to]);
				}
			}
			if (low[v] == ord[v]) {
				while (true) {
					int u = visited.pop();
					ord[u] = n;
					ids[u] = groupNum;
					if (u == v) {
						break;
					}
				}
				groupNum++;
			}
		}

		List<Integer>[] scc() {
			LGraph ids = sccIds();
			@SuppressWarnings("unchecked")
			List<Integer>[] groups = new List[ids.nodes];
			IntStream.range(0, groupNum).forEach(i -> groups[i] = new ArrayList<>());
			IntStream.range(0, n).forEach(i -> groups[ids.edges[i]].add(0, i));
			return groups;
		}

		/**
		 * 辺を表すクラス
		 */
		private static class LEdge {
			int from;
			int to;

			LEdge(int from, int to) {
				super();
				this.from = from;
				this.to = to;
			}
		}

		/**
		 * グラフを表すクラス
		 */
		private static class LGraph {
			int nodes;
			int[] edges;

			LGraph(int nodes, int[] edges) {
				super();
				this.nodes = nodes;
				this.edges = edges;
			}
		}

		private static class Csr {
			final int[] start;
			final int[] elist;

			Csr(int n, List<LEdge> edges) {
				start = new int[n + 1];
				Arrays.fill(start, 0);
				elist = new int[edges.size()];

				edges.forEach(edge -> start[edge.from + 1]++);
				IntStream.rangeClosed(1, n).forEach(i -> start[i] += start[i - 1]);
				int[] counter = Arrays.copyOf(start, start.length);
				edges.forEach(edge -> elist[counter[edge.from]++] = edge.to);
			}
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
			IntStream.range(0, n).forEach(i -> {
				leaderBuf[i] = leader(i);
				groupSize[leaderBuf[i]]++;
			});
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
