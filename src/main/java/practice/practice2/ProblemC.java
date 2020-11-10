package practice.practice2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			IntStream.range(0, t).forEach(i -> {
				int n = scanner.nextInt(), m = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
				System.out.println(AtCoderMath.floorSum(n, m, a, b));
			});
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/math.hpp<br/>
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/internal_math.hpp をもとに作成
	 */
	private static class AtCoderMath {
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

		@SuppressWarnings("unused")
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

		// (rem, mod)
		@SuppressWarnings("unused")
		static long[] crt(long[] r, long[] m) {
			if (r.length != m.length) {
				throw new IllegalArgumentException("r.length is " + r.length + ", m.length is " + m.length);
			}
			int n = r.length;
			// Contracts: 0 <= r0 < m0
			long r0 = 0L, m0 = 1L;
			for (int i = 0; i < n; i++) {
				if (m[i] < 1) {
					throw new IllegalArgumentException("m[" + i + "] is " + m[i]);
				}
				long r1 = safeMod(r[i], m[i]), m1 = m[i];
				if (m0 < m1) {
					// swap r0,r1 m0,m1
					long tmp = r0;
					r0 = r1;
					r1 = tmp;
					tmp = m0;
					m0 = m1;
					m1 = tmp;
				}
				if (0 == (m0 % m1)) {
					if (r0 % m1 != r1)
						return new long[] { 0L, 0L };
					continue;
				}
				// assume: m0 > m1, lcm(m0, m1) >= 2 * max(m0, m1)

				// (r0, m0), (r1, m1) -> (r2, m2 = lcm(m0, m1));
				// r2 % m0 = r0
				// r2 % m1 = r1
				// -> (r0 + x*m0) % m1 = r1
				// -> x*u0*g % (u1*g) = (r1 - r0) (u0*g = m0, u1*g = m1)
				// -> x = (r1 - r0) / g * inv(u0) (mod u1)

				// im = inv(u0) (mod u1) (0 <= im < u1)
				long[] gcd = invGcd(m0, m1);
				long g = gcd[0], im = gcd[1];

				long u1 = (m1 / g);
				// |r1 - r0| < (m0 + m1) <= lcm(m0, m1)
				if ((r1 - r0) % g > 0)
					return new long[] { 0L, 0L };

				// u1 * u1 <= m1 * m1 / g / g <= m0 * m1 / g = lcm(m0, m1)
				long x = (r1 - r0) / g % u1 * im % u1;

				// |r0| + |m0 * x|
				// < m0 + m0 * (u1 - 1)
				// = m0 + m0 * m1 / g - m0
				// = lcm(m0, m1)
				r0 += x * m0;
				m0 *= u1; // -> lcm(m0, m1)
				if (r0 < 0)
					r0 += m0;
			}
			return new long[] { r0, m0 };
		}

		static long floorSum(long n, long m, long a, long b) {
			long ans = 0;
			if (a >= m) {
				ans += (n - 1) * n * (a / m) / 2;
				a %= m;
			}
			if (b >= m) {
				ans += n * (b / m);
				b %= m;
			}

			long yMax = (a * n + b) / m, xMax = (yMax * m - b);
			if (0 == yMax) {
				return ans;
			}
			ans += (n - (xMax + a - 1) / a) * yMax;
			ans += floorSum(yMax, a, m, (a - xMax % a) % a);
			return ans;
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
		 * nが素数かどうかを判定する
		 * 
		 * @param n
		 * @return nが素数かどうか
		 */
		@SuppressWarnings("unused")
		static boolean isPrime(long n) {
			if (n <= 1L) {
				return false;
			}
			if (2L == n || 7L == n || 61L == n) {
				return true;
			}
			if (0L == (n & 1L)) {
				return false;
			}
			long d = n - 1L;
			while (0L == (d & 1L)) {
				d >>= 1;
			}
			long[] bases = new long[] { 2L, 7L, 61L };
			for (long a : bases) {
				long t = d;
				long y = powMod(a, t, n);
				while ((t != n - 1) && (1 != y) && (y != n - 1)) {
					y = y * y % n;
					t <<= 1;
				}
				if (y != n - 1 && 0 == (t & 1)) {
					return false;
				}
			}
			return true;
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

		@SuppressWarnings("unused")
		static int primitiveRoot(int m) {
			if (2 == m) {
				return 1;
			}
			if (167772161 == m) {
				return 3;
			}
			if (469762049 == m) {
				return 3;
			}
			if (754974721 == m) {
				return 11;
			}
			if (998244353 == m) {
				return 3;
			}
			int[] divs = new int[20];
			Arrays.fill(divs, 0);
			divs[0] = 2;
			int cnt = 1;
			int x = (m - 1) / 2;
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
		@SuppressWarnings("unused")
		static int ceilPow2(int n) {
			if (!(0 <= n)) {
				throw new IllegalArgumentException("n is " + n);
			}
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
		@SuppressWarnings("unused")
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
}
