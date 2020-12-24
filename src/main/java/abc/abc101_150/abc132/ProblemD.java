package abc.abc101_150.abc132;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] fac = new long[n + 1], invFac = new long[n + 1];
			fac[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fac[i] = safeMod(fac[i - 1] * i, MOD));
			invFac[n] = invMod(fac[n], MOD);
			IntStream.rangeClosed(1, n).map(i -> n - i).forEach(i -> invFac[i] = safeMod(invFac[i + 1] * (i + 1), MOD));
			final long[] fac1 = fac;
			final long[] invFac1 = invFac;
			IntStream.rangeClosed(1, k).forEach(i -> System.out
					.println(safeMod(fc(k - 1, i - 1, fac1, invFac1) * fc(n - k + 1, i, fac1, invFac1), MOD)));
		}
	}

	/**
	 * n_C_m mod MODを計算する
	 * 
	 * @param n
	 * @param m
	 * @param fac    階乗の配列
	 * @param invFac 階乗^-1の配列
	 * @return n_C_m mod MOD
	 */
	private static long fc(int n, int m, final long[] fac, final long[] invFac) {
		if (m > n) {
			return 0L;
		} else {
			return safeMod(safeMod(fac[n] * invFac[m], MOD) * invFac[n - m], MOD);
		}
	}

	/**
	 * x^-1 mod m を計算する
	 * 
	 * @param x
	 * @param m
	 * @return x^-1 mod m
	 */
	private static long invMod(long x, long m) {
		if (!(1 <= m)) {
			throw new IllegalArgumentException("m is " + m);
		}
		long[] z = invGcd(x, m);
		if (1L != z[0]) {
			throw new IllegalArgumentException("z[0] is " + z[0]);
		}
		return z[1];
	}

	/**
	 * @param a
	 * @param b `1 <= b`
	 * @return {g, x} s.t. g = gcd(a, b), x a = g (mod b), 0 <= x < b/g
	 */
	private static long[] invGcd(long a, long b) {
		a = safeMod(a, b);
		if (a == 0) {
			return new long[] { b, 0 };
		}

		// Contracts:
		// [1] s - m0 * a = 0 (mod b)
		// [2] t - m1 * a = 0 (mod b)
		// [3] s * |m1| + t * |m0| <= b
		long s = b, t = a;
		long m0 = 0, m1 = 1;

		while (t > 0) {
			long u = s / t;
			s -= t * u;
			m0 -= m1 * u; // |m1 * u| <= |m1| * s <= b

			// [3]:
			// (s - t * u) * |m1| + t * |m0 - m1 * u|
			// <= s * |m1| - t * u * |m1| + t * (|m0| + |m1| * u)
			// = s * |m1| + t * |m0| <= b
			long tmp = s;
			s = t;
			t = tmp;
			tmp = m0;
			m0 = m1;
			m1 = tmp;
		}
		// by [3]: |m0| <= b/g
		// by g != b: |m0| < b/g
		if (m0 < 0) {
			m0 += b / s;
		}
		return new long[] { s, m0 };
	}

	/**
	 * x mod m を安全に計算する
	 * 
	 * @param x
	 * @param m
	 * @return x mod m
	 */
	private static long safeMod(long x, long m) {
		x %= m;
		if (x < 0) {
			x += m;
		}
		return x;
	}
}
