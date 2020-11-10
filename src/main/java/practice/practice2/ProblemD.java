package practice.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://atcoder.github.io/ac-library/master/document_ja/maxflow.html を参考に作成
 */
public class ProblemD {

	/** 布団を置いていいマスを表す文字 */
	private static final char OK = '.';
	/** 隣り合うマスの座標の差の配列 */
	private static final int[] XS = { 0, 0, 1, -1 };
	private static final int[] YS = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			char[][] grid = new char[n][];
			IntStream.range(0, n).forEach(i -> grid[i] = scanner.next().toCharArray());

			MaxFlowGraph graph = new MaxFlowGraph(n * m + 2);
			int s = n * m, t = n * m + 1;
			IntStream.range(0, n).forEach(i -> IntStream.range(0, m).filter(j -> OK == grid[i][j]).forEach(j -> {
				int v = i * m + j;
				if (0 == ((i + j) & 1)) {
					graph.addEdge(s, v, 1L);
				} else {
					graph.addEdge(v, t, 1L);
				}
			}));
			IntStream.range(0, n)
					.forEach(i -> IntStream.range(0, m).filter(j -> (0 == ((i + j) & 1)) && (OK == grid[i][j]))
							.forEach(j -> IntStream.range(0, XS.length).forEach(k -> {
								int x = i + XS[k], y = j + YS[k];
								if ((x >= 0) && (y >= 0) && (x < n) && (y < m) && (OK == grid[x][y])) {
									graph.addEdge(i * m + j, x * m + y, 1L);
								}
							})));
			System.out.println(graph.flow(s, t));
			graph.edges().stream().filter(edge -> (s != edge.from) && (t != edge.to) && (edge.flow > 0))
					.forEach(edge -> {
						int i0 = edge.from / m, j0 = edge.from % m;
						int i1 = edge.to / m, j1 = edge.to % m;
						int iMax = Math.max(i0, i1), iMin = Math.min(i0, i1);
						int jMax = Math.max(j0, j1), jMin = Math.min(j0, j1);
						if (iMax != iMin) {
							grid[iMin][j0] = 'v';
							grid[iMax][j0] = '^';
						} else {
							grid[i0][jMin] = '>';
							grid[i0][jMax] = '<';
						}
					});
			Arrays.stream(grid).forEach(System.out::println);
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/maxflow.hpp をもとに作成
	 */
	private static class MaxFlowGraph {
		/** ノード数 */
		final int n;
		/** 辺の一覧 */
		final List<LEdge>[] g;
		final List<int[]> pos;

		/**
		 * コンストラクター
		 * 
		 * @param n グラフのノード数
		 */
		@SuppressWarnings("unchecked")
		MaxFlowGraph(int n) {
			super();
			this.n = n;
			g = IntStream.range(0, n).mapToObj(i -> new ArrayList<LEdge>()).toArray(List[]::new);
			pos = new ArrayList<>();
		}

		/**
		 * グラフに辺を追加する
		 * 
		 * @param from
		 * @param to
		 * @param cap
		 * @return
		 */
		int addEdge(int from, int to, long cap) {
			if (!((0 <= from) && (from < n))) {
				throw new IllegalArgumentException("from is " + from);
			}
			if (!((0 <= to) && (to < n))) {
				throw new IllegalArgumentException("to is " + to);
			}
			if (!(0 <= cap)) {
				throw new IllegalArgumentException("cap is " + cap);
			}
			int m = pos.size();
			pos.add(new int[] { from, g[from].size() });
			int fromId = g[from].size(), toId = g[to].size();
			if (from == to) {
				toId++;
			}
			g[from].add(new LEdge(to, toId, cap));
			g[to].add(new LEdge(from, fromId, 0L));
			return m;
		}

