package abc.abc201_250.abc210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc210/submissions/24383319 にも参考
 */
public class ProblemF {

	/** カードに書かれている数字の最大値 */
	private static final int MAX_VALUE = 2_000_005;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] divisor = maked(MAX_VALUE);
			// 素因子pが関わる面を記録するmap
			Map<Integer, List<Data>> memo = new HashMap<>();
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					int a = scanner.nextInt();
					for (Integer p : primeFactor(a, divisor)) {
						List<Data> list = memo.get(p);
						if (null == list) {
							list = new ArrayList<>();
							memo.put(p, list);
						}
						list.add(new Data(i, j));
						count++;
					}
				}
			}
			TwoSat ts = new TwoSat(count * 2);
			int pos = 0;
			for (Entry<Integer, List<Data>> entry : memo.entrySet()) {
				List<Data> v = entry.getValue();
				for (int i = 0; i < v.size(); i++) {
					// (v[i]ならばcount+posが真) <=> not v[i] or count+pos
					ts.addClause(v.get(i).index, 0 == v.get(i).omote, count + pos, true);
					if (i > 0) {
						// (count+pos-1が真ならばcount+posが真) <=> not count+pos-1 or count+pos
						ts.addClause(count + pos - 1, false, count + pos, true);
						// not(count+pos-1が真かつv[i]) <=> not v[i] or not count+pos-1
						ts.addClause(v.get(i).index, 0 == v.get(i).omote, count + pos - 1, false);
					}
					pos++;
				}
			}
			System.out.println(ts.satisfiable() ? "Yes" : "No");
		}
	}

	/**
	 * nまでの最初の因数の配列を計算する
	 *
	 * @param n
	 * @return nまでの最初の因数の配列
	 */
	private static int[] maked(int n) {
		int[] divisor = new int[n + 1];
		Arrays.fill(divisor, 0);
		divisor[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (0 == divisor[i]) {
				for (int j = i; j <= n; j += i) {
					if (0 == divisor[j]) {
						divisor[j] = i;
					}
				}
			}
		}
		return divisor;
	}

	/**
	 * 数字nの素数の因数の一覧を計算する
	 *
	 * @param n
	 * @param divisor 最初の因数の配列
	 * @return 数字nの素数の因数の一覧
	 */
	private static List<Integer> primeFactor(int n, int[] divisor) {
		List<Integer> result = new ArrayList<>();
		while (1 != n) {
			int p = divisor[n];
			result.add(p);
			while (p == divisor[n]) {
				n /= p;
			}
		}
		return result;
	}

	/**
	 * indexとomoteを格納するクラス
	 */
	private static class Data {
		int index;
		int omote;

		Data(int index, int omote) {
			this.index = index;
			this.omote = omote;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/twosat.hpp をもとに作成
	 */
	private static class TwoSat {
		/** 要素数 */
		final int n;
		/** 回答 */
		final boolean[] answer;
		final InternalScc scc;

		/**
		 * コンストラクター
		 */
		@SuppressWarnings("unused")
		TwoSat() {
			n = 0;
			answer = new boolean[n];
			scc = new InternalScc(2 * n);
		}

		/**
		 * コンストラクター
		 *
		 * @param n
		 */
		TwoSat(int n) {
			this.n = n;
			answer = new boolean[n];
			Arrays.fill(answer, false);
			scc = new InternalScc(2 * n);
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
			int[] id = scc.sccIds();
			for (int i = 0; i < n; i++) {
				if (id[2 * i] == id[2 * i + 1]) {
					return false;
				}
				answer[i] = id[2 * i] < id[2 * i + 1];
			}
			return true;
		}

		/**
		 * https://github.com/NASU41/AtCoderLibraryForJava/blob/master/2SAT/TwoSAT.java を参考に作成
		 */
		private static final class EdgeList {
			long[] a;
			int ptr = 0;

			EdgeList(int cap) {
				a = new long[cap];
			}

			void add(int upper, int lower) {
				if (ptr == a.length) {
					grow();
				}
				a[ptr++] = (long) upper << 32 | lower;
			}

			void grow() {
				long[] b = new long[a.length << 1];
				System.arraycopy(a, 0, b, 0, a.length);
				a = b;
			}
		}

		private static final class InternalScc {
			final int n;
			final EdgeList unorderedEdges;
			final int[] start;
			int m;
			private static final long MASK = 0xFFFF_FFFFL;

			InternalScc(int n) {
				this.n = n;
				unorderedEdges = new EdgeList(n);
				start = new int[n + 1];
				m = 0;
			}

			void addEdge(int from, int to) {
				unorderedEdges.add(from, to);
				start[from + 1]++;
				m++;
			}

			int[] sccIds() {
				for (int i = 1; i <= n; i++) {
					start[i] += start[i - 1];
				}
				int[] orderedEdges = new int[m];
				int[] count = new int[n + 1];
				System.arraycopy(start, 0, count, 0, n + 1);
				for (int i = 0; i < m; i++) {
					long e = unorderedEdges.a[i];
					orderedEdges[count[(int) (e >>> 32)]++] = (int) (e & MASK);
				}
				int nowOrd = 0, groupNum = 0, k = 0;
				int[] par = new int[n], vis = new int[n], low = new int[n], ord = new int[n];
				Arrays.fill(ord, -1);
				int[] ids = new int[n];
				long[] stack = new long[n];
				int ptr = 0;
				for (int i = 0; i < n; i++) {
					if (ord[i] >= 0) {
						continue;
					}
					par[i] = -1;
					stack[ptr++] = i;
					while (ptr > 0) {
						long p = stack[--ptr];
						int u = (int) (p & MASK);
						int j = (int) (p >>> 32);
						if (j == 0) {
							low[u] = ord[u] = nowOrd++;
							vis[k++] = u;
						}
						if (start[u] + j < count[u]) {
							int to = orderedEdges[start[u] + j];
							stack[ptr++] += 1L << 32;
							if (ord[to] == -1) {
								stack[ptr++] = to;
								par[to] = u;
							} else {
								low[u] = Math.min(low[u], ord[to]);
							}
						} else {
							while (j-- > 0) {
								int to = orderedEdges[start[u] + j];
								if (par[to] == u) {
									low[u] = Math.min(low[u], low[to]);
								}
							}
							if (low[u] == ord[u]) {
								while (true) {
									int v = vis[--k];
									ord[v] = n;
									ids[v] = groupNum;
									if (v == u) {
										break;
									}
								}
								groupNum++;
							}
						}
					}
				}
				for (int i = 0; i < n; i++) {
					ids[i] = groupNum - 1 - ids[i];
				}
				return ids;
			}
		}
	}
}