package abc.abc201_250.abc239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc239/editorial/3438 の実装<br/>
 * https://atcoder.jp/contests/abc239/submissions/29476670 にも参考
 */
public class ProblemE別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			CoordinateCompress cc = new CoordinateCompress(IntStream.range(0, n).map(i -> scanner.nextInt()).toArray());
			int[] x = cc.compressedX, a = new int[n - 1], b = new int[n - 1];
			IntStream.range(0, n - 1).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
			});
			HeavyLightDecomposition hld = new HeavyLightDecomposition(new AdjacencyList(n, a, b, true));
			int[] xx = IntStream.range(0, n).map(i -> x[hld.f[i]]).toArray();
			WaveletMatrix rq = new WaveletMatrix(n, xx);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int v = scanner.nextInt() - 1, k = scanner.nextInt();
				Path w = hld.subTree(v);
				k = w.to - w.from - k;
				sb.append(cc.realValue(rq.getKthSmallest(w.from, w.to, k))).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 座標圧縮するためのクラス
	 */
	private static class CoordinateCompress {
		int[] sortedX, compressedX;

		CoordinateCompress(int[] x) {
			sortedX = Arrays.stream(x).sorted().distinct().toArray();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, sortedX.length).forEach(i -> map.put(sortedX[i], i));
			compressedX = Arrays.stream(x).map(xi -> map.get(xi)).toArray();
		}

		int realValue(int x) {
			return sortedX[x];
		}
	}

	/**
	 * 隣接関係リスト
	 */
	private static class AdjacencyList {
		int n;
		int[] e, f;

		AdjacencyList(int n) {
			this.n = n;
		}

		AdjacencyList(int n, int[] a, int[] b, boolean reverse) {
			this.n = n;
			f = new int[n + 1];
			Arrays.fill(f, 0);
			IntStream.range(0, a.length).forEach(i -> {
				f[a[i]]++;
				if (reverse) {
					f[b[i]]++;
				}
			});
			IntStream.rangeClosed(1, n).forEach(i -> f[i] += f[i - 1]);
			e = new int[f[n]];
			IntStream.iterate(a.length - 1, i -> i >= 0, i -> i - 1).forEach(i -> {
				e[--f[a[i]]] = b[i];
				if (reverse) {
					e[--f[b[i]]] = a[i];
				}
			});
		}

		@SuppressWarnings("unused")
		AdjacencyList(List<Integer>[] edges) {
			n = edges.length;
			f = new int[n + 1];
			Arrays.fill(f, 0);
			IntStream.range(0, n).forEach(i -> f[i + 1] = f[i] + edges[i].size());
			e = new int[f[n]];
			IntStream.range(0, n)
					.forEach(i -> IntStream.range(0, edges[i].size()).forEach(j -> e[f[i] + j] = edges[i].get(j)));
		}

		int[] get(int u) {
			return Arrays.copyOfRange(e, f[u], f[u + 1]);
		}

		@SuppressWarnings("unused")
		int verticesSize() {
			return n;
		}

		@SuppressWarnings("unused")
		int edgesSize() {
			return e.length;
		}

		@SuppressWarnings("unused")
		AdjacencyList reversedEdges() {
			AdjacencyList result = new AdjacencyList(n);
			result.f = new int[n + 1];
			Arrays.fill(f, 0);
			for (int ei : e) {
				f[ei]++;
			}
			IntStream.rangeClosed(1, n).forEach(i -> f[i] += f[i - 1]);
			result.e = new int[result.f[n]];
			IntStream.range(0, n).forEach(u -> Arrays.stream(get(u)).forEach(v -> result.e[--f[v]] = u));
			return result;
		}
	}

	/**
	 * HL分解
	 */
	private static class HeavyLightDecomposition {
		int n;
		int[] p, pp, pd, d, f, rangeL, rangeR;

		HeavyLightDecomposition(AdjacencyList list) {
			n = list.n;
			int[] buffer = new int[n + 1];
			Arrays.fill(buffer, 0);
			p = new int[n];
			Arrays.fill(p, -1);
			f = new int[n];
			f[0] = 0;
			int fSize = 1;
			for (int i = 0; i < fSize; i++) {
				int fi = f[i];
				for (int e : list.get(fi)) {
					if (p[fi] != e) {
						f[fSize++] = e;
						p[e] = fi;
					}
				}
			}
			int[] z = new int[n], nx = new int[n];
			Arrays.fill(z, 1);
			Arrays.fill(nx, -1);
			pp = IntStream.range(0, n).toArray();
			IntStream.iterate(n - 1, i -> i >= 1, i -> i - 1).forEach(i -> {
				int fi = f[i];
				z[p[fi]] += z[fi];
				if (-1 == nx[p[fi]]) {
					nx[p[fi]] = fi;
				}
				if (z[nx[p[fi]]] < z[fi]) {
					nx[p[fi]] = fi;
				}
			});
			IntStream.range(0, fSize).filter(i -> nx[f[i]] != -1).forEach(i -> pp[nx[f[i]]] = f[i]);

			pd = new int[n];
			Arrays.fill(pd, n);
			pd[0] = 0;
			d = new int[n];
			Arrays.fill(d, 0);
			IntStream.range(0, fSize).filter(i -> f[i] != 0).forEach(i -> {
				pp[f[i]] = pp[pp[f[i]]];
				pd[f[i]] = Math.min(pd[pp[f[i]]], pd[p[f[i]]] + 1);
				d[f[i]] = d[p[f[i]]] + 1;
			});

			rangeL = new int[n];
			Arrays.fill(rangeL, 0);
			rangeR = new int[n];
			Arrays.fill(rangeR, 0);
			Deque<Integer> que = new ArrayDeque<>();
			que.addLast(0);
			while (!que.isEmpty()) {
				int now = que.pollLast();
				int ir = rangeR[now] = rangeL[now] + z[now];
				for (int e : list.get(now)) {
					if ((e != p[now]) && (e != nx[now])) {
						rangeL[e] = (ir -= z[e]);
						que.addLast(e);
					}
				}
				if (-1 != nx[now]) {
					rangeL[nx[now]] = rangeL[now] + 1;
					que.addLast(nx[now]);
				}
			}
			IntStream.range(0, n).forEach(i -> f[rangeL[i]] = i);
		}

		@SuppressWarnings("unused")
		int depth(int p) {
			return d[p];
		}

		int toSeq(int vertex) {
			return rangeL[vertex];
		}

		int toVertex(int seqIndex) {
			return f[seqIndex];
		}

		@SuppressWarnings("unused")
		int parentOf(int v) {
			return p[v];
		}

		@SuppressWarnings("unused")
		int heavyChildOf(int v) {
			if (n - 1 == toSeq(v)) {
				return -1;
			}
			int cand = toVertex(toSeq(v) + 1);
			if (pp[v] == pp[cand]) {
				return cand;
			}
			return v;
		}

		int lca(int u, int v) {
			if (pd[u] < pd[v]) {
				int temp = u;
				u = v;
				v = temp;
			}
			while (pd[u] > pd[v]) {
				u = p[pp[u]];
			}
			while (pp[u] != pp[v]) {
				u = p[pp[u]];
				v = p[pp[v]];
			}
			return (d[u] > d[v]) ? v : u;
		}

		@SuppressWarnings("unused")
		int dist(int u, int v) {
			return d[u] + d[v] - (d[lca(u, v)] << 1);
		}

		@SuppressWarnings("unused")
		List<Path> path(int r, int c, boolean includeRoot, boolean reversePath) {
			if (pd[c] < pd[r]) {
				return Collections.emptyList();
			}
			List<Path> result = new ArrayList<>(pd[c] - pd[r] + 1);
			for (int i = 0; i < pd[c] - pd[r]; i++) {
				result.add(new Path(rangeL[pp[c]], rangeL[c] + 1));
				c = p[pp[c]];
			}
			if ((pp[r] != pp[c]) || (d[r] > d[c])) {
				return Collections.emptyList();
			}
			result.set(result.size() - 1, new Path(rangeL[r] + (includeRoot ? 0 : 1), rangeL[c] + 1));
			Path last = result.get(result.size() - 1);
			if (last.from == last.to) {
				result.remove(result.size() - 1);
			}
			if (!reversePath) {
				Collections.reverse(result);
			} else {
				for (Path path : result) {
					int temp = path.from;
					path.from = n - path.to;
					path.to = n - temp;
				}
			}
			return result;
		}

		Path subTree(int p) {
			return new Path(rangeL[p], rangeR[p]);
		}

		@SuppressWarnings("unused")
		int median(int x, int y, int z) {
			return lca(x, y) ^ lca(y, z) ^ lca(x, z);
		}
	}

	private static class Path {
		int from, to;

		Path(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	private static class WaveletMatrix {
		/** 64 */
		private static final int N = Long.SIZE;

		int n, s, logS;
		WordBlock[][] table;

		WaveletMatrix(int maxValue, int[] a) {
			s = 1;
			logS = 0;
			n = a.length;
			while (s < maxValue) {
				s <<= 1;
				logS++;
			}
			table = new WordBlock[logS][];
			for (int d = logS - 1; d >= 0; d--) {
				table[d] = new WordBlock[n / N + 2];
				for (int i = 0; i < n / N + 2; i++) {
					table[d][i] = new WordBlock(0L, 0);
				}
				for (int i = 0; i < n; i++) {
					table[d][i / N].table |= (1L & (a[i] >> d)) << (i % N);
				}
				for (int i = 1; i <= n / N + 1; i++) {
					table[d][i].ptr = table[d][i - 1].ptr + Long.bitCount(table[d][i - 1].table);
				}
				int[] buffer = new int[n];
				int size = 0;
				for (int b : new int[] { 0, 1 << d }) {
					for (int ai : a) {
						if (b == (ai & (1 << d))) {
							buffer[size++] = ai;
						}
					}
				}
				a = Arrays.copyOfRange(buffer, 0, size);
			}
		}

		int getLevelRank(int level, int p) {
			return table[level][p / N].ptr + Long.bitCount(table[level][p / N].table & ~((~0L) << (p % N)));
		}

		int getLeftPointer(int level, int p) {
			return p - getLevelRank(level, p);
		}

		int getRightPointer(int level, int p) {
			return n - table[level][table[level].length - 1].ptr + getLevelRank(level, p);
		}

		@SuppressWarnings("unused")
		int get(int p) {
			int result = 0;
			for (int d = logS - 1; d >= 0; d--) {
				result <<= 1;
				if (0L != (table[d][p / N].table & (1L << (p % N)))) {
					result |= 1;
					p = getRightPointer(d, p);
				} else {
					p = getLeftPointer(d, p);
				}
			}
			return result;
		}

		@SuppressWarnings("unused")
		int count(int l, int r, int value) {
			for (int d = logS - 1; d >= 0; d--) {
				if (0 != (value & (1 << d))) {
					l = getRightPointer(d, l);
					r = getRightPointer(d, r);
				} else {
					l = getLeftPointer(d, l);
					r = getLeftPointer(d, r);
				}
			}
			return r - l;
		}

		int getKthSmallest(int l, int r, int k) {
			int result = 0;
			for (int d = logS - 1; d >= 0; d--) {
				result <<= 1;
				int zeroCount = r - l - getLevelRank(d, r) + getLevelRank(d, l);
				if (k < zeroCount) {
					l = getLeftPointer(d, l);
					r = getLeftPointer(d, r);
				} else {
					result++;
					k -= zeroCount;
					l = getRightPointer(d, l);
					r = getRightPointer(d, r);
				}
			}
			return result;
		}

		private static class WordBlock {
			long table;
			int ptr;

			WordBlock(long table, int ptr) {
				this.table = table;
				this.ptr = ptr;
			}
		}
	}
}
