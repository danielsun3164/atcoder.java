package abc.abc151_200.abc186;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			IntStream.range(0, t).forEach(i -> {
				long n = scanner.nextLong(), s = scanner.nextLong(), k = scanner.nextLong();
				System.out.println(getResult(k, s, n));
			});
		}
	}

	/**
	 * a x ≡ (m-b) mod m となるxを計算する
	 * 
	 * @param a
	 * @param b
	 * @param m
	 * @return a x ≡ (m-b) mod m となるx
	 */
	private static long getResult(long a, long b, long m) {
		long gcd = gcd(a, gcd(b, m));
		if (gcd > 1L) {
			a /= gcd;
			b /= gcd;
			m /= gcd;
		}
		long[] invGcd = invGcd(a, m);
		if (1L != invGcd[0]) {
			return -1L;
		}
		return (invGcd[1] * (m - b) % m);
	}

	/**
	 * aとbの最大公約数を計算する
	 * 
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		if (0L == b) {
			return a;
		}
		return gcd(b, a % b);
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
}
