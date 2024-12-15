package abc.abc201_250.abc238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc238/editorial/3377 の実装<br/>
 * https://atcoder.jp/contests/abc238/submissions/29086825 にも参考
 */
public class ProblemG別回答2 {

	/** 10^3 */
	private static final int B = 1_000;
	/** 10^6 */
	private static final int MAX = 1_000_000;
	/** 3 */
	private static final int N = 3;
	private static boolean[] ok;
	private static int[] mu, pf, pr, big;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			init();
			int[] ps = Arrays.stream(pr).filter(i -> i < B).toArray();
			int m = ps.length;
			int[][] tb = new int[m][n + 1];
			IntStream.range(0, m).forEach(i -> Arrays.fill(tb[i], 0));
			big = new int[n];
			Arrays.fill(big, -1);
			IntStream.range(0, n).forEach(i -> {
				int x = a[i];
				for (int j = 0; j < m; j++) {
					tb[j][i + 1] = tb[j][i];
					while (0 == x % ps[j]) {
						tb[j][i + 1]++;
						x /= ps[j];
					}
				}
				if (1 != x) {
					big[i] = x;
				}
			});
			int[] l = new int[q], r = new int[q];
			IntStream.range(0, q).forEach(i -> {
				l[i] = scanner.nextInt() - 1;
				r[i] = scanner.nextInt();
			});
			Mo mo = new Mo(n, l, r);
			ok = new boolean[q];
			Arrays.fill(ok, true);
			IntStream.range(0, q).forEach(i -> {
				for (int j = 0; j < m; j++) {
					if (tb[j][r[i]] % N != tb[j][l[i]] % N) {
						ok[i] = false;
						break;
					}
				}
			});
			mo.build();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> sb.append(ok[i] ? "Yes" : "No").append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 初期化を行う
	 */
	private static void init() {
		BitSet isPrime = new BitSet(MAX + 1);
		isPrime.set(2, MAX + 1, true);
		mu = new int[MAX + 1];
		pf = new int[MAX + 1];
		List<Integer> primes = new ArrayList<>();
		IntStream.rangeClosed(2, MAX).forEach(i -> {
			if (isPrime.get(i)) {
				primes.add(i);
				pf[i] = i;
				mu[i] = -1;
			}
			for (int p : primes) {
				if (p * (long) i > MAX) {
					break;
				}
				isPrime.set(i * p, false);
				mu[i * p] = -mu[i];
				pf[i * p] = p;
				if (0 == i % p) {
					mu[i * p] = 0;
					break;
				}
			}
		});
		pr = primes.stream().mapToInt(Integer::intValue).toArray();
	}

	private static class Mo {
		int n, m3;
		int[] l, r, t;

		Mo(int n, int[] l, int[] r) {
			this.n = n;
			this.l = l;
			this.r = r;
			m3 = 0;
			t = new int[MAX];
		}

		void in(int i) {
			if (-1 != big[i]) {
				if (0 != t[big[i]] % N) {
					m3--;
				}
				t[big[i]]++;
				if (0 != t[big[i]] % N) {
					m3++;
				}
			}
		}

		void dl(int i) {
			if (-1 != big[i]) {
				if (0 != t[big[i]] % N) {
					m3--;
				}
				t[big[i]]--;
				if (0 != t[big[i]] % N) {
					m3++;
				}
			}
		}

		void build() {
			int q = l.length, bs = n / Math.min(n, (int) Math.sqrt(q));
			int[] ord = IntStream.range(0, q).boxed().sorted((a, b) -> {
				int aBlock = l[a] / bs, bBlock = l[b] / bs;
				if (aBlock != bBlock) {
					return Integer.compare(aBlock, bBlock);
				} else {
					return (1 == (aBlock & 1)) ? Integer.compare(r[b], r[a]) : Integer.compare(r[a], r[b]);
				}
			}).mapToInt(Integer::intValue).toArray();
			int li = 0, ri = 0;
			for (int index : ord) {
				while (li > l[index]) {
					in(--li);
				}
				while (ri < r[index]) {
					in(ri++);
				}
				while (li < l[index]) {
					dl(li++);
				}
				while (ri > r[index]) {
					dl(--ri);
				}
				if (0 != m3) {
					ok[index] = false;
				}
			}
		}
	}
}
