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
 * https://atcoder.jp/contests/abc236/submissions/28747672 にも参考<br/>
 * TLE対策のため、ストリームAPIを使用しない
 */
public class ProblemG別回答1 {

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

				BitSet[] a = new BitSet[n];
				IntStream.range(0, n).forEach(i -> a[i] = new BitSet(n));
				for (int i = 0; i < t; i++) {
					if (qs.isEmpty()) {
						break;
					}
					a[u[i]].set(v[i], true);
					if (qs.peek().from == i) {
						BitSet[] c = pow(a, l);
						while ((qs.size() > 0) && (qs.peek().from == i)) {
							int j = qs.poll().to;
							if (c[0].get(j)) {
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

	/**
	 * 行列aと行列bの掛け算を計算する
	 *
	 * @param a
	 * @param b
	 * @return 行列aと行列bの掛け算結果
	 */
	private static BitSet[] multiply(BitSet[] a, BitSet[] b) {
		int n = a.length;
		BitSet[] c = new BitSet[n];
		IntStream.range(0, n).forEach(i -> c[i] = new BitSet(n));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i].get(j)) {
					c[i].or(b[j]);
				}
			}
		}
		return c;
	}

	/**
	 * 行列aのmべき乗を計算する
	 *
	 * @param a
	 * @param m
	 * @return 行列aのmべき乗
	 */
	private static BitSet[] pow(BitSet[] a, int m) {
		int n = a.length;
		BitSet[] c = new BitSet[n];
		for (int i = 0; i < n; i++) {
			c[i] = new BitSet(n);
			c[i].set(i, true);
		}
		while (m > 0) {
			if (1 == (1 & m)) {
				c = multiply(a, c);
			}
			m >>= 1;
			if (m > 0) {
				a = multiply(a, a);
			}
		}
		return c;
	}

	/**
	 * from,toを格納するクラス
	 */
	private static class Edge {
		int from, to;

		Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
}