		Edge getEdge(int i) {
			if (!((0 <= i) && (i < pos.size()))) {
				throw new IllegalArgumentException("i is " + i + ", pos.size()=" + pos.size());
			}
			LEdge e = g[pos.get(i)[0]].get(pos.get(i)[1]);
			LEdge re = g[e.to].get(e.rev);
			return new Edge(pos.get(i)[0], e.to, e.cap + re.cap, re.cap);
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
		@SuppressWarnings("unused")
		void changeEdge(int i, long newCap, long newFlow) {
			if (!((0 <= i) && (i < pos.size()))) {
				throw new IllegalArgumentException("i is " + i + ", pos.size()=" + pos.size());
			}
			if (!((0 <= newFlow) && (newFlow < newCap))) {
				throw new IllegalArgumentException("newCap is " + newCap + ", newFlow is " + newFlow);
			}
			LEdge e = g[pos.get(i)[0]].get(pos.get(i)[1]);
			LEdge re = g[e.to].get(e.rev);
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
			IntSimpleQueue que = new IntSimpleQueue();

			long flow = 0;
			while (flow < flowLimit) {
				bfs(s, t, level, que);
				if (-1 == level[t]) {
					break;
				}
				Arrays.fill(iter, 0);
				while (flow < flowLimit) {
					long f = dfs(s, t, level, iter, flowLimit - flow);
					if (0L == f) {
						break;
					}
					flow += f;
				}
			}
			return flow;
		}

		private void bfs(int s, int t, int[] level, IntSimpleQueue que) {
			Arrays.fill(level, -1);
			level[s] = 0;
			que.clear();
			que.add(s);
			while (!que.isEmpty()) {
				int v = que.poll();
				for (LEdge e : g[v]) {
					if (0 == e.cap || level[e.to] >= 0) {
						continue;
					}
					level[e.to] = level[v] + 1;
					if (t == e.to) {
						return;
					}
					que.add(e.to);
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
				LEdge e = g[v].get(i);
				if (levelV <= level[e.to] || 0 == g[e.to].get(e.rev).cap) {
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
			return res;
		};

		/**
		 * 最小カット問題を解く
		 * 
		 * @param s
		 * @return
		 */
		@SuppressWarnings("unused")
		boolean[] minCut(int s) {
			if (!((0 <= s) && (s < n))) {
				throw new IllegalArgumentException("s is " + s);
			}
			boolean[] visited = new boolean[n];
			IntSimpleQueue que = new IntSimpleQueue();
			que.add(s);
			while (!que.isEmpty()) {
				int p = que.poll();
				visited[p] = true;
				for (LEdge e : g[p]) {
					if ((e.cap > 0) && !visited[e.to]) {
						visited[e.to] = true;
						que.add(e.to);
					}
				}
			}
			return visited;
		}

		/**
		 * グラフの内部で使用する辺のクラス
		 */
		private static class LEdge {
			/** 宛先 */
			int to;
			/** 戻る辺は宛先の何番目の辺か */
			int rev;
			/** 容量 */
			long cap;

			LEdge(int to, int rev, long cap) {
				super();
				this.to = to;
				this.rev = rev;
				this.cap = cap;
			}
		}
	}

	/**
	 * グラフのパスを表すクラス
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

		Edge(int from, int to, long cap, long flow) {
			super();
			this.from = from;
			this.to = to;
			this.cap = cap;
			this.flow = flow;
		}
	}

	/**
	 * intを扱う簡単なQueue
	 */
	private static class IntSimpleQueue {
		/** Queueにある要素数 */
		int size = 0;
		/** データを保持するための配列 */
		int[] array;

		/**
		 * コンストラクター
		 */
		public IntSimpleQueue() {
			this(10);
		}

		/**
		 * コンストラクター
		 * 
		 * @param n arrayのサイズの初期値
		 */
		IntSimpleQueue(int n) {
			array = new int[n];
		}

		/**
		 * Queueが空かどうかを取得する
		 * 
		 * @return Queueが空かどうか
		 */
		boolean isEmpty() {
			return (0 == size);
		}

		/**
		 * 要素を追加する
		 * 
		 * @param a 追加する要素
		 * @return 成功したかどうか
		 */
		boolean add(int a) {
			if (size == array.length) {
				grow(size + 5);
			}
			array[size++] = a;
			return true;
		}

		/**
		 * arrayの大きさをnewSizeに拡張する
		 * 
		 * @param newSize arrayの新しい大きさ
		 */
		private void grow(int newSize) {
			array = Arrays.copyOf(array, newSize);
		}

		/**
		 * 最初の要素を削除してから、取得する
		 * 
		 * @return 最初の要素
		 */
		int poll() {
			if (0 == size) {
				throw new NoSuchElementException();
			}
			return array[--size];
		}

		/**
		 * 最初の要素を削除せずに取得する
		 * 
		 * @return 最初の要素
		 */
		@SuppressWarnings("unused")
		int peek() {
			if (0 == size) {
				throw new NoSuchElementException();
			}
			return array[size - 1];
		}

		/**
		 * Queueの中身をクリアする
		 */
		void clear() {
			size = 0;
		}
	}
}
