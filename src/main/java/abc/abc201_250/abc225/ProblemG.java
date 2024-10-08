package abc.abc201_250.abc225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc225/editorial/2854 の実装
 */
public class ProblemG {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			long c = scanner.nextLong();
			int s = h * w, t = s + 1;
			MaxFlowGraph graph = new MaxFlowGraph(t + 1);
			long[][] a = new long[h][w];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> {
				a[i][j] = scanner.nextLong();
				int now = i * w + j;
				graph.addEdge(s, now, a[i][j]);
				if ((i > 0) && (j > 0)) {
					int next = (i - 1) * w + j - 1;
					graph.addEdge(now, t, 0L);
					graph.addEdge(now, next, c);
				} else {
					graph.addEdge(now, t, c);
				}
				if ((i > 0) && (j + 1 < w)) {
					int next = (i - 1) * w + j + 1;
					graph.addEdge(now, t, 0L);
					graph.addEdge(now, next, c);
				} else {
					graph.addEdge(now, t, c);
				}
			}));
			long answer = IntStream.range(0, h).mapToLong(i -> IntStream.range(0, w).mapToLong(j -> a[i][j]).sum())
					.sum();
			System.out.println(answer - graph.flow(s, t));
		}
	}

	/**
	 * https://atcoder.jp/contests/typical90/submissions/23831125 をもとに作成
	 *
	 * 本家のライブラリーより実行速度が速いため、念のため残す（制約：flowは一回しか実行できない）
	 */
	private static class MaxFlowGraph {
		class CapEdge {
			final int from, to;
			private long cap;
			final int rev;

			CapEdge(int from, int to, long cap, int rev) {
				this.from = from;
				this.to = to;
				this.cap = cap;
				this.rev = rev;
			}

			@SuppressWarnings("unused")
			long getCap() {
				return cap + getFlow();
			}

			long getFlow() {
				return g[to][rev].cap;
			}
		}

		private final int n;
		private int m;
		private final List<CapEdge> edges;
		private final int[] count;
		private final CapEdge[][] g;

		/**
		 * コンストラクター
		 */
		public MaxFlowGraph(int n) {
			this.n = n;
			edges = new ArrayList<>();
			count = new int[n];
			g = new CapEdge[n][];
		}

		public int addEdge(int from, int to, long cap) {
			if (!((0 <= from) && (from < n))) {
				throw new IllegalArgumentException("from is " + from);
			}
			if (!((0 <= to) && (to < n))) {
				throw new IllegalArgumentException("to is " + to);
			}
			if (!(0L <= cap)) {
				throw new IllegalArgumentException("cap is " + cap);
			}
			CapEdge e = new CapEdge(from, to, cap, count[to]);
			count[from]++;
			count[to]++;
			edges.add(e);
			return m++;
		}

		@SuppressWarnings("unused")
		CapEdge getEdge(int i) {
			if (!((0 <= i) && (i < m))) {
				throw new IllegalArgumentException("i is " + i + ", m=" + m);
			}
			return edges.get(i);
		}

		@SuppressWarnings("unused")
		List<CapEdge> edges() {
			return edges;
		}

		@SuppressWarnings("unused")
		void changeEdge(int i, long newCap, long newFlow) {
			if (!((0 <= i) && (i < m))) {
				throw new IllegalArgumentException("i is " + i + ", m=" + m);
			}
			if (!((0 <= newFlow) && (newFlow < newCap))) {
				throw new IllegalArgumentException("newCap is " + newCap + ", newFlow is " + newFlow);
			}
			CapEdge e = edges.get(i);
			CapEdge er = g[e.to][e.rev];
			e.cap = newCap - newFlow;
			er.cap = newFlow;
		}

		private void buildGraph() {
			for (int i = 0; i < n; i++) {
				g[i] = new CapEdge[count[i]];
			}
			int[] idx = new int[n];
			Arrays.fill(idx, 0);
			for (CapEdge e : edges) {
				g[e.to][idx[e.to]++] = new CapEdge(e.to, e.from, 0L, idx[e.from]);
				g[e.from][idx[e.from]++] = e;
			}
		}

		long flow(int s, int t) {
			return flow(s, t, Long.MAX_VALUE);
		}

		long flow(int s, int t, long flowLimit) {
			if (!((0 <= s) && (s < n))) {
				throw new IllegalArgumentException("s is " + s);
			}
			if (!((0 <= t) && (t < n))) {
				throw new IllegalArgumentException("t is " + t);
			}
			if (!(s != t)) {
				throw new IllegalArgumentException("s is " + s + ", t is " + t);
			}
			buildGraph();
			long flow = 0;
			int[] level = new int[n], que = new int[n], iter = new int[n];
			while (true) {
				bfs(s, t, level, que);
				if (level[t] < 0) {
					return flow;
				}
				Arrays.fill(iter, 0);
				while (true) {
					long d = dfs(t, s, flowLimit - flow, iter, level);
					if (d <= 0) {
						break;
					}
					flow += d;
				}
			}
		}

		private void bfs(int s, int t, int[] level, int[] que) {
			Arrays.fill(level, -1);
			int head = 0, tail = 0;
			que[tail++] = s;
			level[s] = 0;
			while (tail > head) {
				int u = que[head++];
				for (CapEdge e : g[u]) {
					int v = e.to;
					if (e.cap <= 0 || level[v] >= 0) {
						continue;
					}
					level[v] = level[u] + 1;
					if (v == t) {
						return;
					}
					que[tail++] = v;
				}
			}
		}

		private long dfs(int cur, int s, long f, int[] iter, int[] level) {
			if (cur == s) {
				return f;
			}
			long res = 0;
			while (iter[cur] < count[cur]) {
				CapEdge er = g[cur][iter[cur]++];
				int u = er.to;
				CapEdge e = g[u][er.rev];
				if (level[u] >= level[cur] || e.cap <= 0) {
					continue;
				}
				long d = dfs(u, s, Math.min(f - res, e.cap), iter, level);
				if (d <= 0) {
					continue;
				}
				e.cap -= d;
				er.cap += d;
				res += d;
				if (res == f) {
					break;
				}
			}
			return res;
		}

		@SuppressWarnings("unused")
		boolean[] minCut(int s) {
			if (!((0 <= s) && (s < n))) {
				throw new IllegalArgumentException("s is " + s);
			}
			boolean[] reachable = new boolean[n];
			int[] stack = new int[n];
			int ptr = 0;
			stack[ptr++] = s;
			reachable[s] = true;
			while (ptr > 0) {
				int u = stack[--ptr];
				for (CapEdge e : g[u]) {
					int v = e.to;
					if (reachable[v] || e.cap <= 0) {
						continue;
					}
					reachable[v] = true;
					stack[ptr++] = v;
				}
			}
			return reachable;
		}
	}
}
