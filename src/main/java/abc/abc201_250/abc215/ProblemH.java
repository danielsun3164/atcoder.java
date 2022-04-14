package abc.abc201_250.abc215;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc215/submissions/25390591 にも参考
 */
public class ProblemH {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), p = 1 << n;
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			int[] c = new int[m];
			Arrays.fill(c, 0);
			IntStream.range(0, n).forEach(i -> IntStream.range(0, m).forEach(j -> c[j] |= scanner.nextInt() << i));
			int[] f = new int[p], g = new int[p];
			Arrays.fill(f, 0);
			IntStream.range(0, n).forEach(i -> f[1 << i] += a[i]);
			Arrays.fill(g, 0);
			IntStream.range(0, m).forEach(i -> g[c[i]] += b[i]);
			bitwiseTransform((l, r, ar) -> ar[r] += ar[l], f);
			bitwiseTransform((l, r, ar) -> ar[r] += ar[l], g);
			int x = IntStream.range(0, p).filter(s -> g[s] > 0).map(s -> f[s] - g[s] + 1).min().getAsInt();
			if (x <= 0) {
				System.out.println("0 1");
				return;
			}
			int[] h = new int[p];
			Arrays.fill(h, 0);
			IntStream.range(0, p).filter(s -> (g[s] > 0) && (x == f[s] - g[s] + 1)).forEach(s -> h[s] = 1);
			bitwiseTransform((l, r, ar) -> ar[l] += ar[r], h);
			int q = f[p - 1];
			long[] fact = new long[q + 1], invFact = new long[q + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, q).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[q] = powMod(fact[q], MOD - 2);
			IntStream.range(0, q).map(i -> q - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			long y = IntStream.range(0, p).filter(s -> (g[s] > 0) && (x == f[s] - g[s] + 1) && (1 == h[s]))
					.mapToLong(s -> fact[f[s]] * invFact[x] % MOD * invFact[f[s] - x] % MOD).sum() % MOD;
			System.out.println(x + " " + y);
		}
	}

	private static void bitwiseTransform(F f, int[] a) {
		int n = a.length;
		for (int w = 1; w < n; w <<= 1) {
			for (int k = 0; k < n; k += w * 2) {
				for (int i = 0; i < w; i++) {
					f.f(k + i, k + w + i, a);
				}
			}
		}
	}

	/**
	 * n^m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0L) {
			if (1L == (1L & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}

	/**
	 * bitwiseTransform用interface
	 */
	private static interface F {
		void f(int l, int r, int[] a);
	}
}
