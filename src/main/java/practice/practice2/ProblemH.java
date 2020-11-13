package practice.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * https://atcoder.github.io/ac-library/master/document_ja/twosat.html を参考に作成
 */
public class ProblemH {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			TwoSat ts = new TwoSat(n);
			IntStream.range(0, n - 1).forEach(i -> IntStream.range(i + 1, n).forEach(j -> {
				if (Math.abs(x[i] - x[j]) < d) {
					// cannot use both of x[i] and x[j]
					ts.addClause(i, false, j, false);
				}
				if (Math.abs(x[i] - y[j]) < d) {
					ts.addClause(i, false, j, true);
				}
				if (Math.abs(y[i] - x[j]) < d) {
					ts.addClause(i, true, j, false);
				}
				if (Math.abs(y[i] - y[j]) < d) {
					ts.addClause(i, true, j, true);
				}
			}));
			if (ts.satisfiable()) {
				System.out.println("Yes");
				IntStream.range(0, n).forEach(i -> System.out.println(ts.answer[i] ? x[i] : y[i]));
			} else {
				System.out.println("No");
			}
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/scc.hpp<br/>
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/internal_scc.hpp をもちに作成
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

		void dfs(int v, Csr g, Stack<Integer> visited, int[] low, int[] ord, int[] ids) {
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

		@SuppressWarnings("unused")
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

			LGraph(int node, int[] edges) {
				super();
				this.nodes = node;
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
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/twosat.hpp を参考に作成
	 */
	private static class TwoSat {
		/** 要素数 */
		final int n;
		/** 回答 */
		final boolean[] answer;
		final SccGraph scc;

		/**
		 * コンストラクター
		 * 
		 * @param n
		 */
		TwoSat(int n) {
			this.n = n;
			answer = new boolean[n];
			Arrays.fill(answer, false);
			scc = new SccGraph(2 * n);
		}

		/**
		 * 条件を追加
		 * 
		 * @param i
		 * @param f
		 * @param j
		 * @param g
		 */
		void addClause(int i, boolean f, int j, boolean g) {
			if (!((0 <= i) && (i < n))) {
				throw new IllegalArgumentException("i is " + i);
			}
			if (!((0 <= j) && (j < n))) {
				throw new IllegalArgumentException("j is " + j);
			}
			scc.addEdge(2 * i + (f ? 0 : 1), 2 * j + (g ? 1 : 0));
			scc.addEdge(2 * j + (g ? 0 : 1), 2 * i + (f ? 1 : 0));
		}

		/**
		 * @return 全体の条件結果
		 */
		boolean satisfiable() {
			int[] id = scc.sccIds().edges;
			for (int i = 0; i < n; i++) {
				if (id[2 * i] == id[2 * i + 1]) {
					return false;
				}
				answer[i] = id[2 * i] < id[2 * i + 1];
			}
			return true;
		}
	}
}
