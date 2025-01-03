package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem021 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			SccGraph graph = new SccGraph(n);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				graph.addEdge(a, b);
			});
			List<Integer>[] scc = graph.scc();
			System.out.println(Arrays.stream(scc).mapToLong(list -> (list.size() * (list.size() - 1L)) / 2L).sum());
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
			for (int i = 0; i < groupNum; i++) {
				groups[i] = new ArrayList<>();
			}
			for (int i = 0; i < n; i++) {
				groups[ids.edges[i]].add(0, i);
			}
			return groups;
		}

		/**
		 * 辺を表すクラス
		 */
		private static class LEdge {
			int from;
			int to;

			LEdge(int from, int to) {
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

				for (LEdge edge : edges) {
					start[edge.from + 1]++;
				}
				for (int i = 1; i <= n; i++) {
					start[i] += start[i - 1];
				}
				int[] counter = Arrays.copyOf(start, start.length);
				for (LEdge edge : edges) {
					elist[counter[edge.from]++] = edge.to;
				}
			}
		}
	}
}
