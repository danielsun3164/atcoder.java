package other.typical90;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * Atcoder LibraryのMaxFlowのJava実装ではTLEが発生するため、https://atcoder.jp/contests/typical90/submissions/23831125 の実装を利用
 */
public class Problem077 {

	/** X座標の差分の一覧 */
	private static final int[] DX = new int[] { 1, 1, 0, -1, -1, -1, 0, 1 };
	/** Y座標の差分の一覧 */
	private static final int[] DY = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		InputReader scanner = new InputReader(System.in);
		int n = scanner.nextInt();
		long t = scanner.nextLong();
		long[] ax = new long[n], ay = new long[n];
		IntStream.range(0, n).forEach(i -> {
			ax[i] = scanner.nextLong();
			ay[i] = scanner.nextLong();
		});
		Map<Long, Integer> bMap = new HashMap<>();
		IntStream.rangeClosed(1, n).forEach(i -> {
			long bx = scanner.nextLong(), by = scanner.nextLong();
			bMap.put((bx << Integer.SIZE) | by, i);
		});
		int[][] nex = new int[n][DX.length];
		IntStream.range(0, n).forEach(i -> Arrays.fill(nex[i], 0));
		MaxFlow graph = new MaxFlow((n << 1) + 5);
		IntStream.range(0, n).forEach(i -> {
			IntStream.range(0, DX.length).forEach(j -> {
				long nax = ax[i] + t * DX[j], nay = ay[i] + t * DY[j];
				if ((nax >= 0L) && (nay >= 0L)) {
					long na = (nax << Integer.SIZE) | nay;
					if (bMap.containsKey(na)) {
						nex[i][j] = bMap.get(na);
						graph.addEdge(i + 1, n + nex[i][j], 1);
					}
				}
			});
		});
		IntStream.rangeClosed(1, n).forEach(i -> graph.addEdge((n << 1) + 1, i, 1));
		IntStream.rangeClosed(1, n).forEach(i -> graph.addEdge(i + n, (n << 1) + 2, 1));
		if (graph.maxFlow((n << 1) + 1, (n << 1) + 2) != n) {
			System.out.println("No");
			return;
		}
		int[] d = new int[n];
		graph.getEdges().stream().filter(e -> 1 == e.getFlow()).forEach(e -> {
			int to = e.to, from = e.from - 1;
			if ((to >= n + 1) && (to <= (n << 1)) && (from >= 0) && (from < n)) {
				IntStream.range(0, DX.length).filter(k -> nex[from][k] == to - n).forEach(k -> d[from] = k + 1);
			}
		});
		System.out.println("Yes");
		System.out.println(Arrays.stream(d).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

	/**
	 * https://atcoder.jp/contests/typical90/submissions/23831125 を参考に作成
	 */
	static class InputReader {
		private InputStream in;
		private byte[] buffer = new byte[1024];
		private int curbuf;
		private int lenbuf;

		public InputReader(InputStream in) {
			this.in = in;
			curbuf = lenbuf = 0;
		}

		public boolean hasNextByte() {
			if (curbuf >= lenbuf) {
				curbuf = 0;
				try {
					lenbuf = in.read(buffer);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0) {
					return false;
				}
			}
			return true;
		}

		private int readByte() {
			if (hasNextByte()) {
				return buffer[curbuf++];
			} else {
				return -1;
			}
		}

		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		private void skip() {
			while (hasNextByte() && isSpaceChar(buffer[curbuf])) {
				curbuf++;
			}
		}

		public boolean hasNext() {
			skip();
			return hasNextByte();
		}

		public String next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (!isSpaceChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public int nextInt() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			int c = readByte();
			while (isSpaceChar(c)) {
				c = readByte();
			}
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}

		public long nextLong() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			int c = readByte();
			while (isSpaceChar(c)) {
				c = readByte();
			}
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public double[] nextDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}

		public long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}

		public char[][] nextCharMap(int n, int m) {
			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = next().toCharArray();
			}
			return map;
		}
	}

	/**
	 * https://atcoder.jp/contests/typical90/submissions/23831125 を参考に作成
	 */
	private static class MaxFlow {
		public class CapEdge {
			final int from, to;
			long cap;
			final int rev;

			CapEdge(int from, int to, long cap, int rev) {
				this.from = from;
				this.to = to;
				this.cap = cap;
				this.rev = rev;
			}

			public long getFlow() {
				return g[to][rev].cap;
			}
		}

		private static final long INF = Long.MAX_VALUE;

		private final int n;
		private int m;
		private final List<CapEdge> edges;
		private final int[] count;
		private final CapEdge[][] g;

		MaxFlow(int n) {
			this.n = n;
			edges = new ArrayList<>();
			count = new int[n];
			g = new CapEdge[n][];
		}

		public int addEdge(int from, int to, long cap) {
			rangeCheck(from, 0, n);
			rangeCheck(to, 0, n);
			nonNegativeCheck(cap, "Capacity");
			CapEdge e = new CapEdge(from, to, cap, count[to]);
			count[from]++;
			count[to]++;
			edges.add(e);
			return m++;
		}

		@SuppressWarnings("unused")
		CapEdge getEdge(int i) {
			rangeCheck(i, 0, m);
			return edges.get(i);
		}

		List<CapEdge> getEdges() {
			return edges;
		}

		@SuppressWarnings("unused")
		void changeEdge(int i, long newCap, long newFlow) {
			rangeCheck(i, 0, m);
			nonNegativeCheck(newCap, "Capacity");
			if (newFlow > newCap) {
				throw new IllegalArgumentException(
						String.format("Flow %d is greater than capacity %d.", newCap, newFlow));
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
				g[e.to][idx[e.to]++] = new CapEdge(e.to, e.from, 0, idx[e.from]);
				g[e.from][idx[e.from]++] = e;
			}
		}

		long maxFlow(int s, int t) {
			return flow(s, t, INF);
		}

		long flow(int s, int t, long flowLimit) {
			rangeCheck(s, 0, n);
			rangeCheck(t, 0, n);
			buildGraph();
			long flow = 0;
			int[] level = new int[n];
			int[] que = new int[n];
			int[] iter = new int[n];
			while (true) {
				Arrays.fill(level, -1);
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
			int hd = 0, tl = 0;
			que[tl++] = s;
			level[s] = 0;
			while (tl > hd) {
				int u = que[hd++];
				for (CapEdge e : g[u]) {
					int v = e.to;
					if (e.cap <= 0 || level[v] >= 0) {
						continue;
					}
					level[v] = level[u] + 1;
					if (v == t) {
						return;
					}
					que[tl++] = v;
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
			rangeCheck(s, 0, n);
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

		private void rangeCheck(int i, int minInlusive, int maxExclusive) {
			if (i < 0 || i >= maxExclusive) {
				throw new IndexOutOfBoundsException(
						String.format("Index %d out of bounds for length %d", i, maxExclusive));
			}
		}

		private void nonNegativeCheck(long cap, java.lang.String attribute) {
			if (cap < 0) {
				throw new IllegalArgumentException(String.format("%s %d is negative.", attribute, cap));
			}
		}
	}
}
