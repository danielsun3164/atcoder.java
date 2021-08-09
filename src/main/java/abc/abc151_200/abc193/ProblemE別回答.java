package abc.abc151_200.abc193;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * AtCoderライブラリーのcrtで回答
 */
public class ProblemE別回答 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			IntStream.range(0, t).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt(), p = scanner.nextInt(), q = scanner.nextInt();
				long result = LongStream.range(x, x + y).map(t1 -> LongStream.range(p, p + q).map(t2 -> {
					long[] r = crt(new long[] { t1, t2 }, new long[] { 2L * (x + y), p + q });
					return (0L == r[1]) ? INF : r[0];
				}).min().getAsLong()).min().getAsLong();
				System.out.println((INF == result) ? "infinity" : result);
			});
		}
	}

	static long[] crt(long[] r, long[] m) {
		if (r.length != m.length) {
			throw new IllegalArgumentException("r.length is " + r.length + ", m.length is " + m.length);
		}
		int n = r.length;
		long r0 = 0L, m0 = 1L;
		for (int i = 0; i < n; i++) {
			if (m[i] < 1L) {
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
			if (0L == (m0 % m1)) {
				if ((r0 % m1) != r1) {
					return new long[] { 0L, 0L };
				}
				continue;
			}

			long[] gcd = invGcd(m0, m1);
			long g = gcd[0], im = gcd[1];

			long u1 = m1 / g;
			if (((r1 - r0) % g) != 0L) {
				return new long[] { 0L, 0L };
			}

			long x = ((((r1 - r0) / g) % u1) * im) % u1;
			r0 += x * m0;
			m0 *= u1;
			if (r0 < 0L) {
				r0 += m0;
			}
		}
		return new long[] { r0, m0 };
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
	private static long[] invGcd(long a, long b) {
		a = safeMod(a, b);
		if (a == 0) {
			return new long[] { b, 0 };
		}

		long s = b, t = a;
		long m0 = 0, m1 = 1;
		while (t > 0) {
			long u = s / t;
			s -= t * u;
			m0 -= m1 * u;
			long tmp = s;
			s = t;
			t = tmp;
			tmp = m0;
			m0 = m1;
			m1 = tmp;
		}
		if (m0 < 0) {
			m0 += b / s;
		}
		return new long[] { s, m0 };
	}
}
