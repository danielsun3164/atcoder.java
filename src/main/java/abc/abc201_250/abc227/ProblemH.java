package abc.abc201_250.abc227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc227/editorial/2915 の解説の実装<br/>
 * https://atcoder.jp/contests/abc227/submissions/27198758 にも参考
 */
public class ProblemH {

	/** マスの幅 */
	private static final int N = 3;
	/** 組合数 */
	private static final int M = 12;
	/** 最大距離 */
	private static final int INF = 10_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[][] a = IntStream.range(0, N)
					.mapToObj(i -> IntStream.range(0, N).map(j -> scanner.nextInt() * 2).toArray())
					.toArray(int[][]::new);
			int[] sum = new int[2];
			Arrays.fill(sum, 0);
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> sum[(i * N + j) & 1] += a[i][j]));
			if (sum[0] != sum[1]) {
				System.out.println("NO");
				return;
			}
			List<Edge> edges = new ArrayList<>();
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> {
				int now = i * N + j;
				if (i < N - 1) {
					edges.add(new Edge(now, now + 3));
				}
				if (j < N - 1) {
					edges.add(new Edge(now, now + 1));
				}
			}));
			for (int bit = 0; bit < (1 << M); bit++) {
				if (8 == Integer.bitCount(bit)) {
					int[] c = new int[N * N];
					IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> c[i * N + j] = a[i][j]));
					DisjointSetUnion dsu = new DisjointSetUnion(N * N);
					boolean ok = true;
					for (int i = 0; i < M; i++) {
						if (1 == ((bit >> i) & 1)) {
							if (dsu.same(edges.get(i).from, edges.get(i).to)) {
								ok = false;
								break;
							}
							dsu.merge(edges.get(i).from, edges.get(i).to);
							c[edges.get(i).from]--;
							c[edges.get(i).to]--;
						}
					}
					for (int i = 0; i < N * N; i++) {
						if (c[i] < 0) {
							ok = false;
						}
					}
					if (!ok) {
						continue;
					}
					MaxFlowGraph graph = new MaxFlowGraph(N * N + 2);
					for (int i = 0; i < M; i++) {
						if (1 == (edges.get(i).from & 1)) {
							graph.addEdge(edges.get(i).to, edges.get(i).from, INF);
						} else {
							graph.addEdge(edges.get(i).from, edges.get(i).to, INF);
						}
					}
					int s = N * N, t = s + 1;
					for (int i = 0; i < N * N; i++) {
						if (1 == (i & 1)) {
							graph.addEdge(i, t, c[i]);
						} else {
							graph.addEdge(s, i, c[i]);
						}
					}
					if (graph.flow(s, t) != sum[0] - 8) {
						continue;
					}
					@SuppressWarnings("unchecked")
					List<Edge>[] g = new List[N * N];
					IntStream.range(0, N * N).forEach(i -> g[i] = new ArrayList<>());
					int tmp = 0;
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < (1 & (bit >> i)) + graph.getEdge(i).flow; j++) {
							g[edges.get(i).from].add(new Edge(edges.get(i).to, tmp));
							g[edges.get(i).to].add(new Edge(edges.get(i).from, tmp++));
						}
					}
					int[] result = solve(g, tmp);
					StringBuilder sb = new StringBuilder();
					IntStream.range(0, result.length - 1).forEach(i -> sb.append(switch (result[i + 1] - result[i]) {
					case -1 -> 'L';
					case 1 -> 'R';
					case -3 -> 'U';
					default -> 'D';
					}));
					System.out.println(sb.toString());
					return;
				}
			}
			System.out.println("NO");
		}
	}

	/**
	 * 移動方法を計算する
	 *
	 * @param g
	 * @param m
	 * @return 移動方法
	 */
	static int[] solve(List<Edge>[] g, int m) {
		boolean[] used = new boolean[m];
		Arrays.fill(used, false);
		List<Integer> result = new ArrayList<>();
		dfs(g, used, result, 0);
		int n = result.size();
		return IntStream.range(0, n).map(i -> result.get(n - 1 - i)).toArray();
	}

	/**
	 * 終点までたどるルートを再帰的に計算する
	 *
	 * @param g      たどる可能性のあるパス一覧
	 * @param used   たどったかどうかの配列
	 * @param result 終点までたどるルート
	 * @param now    現在計算中のノード
	 */
	static void dfs(List<Edge>[] g, boolean[] used, List<Integer> result, int now) {
		for (Edge edge : g[now]) {
			if (!used[edge.to]) {
				used[edge.to] = true;
				dfs(g, used, result, edge.from);
			}
		}
		result.add(now);
	}

	/**
	 * from, toを格納するクラス
	 */
	private static class Edge {
		int from, to;

		Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/dsu.hpp のJava実装
	 */
	static class DisjointSetUnion {
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
		int size(int a) {
			if (!((0 <= a) && (a < n))) {
				throw new IllegalArgumentException("a is " + a);
			}
			return -parentOrSize[leader(a)];
		}

		/**
		 * @return グループの一覧
		 */
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

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/maxflow.hpp をもとに作成
	 */
	static class MaxFlowGraph {
		/** ノード数 */
		final int n;
		/** 辺の一覧 */
		final List<InternalEdge>[] g;
		final List<int[]> pos;

		/**
		 * コンストラクター
		 */
		MaxFlowGraph() {
			this(0);
		}

		/**
		 * コンストラクター
		 *
		 * @param n グラフのノード数
		 */
		@SuppressWarnings("unchecked")
		MaxFlowGraph(int n) {
			super();
			this.n = n;
			g = new List[n];
			IntStream.range(0, n).forEach(i -> g[i] = new ArrayList<>());
			pos = new ArrayList<>();
		}

		/**
		 * グラフに辺を追加する
		 *
		 * @param from
		 * @param to
		 * @param cap
		 * @return 追加する前の辺の数
		 */
		int addEdge(int from, int to, long cap) {
			if (!((0 <= from) && (from < n))) {
				throw new IllegalArgumentException("from is " + from);
			}
			if (!((0 <= to) && (to < n))) {
				throw new IllegalArgumentException("to is " + to);
			}
			if (!(0L <= cap)) {
				throw new IllegalArgumentException("cap is " + cap);
			}
			int m = pos.size();
			int fromId = g[from].size(), toId = g[to].size();
			pos.add(new int[] { from, fromId });
			if (from == to) {
				toId++;
			}
			g[from].add(new InternalEdge(to, toId, cap));
			g[to].add(new InternalEdge(from, fromId, 0L));
			return m;
		}

		Edge getEdge(int i) {
			if (!((0 <= i) && (i < pos.size()))) {
				throw new IllegalArgumentException("i is " + i + ", pos.size()=" + pos.size());
			}
			int[] js = pos.get(i);
			InternalEdge e = g[js[0]].get(js[1]);
			InternalEdge re = g[e.to].get(e.rev);
			return new Edge(js[0], e.to, e.cap + re.cap, re.cap);
		}

		/**
		 * すべてのパスを取得する
		 *
		 * @return すべてのパス
		 */
		List<Edge> edges() {
			return IntStream.range(0, pos.size()).mapToObj(i -> getEdge(i)).collect(Collectors.toList());
		}

		/**
		 * 辺を変更する
		 *
		 * @param i
		 * @param newCap
		 * @param newFlow
		 */
		void changeEdge(int i, long newCap, long newFlow) {
			if (!((0 <= i) && (i < pos.size()))) {
				throw new IllegalArgumentException("i is " + i + ", pos.size()=" + pos.size());
			}
			if (!((0 <= newFlow) && (newFlow < newCap))) {
				throw new IllegalArgumentException("newCap is " + newCap + ", newFlow is " + newFlow);
			}
			int[] js = pos.get(i);
			InternalEdge e = g[js[0]].get(js[1]);
			InternalEdge re = g[e.to].get(e.rev);
			e.cap = newCap - newFlow;
			re.cap = newFlow;
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

			int[] level = new int[n], iter = new int[n];
			int[] que = new int[n];

			long flow = 0;
			while (flow < flowLimit) {
				bfs(s, t, level, que);
				if (-1 == level[t]) {
					break;
				}
				Arrays.fill(iter, 0);
				long f = dfs(s, t, level, iter, flowLimit - flow);
				if (0L == f) {
					break;
				}
				flow += f;
			}
			return flow;
		}

		private void bfs(int s, int t, int[] level, int[] que) {
			Arrays.fill(level, -1);
			level[s] = 0;
			int head = 0, tail = 0;
			que[tail++] = s;
			while (head < tail) {
				int v = que[head++];
				for (InternalEdge e : g[v]) {
					if ((0 == e.cap) || (level[e.to] >= 0)) {
						continue;
					}
					level[e.to] = level[v] + 1;
					if (t == e.to) {
						return;
					}
					que[tail++] = e.to;
				}
			}
		}

		private long dfs(int s, int v, int[] level, int[] iter, long up) {
			if (v == s) {
				return up;
			}
			long res = 0;
			int levelV = level[v];
			for (int i = iter[v]; i < g[v].size(); i++) {
				InternalEdge e = g[v].get(i);
				if ((levelV <= level[e.to]) || (0 == g[e.to].get(e.rev).cap)) {
					continue;
				}
				long d = dfs(s, e.to, level, iter, Math.min(up - res, g[e.to].get(e.rev).cap));
				if (d <= 0) {
					continue;
				}
				g[v].get(i).cap += d;
				g[e.to].get(e.rev).cap -= d;
				res += d;
				if (res == up) {
					break;
				}
			}
			level[v] = n;
			return res;
		}

		/**
		 * 最小カット問題を解く
		 *
		 * @param s
		 * @return 最小カット問題の回答
		 */
		boolean[] minCut(int s) {
			if (!((0 <= s) && (s < n))) {
				throw new IllegalArgumentException("s is " + s);
			}
			boolean[] visited = new boolean[n];
			int[] que = new int[n];
			int head = 0, tail = 0;
			que[tail++] = s;
			while (head < tail) {
				int p = que[head++];
				visited[p] = true;
				for (InternalEdge e : g[p]) {
					if ((0L != e.cap) && !visited[e.to]) {
						visited[e.to] = true;
						que[tail++] = e.to;
					}
				}
			}
			return visited;
		}

		/**
		 * グラフの内部で使用する辺のクラス
		 */
		private static class InternalEdge {
			/** 宛先 */
			int to;
			/** 戻る辺は宛先の何番目の辺か */
			int rev;
			/** 容量 */
			long cap;

			InternalEdge(int to, int rev, long cap) {
				super();
				this.to = to;
				this.rev = rev;
				this.cap = cap;
			}
		}

		/**
		 * グラフのパスを表すクラス
		 */
		static class Edge {
			/** 始点 */
			int from;
			/** 終点 */
			int to;
			/** 容量 */
			long cap;
			/** フロー */
			long flow;

			Edge(int from, int to, long cap, long flow) {
				super();
				this.from = from;
				this.to = to;
				this.cap = cap;
				this.flow = flow;
			}
		}
	}
}
