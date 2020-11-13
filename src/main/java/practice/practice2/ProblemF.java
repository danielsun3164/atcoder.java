package practice.practice2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemF {

	private static final long MOD = 998244353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] b = IntStream.range(0, m).mapToLong(i -> scanner.nextLong()).toArray();
			System.out.println(Arrays.stream(Convolution.convolution(a, b)).mapToObj(Long::toString)
					.collect(Collectors.joining(" ")));
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/convolution.hpp をもとに作成
	 */
	private static class Convolution {
		private static int SIZE = 32;
		private static boolean first = true;
		// sum_e[i] = ies[0] * ... * ies[i - 1] * es[i]
		private static long[] sum_e = new long[SIZE];
		private static boolean invFirst = true;
		// sum_ie[i] = es[0] * ... * es[i - 1] * ies[i]
		private static long[] sum_ie = new long[SIZE];
		private static int g = primitiveRoot(MOD);

		private static void butterfly(long[] a) {
			int n = a.length, h = ceilPow2(n);

			if (first) {
				first = false;
				Arrays.fill(sum_e, 0L);
				// es[i]^(2^(2+i)) == 1
				int cnt2 = bsf((int) MOD - 1);
				long[] es = new long[cnt2], ies = new long[cnt2];
				long e = powMod(g, (MOD - 1) >> cnt2), ie = invMod(e);
				for (int i = cnt2; i >= 2; i--) {
					// e^(2^i) == 1
					es[i - 2] = e;
					ies[i - 2] = ie;
					e = safeMod(e * e);
					ie = safeMod(ie * ie);
				}
				long now = 1L;
				for (int i = 0; i <= cnt2 - 2; i++) {
					sum_e[i] = safeMod(es[i] * now);
					now = safeMod(now * ies[i]);
				}
			}
			for (int ph = 1; ph <= h; ph++) {
				int w = 1 << (ph - 1), p = 1 << (h - ph);
				long now = 1L;
				for (int s = 0; s < w; s++) {
					int offset = s << (h - ph + 1);
					for (int i = 0; i < p; i++) {
						long l = a[i + offset];
						long r = safeMod(a[i + offset + p] * now);
						a[i + offset] = safeMod(l + r);
						a[i + offset + p] = safeMod(l - r);
					}
					now = safeMod(now * (sum_e[bsf(~s & Integer.MAX_VALUE)]));
				}
			}
		}

		private static void butterflyInv(long[] a) {
			int n = a.length, h = ceilPow2(n);

			if (invFirst) {
				invFirst = false;
				Arrays.fill(sum_ie, 0L);
				// es[i]^(2^(2+i)) == 1
				int cnt2 = bsf((int) MOD - 1);
				long[] es = new long[cnt2], ies = new long[cnt2];
				long e = powMod(g, (MOD - 1) >> cnt2), ie = invMod(e);
				for (int i = cnt2; i >= 2; i--) {
					// e^(2^i) == 1
					es[i - 2] = e;
					ies[i - 2] = ie;
					e = safeMod(e * e);
					ie = safeMod(ie * ie);
				}
				long now = 1L;
				for (int i = 0; i <= cnt2 - 2; i++) {
					sum_ie[i] = safeMod(ies[i] * now);
					now = safeMod(now * es[i]);
				}
			}

			for (int ph = h; ph >= 1; ph--) {
				int w = 1 << (ph - 1), p = 1 << (h - ph);
				long inow = 1L;
				for (int s = 0; s < w; s++) {
					int offset = s << (h - ph + 1);
					for (int i = 0; i < p; i++) {
						long l = a[i + offset];
						long r = a[i + offset + p];
						a[i + offset] = safeMod(l + r);
						a[i + offset + p] = safeMod(safeMod(l - r) * inow);
					}
					inow = safeMod(inow * sum_ie[bsf(~s & Integer.MAX_VALUE)]);
				}
			}
		}

		static long[] convolution(long[] a, long[] b) {
			int n = a.length, m = b.length;
			if ((0 == n) || (0 == m)) {
				throw new IllegalArgumentException("n is " + n + ", m is " + m);
			}
			if (Math.min(n, m) <= 60) {
				int min, max;
				long[] minAB, maxAB;
				if (n < m) {
					min = n;
					max = m;
					minAB = a;
					maxAB = b;
				} else {
					min = m;
					max = n;
					minAB = b;
					maxAB = a;
				}
				long[] ans = new long[n + m - 1];
				Arrays.fill(ans, 0L);
				for (int i = 0; i < max; i++) {
					for (int j = 0; j < min; j++) {
						ans[i + j] = safeMod(ans[i + j] + safeMod(maxAB[i] * minAB[j]));
					}
				}
				return ans;
			}

			int z = 1 << ceilPow2(n + m - 1);
			a = Arrays.copyOf(a, z);
			butterfly(a);
			b = Arrays.copyOf(b, z);
			butterfly(b);
			for (int i = 0; i < z; i++) {
				a[i] = safeMod(a[i] * b[i]);
			}
			butterflyInv(a);
			a = Arrays.copyOf(a, n + m - 1);
			long iz = invMod(z);
			for (int i = 0; i < n + m - 1; i++) {
				a[i] = safeMod(a[i] * iz);
			}
			return a;
		}
	}

	/**
	 * x^n mod MOD
	 * 
	 * @param x
	 * @param n
	 * @return x^n mod MOD を計算する
	 */
	static long powMod(long x, long n) {
		return powMod(x, n, MOD);
	}

	/**
	 * x^n mod m
	 * 
	 * @param x
	 * @param n
	 * @param m
	 * @return x^n mod m を計算する
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
	 * x mod MOD を安全に計算する
	 * 
	 * @param x
	 * @return x mod MOD
	 */
	private static long safeMod(long x) {
		return safeMod(x, MOD);
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

	static long invMod(long x) {
		return invMod(x, MOD);
	}

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
	 * @param a
	 * @param b `1 <= b`
	 * @return {g, x} s.t. g = gcd(a, b), x a = g (mod b), 0 <= x < b/g
	 */
	static long[] invGcd(long a, long b) {
		a = safeMod(a, b);
		if (a == 0)
			return new long[] { b, 0 };

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

	static int primitiveRoot(long m) {
		if (2L == m) {
			return 1;
		}
		if (167772161L == m) {
			return 3;
		}
		if (469762049L == m) {
			return 3;
		}
		if (754974721L == m) {
			return 11;
		}
		if (998244353L == m) {
			return 3;
		}
		long[] divs = new long[20];
		Arrays.fill(divs, 0L);
		divs[0] = 2;
		int cnt = 1;
		long x = (m - 1) / 2;
		while (0 == (x & 1)) {
			x >>= 1;
		}
		for (int i = 3; (long) (i) * i <= x; i += 2) {
			if (0 == x % i) {
				divs[cnt++] = i;
				while (0 == x % i) {
					x /= i;
				}
			}
		}
		if (x > 1) {
			divs[cnt++] = x;
		}
		for (int g = 2;; g++) {
			boolean ok = true;
			for (int i = 0; i < cnt; i++) {
				if (1L == powMod(g, (m - 1) / divs[i], m)) {
					ok = false;
					break;
				}
			}
			if (ok) {
				return g;
			}
		}
	}

	/**
	 * 
	 * @param n `0 <= n`
	 * @return minimum non-negative `x` s.t. `n <= 2**x`
	 */
	static int ceilPow2(int n) {
		int x = 0;
		while ((1 << x) < n) {
			x++;
		}
		return x;
	}

	/**
	 * 
	 * @param n `1 <= n`
	 * @return minimum non-negative `x` s.t. `(n & (1 << x)) != 0`
	 */
	static int bsf(int n) {
		if (!(1 <= n)) {
			throw new IllegalArgumentException("n is " + n);
		}
		int x = 0;
		while ((0 == (n & (1 << x))) && (x < 31)) {
			x++;
		}
		return x;
	}
}
