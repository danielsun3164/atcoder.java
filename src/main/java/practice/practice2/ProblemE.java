package practice.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://atcoder.github.io/ac-library/master/document_ja/mincostflow.html を参考に作成
 */
public class ProblemE {

	/** 計算用の最大値 */
	private static final long INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();

			/**
			 * generate (s -> row -> column -> t) graph<br/>
			 * i-th row correspond to vertex i i-th col correspond to vertex n + i
			 **/
			MinCostFlow graph = new MinCostFlow(2 * n + 2);
			int s = 2 * n, t = 2 * n + 1;

			graph.addEdge(s, t, n * k, INF);
			IntStream.range(0, n).forEach(i -> {
				graph.addEdge(s, i, k, 0L);
				graph.addEdge(n + i, t, k, 0L);
			});
			IntStream.range(0, n).forEach(
					i -> IntStream.range(0, n).forEach(j -> graph.addEdge(i, n + j, 1L, INF - scanner.nextLong())));

			Result result = graph.flow(s, t, n * k);
			System.out.println(1L * n * k * INF - result.cost);

			char[][] grid = new char[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(grid[i], '.'));
			graph.edges().stream().filter(edge -> (s != edge.from) && (t != edge.to) && (edge.flow > 0L))
					.forEach(edge -> grid[edge.from][edge.to - n] = 'X');
			Arrays.stream(grid).forEach(System.out::println);
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/mincostflow.hpp をもとに作成
	 */
	private static class MinCostFlow {
		/** ノード数 */
		final int n;
		/** 各ノードからの辺の一覧 */
		final List<LEdge>[] g;
		final List<int[]> pos;

		/**
		 * コンストラクター
		 * 
		 * @param n ノード数
		 */
		@SuppressWarnings("unchecked")
		MinCostFlow(int n) {
			super();
			this.n = n;
			g = IntStream.range(0, n).mapToObj(i -> new ArrayList<LEdge>()).toArray(List[]::new);
			pos = new ArrayList<>();
		}

		/**
		 * 辺を追加
		 * 
		 * @param from 始点
		 * @param to   終点
		 * @param cap  容量
		 * @param cost コスト
		 * @return 辺のインデックス
		 */
		int addEdge(int from, int to, long cap, long cost) {
			if (!((0 <= from) && (from < n))) {
				throw new IllegalArgumentException("from is " + from);
			}
			if (!((0 <= to) && (to < n))) {
				throw new IllegalArgumentException("to is " + to);
			}
			if (!(0 <= cap)) {
				throw new IllegalArgumentException("cap is " + cap);
			}
			if (!(0 <= cost)) {
				throw new IllegalArgumentException("cost is " + cost);
			}
			int m = pos.size();
			pos.add(new int[] { from, g[from].size() });
			int fromId = g[from].size();
			int toId = g[to].size();
			if (from == to) {
				toId++;
			}
			g[from].add(new LEdge(to, toId, cap, cost));
			g[to].add(new LEdge(from, fromId, 0L, -cost));
			return m;
		}

		/**
		 * i番目のパスを取得する
		 * 
		 * @param i
		 * @return i番目のパス
		 */
		Edge getEdge(int i) {
			if (!((0 <= i) && (i < pos.size()))) {
				throw new IllegalArgumentException("i is " + i + ", pos.size() is " + pos.size());
			}
			LEdge e = g[pos.get(i)[0]].get(pos.get(i)[1]);
			LEdge re = g[e.to].get(e.rev);
			return new Edge(pos.get(i)[0], e.to, e.cap + re.cap, re.cap, e.cost);
		}

		/**
		 * パスの一覧を取得する
		 * 
		 * @return パスの一覧
		 */
		List<Edge> edges() {
			return IntStream.range(0, pos.size()).mapToObj(i -> getEdge(i)).collect(Collectors.toList());
		}

		@SuppressWarnings("unused")
		Result flow(int s, int t) {
			return flow(s, t, Long.MAX_VALUE);
		}

		Result flow(int s, int t, long flowLimit) {
			List<Result> result = slope(s, t, flowLimit);
			return result.get(result.size() - 1);
		}

		@SuppressWarnings("unused")
		List<Result> slope(int s, int t) {
			return slope(s, t, Long.MAX_VALUE);
		}

