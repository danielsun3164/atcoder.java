package abc.abc201_250.abc241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3452 の実装<br/>
 * https://atcoder.jp/contests/abc241/submissions/29665512 にも参考
 */
public class ProblemG {

	/** 勝ち */
	private static final int WIN = 1;
	/** 負け */
	private static final int LOOSE = 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[][] f = new int[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(f[i], 0));
			IntStream.range(0, m).forEach(i -> {
				int w = scanner.nextInt() - 1, l = scanner.nextInt() - 1;
				f[w][l] = WIN;
				f[l][w] = LOOSE;
			});
			int nn = n * n, nn2 = n * (n - 1) / 2;
			Data[] datas = new Data[nn];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> datas[i * n + j] = new Data(i, j)));
			List<Integer> answer = new ArrayList<>();
			IntStream.range(0, n).forEach(i -> {
				int[][] g = new int[n][];
				IntStream.range(0, n).forEach(j -> g[j] = f[j].clone());
				IntStream.range(0, n).filter(j -> (i != j) && (g[i][j] == 0)).forEach(j -> {
					g[i][j] = WIN;
					g[j][i] = LOOSE;
				});
				int win = (int) IntStream.range(0, n).filter(j -> (i != j) && (WIN == g[i][j])).count();
				if (win > 0) {
					int s = nn + n, t = nn + n + 1;
					MaxFlowGraph mfg = new MaxFlowGraph(nn + n + 2);
					IntStream.range(0, n).forEach(j -> IntStream.range(j + 1, n).forEach(k -> {
						int p = lowerBound(datas, new Data(j, k));
						if (0 == g[j][k]) {
							mfg.addEdge(p, nn + j, 1);
							mfg.addEdge(p, nn + k, 1);
						} else if (WIN == g[j][k]) {
							mfg.addEdge(p, nn + j, 1);
						} else {
							mfg.addEdge(p, nn + k, 1);
						}
					}));
					IntStream.range(0, nn).forEach(j -> mfg.addEdge(s, j, 1));
					IntStream.range(0, n).forEach(j -> mfg.addEdge(nn + j, t, (i == j) ? win : win - 1));
					if (mfg.flow(s, t) == nn2) {
						answer.add(i + 1);
					}
				}
			});
			System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	private static int lowerBound(Data[] datas, Data value) {
		int index = Arrays.binarySearch(datas, value);
		return (index < 0) ? ~index : index;
	}

	/**
	 * x,y を格納するクラス
	 */
	private static class Data implements Comparable<Data> {
		int x, y;

		Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Data data) {
				return (x == data.x) && (y == data.y);
			}
			return super.equals(obj);
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public int compareTo(Data o) {
			return (x == o.x) ? Integer.compare(y, o.y) : Integer.compare(x, o.x);
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
			this.n = n;
			g = new List[n];
			for (int i = 0; i < n; i++) {
				g[i] = new ArrayList<>();
			}
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

			int[] level = new int[n], iter = new int[n], que = new int[n];
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
				this.to = to;
				this.rev = rev;
				this.cap = cap;
			}
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
			this.from = from;
			this.to = to;
			this.cap = cap;
			this.flow = flow;
		}
	}
}
