package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc236/editorial/3310 の実装<br/>
 * https://atcoder.jp/contests/abc236/submissions/28779195 にも参考
 */
public class ProblemG別回答2 {

	/** 30 */
	private static final int N = 30;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), t = scanner.nextInt(), l = scanner.nextInt();
			int[] u = new int[t], v = new int[t];
			IntStream.range(0, t).forEach(i -> {
				u[i] = scanner.nextInt() - 1;
				v[i] = scanner.nextInt() - 1;
			});
			int[] ng = new int[n], ok = new int[n];
			Arrays.fill(ng, -1);
			Arrays.fill(ok, t);
			while (true) {
				Queue<Edge> qs = new PriorityQueue<>(
						(x, y) -> (x.from == y.from) ? Integer.compare(x.to, y.to) : Integer.compare(x.from, y.from));
				for (int i = 0; i < n; i++) {
					if (ng[i] + 1 < ok[i]) {
						qs.add(new Edge((ng[i] + ok[i]) / 2, i));
					}
				}
				if (qs.isEmpty()) {
					break;
				}

				BitSet[][] a = new BitSet[N][n], at = new BitSet[N][n];
				IntStream.range(0, N).forEach(i -> IntStream.range(0, n).forEach(j -> {
					a[i][j] = new BitSet(n);
					at[i][j] = new BitSet(n);
				}));
				for (int i = 0; i < t; i++) {
					if (qs.isEmpty()) {
						break;
					}
					dfs(a, at, 0, u[i], v[i]);
					if (qs.peek().from == i) {
						BitSet v1 = get(n, l, at);
						while ((qs.size() > 0) && (qs.peek().from == i)) {
							int j = qs.poll().to;
							if (v1.get(j)) {
								ok[j] = i;
							} else {
								ng[j] = i;
							}
						}
					}
				}
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append((t == ok[i]) ? -1 : ok[i] + 1).append((i < n - 1) ? " " : "");
			}
			System.out.println(sb.toString());
		}
	}

	private static void dfs(BitSet[][] a, BitSet[][] at, int t, int i, int j) {
		int n = a[0].length;
		if (!a[t][i].get(j)) {
			a[t][i].set(j);
			at[t][j].set(i);
			if (t == N - 1) {
				return;
			}
			{
				BitSet s1 = (BitSet) a[t][j].clone(), s2 = (BitSet) a[t + 1][i].clone();
				s2.flip(0, n);
				s1.and(s2);
				for (int k = s1.nextSetBit(0); k >= 0; k = s1.nextSetBit(k + 1)) {
					dfs(a, at, t + 1, i, k);
				}
			}
			{
				BitSet s1 = (BitSet) at[t][i].clone(), s2 = (BitSet) at[t + 1][j].clone();
				s2.flip(0, n);
				s1.and(s2);
				for (int h = s1.nextSetBit(0); h >= 0; h = s1.nextSetBit(h + 1)) {
					dfs(a, at, t + 1, h, j);
				}
			}
		}
	}

	private static BitSet get(int n, int l, BitSet[][] at) {
		BitSet v1 = new BitSet(n), v2 = null;
		v1.set(0, true);
		for (int b = 0; b < N; b += 2) {
			if ((l & (1 << b)) > 0) {
				v2 = new BitSet(n);
				for (int i = 0; i < n; i++) {
					BitSet t = (BitSet) at[b + 0][i].clone();
					t.and(v1);
					v2.set(i, t.nextSetBit(0) >= 0);
				}
			} else {
				v2 = v1;
			}
			if ((l & (1 << (b + 1))) > 0) {
				v1 = new BitSet(n);
				for (int i = 0; i < n; i++) {
					BitSet t = (BitSet) at[b + 1][i].clone();
					t.and(v2);
					v1.set(i, t.nextSetBit(0) >= 0);
				}
			} else {
				v1 = v2;
			}
		}
		return v1;
	}

	/**
	 * from,toを格納するクラス
	 */
	private static class Edge {
		int from, to;

		Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}
}
