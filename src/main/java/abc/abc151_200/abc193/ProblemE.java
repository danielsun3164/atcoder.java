package abc.abc151_200.abc193;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			IntStream.range(0, t).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt(), p = scanner.nextInt(), q = scanner.nextInt();
				long result = getResult(x, y, p, q);
				System.out.println((INF == result) ? "infinity" : result);
			});
		}
	}

	/**
	 * x,y,p,qの結果を計算する
	 * 
	 * @param x
	 * @param y
	 * @param p
	 * @param q
	 * @return x,y,p,qの結果
	 */
	private static long getResult(long x, int y, long p, int q) {
		return Math.min(
				// 街Bに止まっている間に起きた場合の計算
				IntStream.range(0, y).mapToLong(i -> {
					long n = calc(2L * (x + y), safeMod(p - x - i, p + q), p + q);
					return (INF == n) ? INF : 2L * (x + y) * n + x + i;
				}).min().getAsLong(),
				// 起きている間に街Bに到着した場合の計算
				IntStream.range(1, q).mapToLong(j -> {
					long m = calc(p + q, safeMod(x - p - j, 2L * (x + y)), 2L * (x + y));
					return (INF == m) ? INF : (p + q) * m + p + j;
				}).min().orElse(INF));
	}

	/**
	 * ax ≡ b mod m となる最小の x を計算する
	 * 
	 * @param a
	 * @param b
	 * @param m
	 * @return ax ≡ b mod m となる最小の x
	 */
	private static long calc(long a, long b, long m) {
		long d = gcd(gcd(a, b), m);
		if (d > 1L) {
			a /= d;
			b /= d;
			m /= d;
		}
		return (1L == gcd(a, m)) ? safeMod(b * invMod(a, m), m) : INF;
	}

	/**
	 * aとbの最大公約数を計算する
	 * 
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
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