		List<Result> slope(int s, int t, long flowLimit) {
			if (!((0 <= s) && (s < n))) {
				throw new IllegalArgumentException("s is " + s);
			}
			if (!((0 <= t) && (t < n))) {
				throw new IllegalArgumentException("t is " + t);
			}
			if (!(s != t)) {
				throw new IllegalArgumentException("s is " + s + ", t is " + t);
			}

			// variants (C = maxcost):
			// -(n-1)C <= dual[s] <= dual[i] <= dual[t] = 0
			// reduced cost (= e.cost + dual[e.from] - dual[e.to]) >= 0 for all edge
			long[] dual = new long[n], dist = new long[n];
			int[] pv = new int[n], pe = new int[n];
			boolean[] vis = new boolean[n];
			Arrays.fill(dual, 0L);
			long flow = 0L, cost = 0L, prevCostPerFlow = -1L;
			List<Result> result = new ArrayList<>();
			result.add(new Result(flow, cost));
			while (flow < flowLimit) {
				if (!dualRef(s, t, dual, dist, pv, pe, vis)) {
					break;
				}
				long c = flowLimit - flow;
				for (int v = t; v != s; v = pv[v]) {
					c = Math.min(c, g[pv[v]].get(pe[v]).cap);
				}
				for (int v = t; v != s; v = pv[v]) {
					LEdge e = g[pv[v]].get(pe[v]);
					e.cap -= c;
					g[v].get(e.rev).cap += c;
				}
				long d = -dual[s];
				flow += c;
				cost += c * d;
				if (prevCostPerFlow == d) {
					result.remove(result.size() - 1);
				}
				result.add(new Result(flow, cost));
				prevCostPerFlow = d;
			}
			return result;
		}

		boolean dualRef(int s, int t, long[] dual, long[] dist, int[] pv, int[] pe, boolean[] vis) {
			Arrays.fill(dist, Long.MAX_VALUE);
			Arrays.fill(pv, -1);
			Arrays.fill(pe, -1);
			Arrays.fill(vis, false);
			Queue<Q> que = new PriorityQueue<>();
			dist[s] = 0L;
			que.add(new Q(0L, s));
			while (!que.isEmpty()) {
				int v = que.poll().to;
				if (vis[v]) {
					continue;
				}
				vis[v] = true;
				if (v == t) {
					break;
				}
				// dist[v] = shortest(s, v) + dual[s] - dual[v]
				// dist[v] >= 0 (all reduced cost are positive)
				// dist[v] <= (n-1)C
				for (int i = 0; i < g[v].size(); i++) {
					LEdge e = g[v].get(i);
					if (vis[e.to] || (0L == e.cap)) {
						continue;
					}
					// |-dual[e.to] + dual[v]| <= (n-1)C
					// cost <= C - -(n-1)C + 0 = nC
					long cost = e.cost - dual[e.to] + dual[v];
					if (dist[e.to] - dist[v] > cost) {
						dist[e.to] = dist[v] + cost;
						pv[e.to] = v;
						pe[e.to] = i;
						que.add(new Q(dist[e.to], e.to));
					}
				}
			}
			if (!vis[t]) {
				return false;
			}

			for (int v = 0; v < n; v++) {
				if (!vis[v]) {
					continue;
				}
				// dual[v] = dual[v] - dist[t] + dist[v]
				// = dual[v] - (shortest(s, t) + dual[s] - dual[t]) + (shortest(s, v) + dual[s] - dual[v])
				// = - shortest(s, t) + dual[t] + shortest(s, v)
				// = shortest(s, v) - shortest(s, t) >= 0 - (n-1)C
				dual[v] -= dist[t] - dist[v];
			}
			return true;
		}

		/**
		 * 内部用の辺を表すクラス
		 */
		private static class LEdge {
			/** 終点 */
			int to;
			/** 戻る辺は宛先の何番目の辺か */
			int rev;
			/** 容量 */
			long cap;
			/** コスト */
			long cost;

			/**
			 * コンストラクター
			 * 
			 * @param to
			 * @param rev
			 * @param cap
			 * @param cost
			 */
			LEdge(int to, int rev, long cap, long cost) {
				super();
				this.to = to;
				this.rev = rev;
				this.cap = cap;
				this.cost = cost;
			}
		}

		private static class Q implements Comparable<Q> {
			long key;
			int to;

			Q(long key, int to) {
				super();
				this.key = key;
				this.to = to;
			}

			@Override
			public int compareTo(Q q) {
				return Long.compare(key, q.key);
			}
		}
	}

	/**
	 * パスを表すクラス
	 */
	private static class Edge {
		/** 始点 */
		int from;
		/** 終点 */
		int to;
		/** 容量 */
		@SuppressWarnings("unused")
		long cap;
		/** フロー */
		long flow;
		/** コスト */
		@SuppressWarnings("unused")
		long cost;

		/**
		 * コンストラクター
		 * 
		 * @param from
		 * @param to
		 * @param cap
		 * @param flow
		 * @param cost
		 */
		Edge(int from, int to, long cap, long flow, long cost) {
			super();
			this.from = from;
			this.to = to;
			this.cap = cap;
			this.flow = flow;
			this.cost = cost;
		}
	}

	/**
	 * 計算結果を表すクラス
	 */
	private static class Result {
		/** 容量 */
		@SuppressWarnings("unused")
		long cap;
		/** コスト */
		long cost;

		/**
		 * コンストラクター
		 * 
		 * @param cap
		 * @param cost
		 */
		Result(long cap, long cost) {
			super();
			this.cap = cap;
			this.cost = cost;
		}
	}
}
