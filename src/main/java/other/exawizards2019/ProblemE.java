package other.exawizards2019;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	private static final long MOD = 1_000_000_007L;;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int b = scanner.nextInt(), w = scanner.nextInt();
			long[] fact = new long[b + w + 1], invFact = new long[b + w + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, b + w).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[b + w] = invMod(fact[b + w], MOD);
			IntStream.range(0, b + w).map(i -> b + w - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			long[] p = new long[b + w], q = new long[b + w], answer = new long[b + w];
			p[0] = q[0] = 0L;
			answer[0] = invMod(2L, MOD);
			IntStream.range(1, b + w).forEach(i -> {
				p[i] = safeMod(p[i - 1] + fn(i - 1, b - 1, fact, invFact) * invMod(powMod(2L, i, MOD), MOD) % MOD, MOD);
				q[i] = safeMod(q[i - 1] + fn(i - 1, w - 1, fact, invFact) * invMod(powMod(2L, i, MOD), MOD) % MOD, MOD);
				answer[i] = safeMod(1 - p[i] + q[i], MOD) * invMod(2L, MOD) % MOD;
			});
			Arrays.stream(answer).forEach(System.out::println);
		}
	}

	/**
	 * n_C_m を計算する
	 * 
	 * @param n
	 * @param m
	 * @param fact    階乗の配列
	 * @param invFact 階乗^-1の配列
	 * @return n_C_m
	 */
	private static long fn(int n, int m, final long[] fact, final long[] invFact) {
		if (n < m) {
			return 0L;
		}
		return fact[n] * invFact[m] % MOD * invFact[n - m] % MOD;
	}

	/**
	 * x^n mod m を計算する
	 * 
	 * @param x
	 * @param n
	 * @param m
	 * @return x^n mod m
	 */
	static long powMod(long x, long n, long m) {
		if (!((0L <= n) || (1L <= m))) {
			throw new IllegalArgumentException("n is " + n + ", m is " + m);
		}
		if (1L == m) {
			return 0L;
		}
		long r = 1L, y = safeMod(x, m);
		while (n > 0L) {
			if (1L == (n & 1L)) {
				r = safeMod(r * y, m);
			}
			y = safeMod(y * y, m);
			n >>= 1;
		}
		return r;
	}

	/**
	 * x^-1 mod m を計算する
	 * 
	 * @param x
	 * @param m
	 * @return x^-1 mod m
	 */
	static long invMod(long x, long m) {
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

	/**
	 * @param a
	 * @param b `1 <= b`
	 * @return {g, x} s.t. g = gcd(a, b), x a = g (mod b), 0 <= x < b/g
	 */
	static long[] invGcd(long a, long b) {
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
}
