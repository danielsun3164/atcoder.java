package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/090-07a.cpp を参考に実装
 */
public class Problem090 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	private static final long M = 3L;
	private static final int N = Integer.SIZE;
	static final long[] fwdPow = new long[N];
	static final long[] reversePow = new long[N];

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int k = scanner.nextInt();
			init();
			long[][] dp = new long[k + 1][];
			dp[k] = new long[] { 1L, 1L, 1L };
			for (int i = k - 1; i >= 1; i--) {
				int limit = (int) Math.min(k / i, n);
				long[] pdp = dp[i + 1], c = new long[pdp.length];
				c[0] = 1L;
				IntStream.range(1, c.length).forEach(j -> c[j] = (MOD - pdp[j]) % MOD);
				dp[i] = polynomialInverse(c, limit + 2);
			}
			int s = (int) Math.min(k, n);
			long[] cl = new long[s + 2];
			cl[0] = 1L;
			IntStream.range(1, s + 2).forEach(i -> cl[i] = (MOD - dp[1][i]) % MOD);
			long[] gl = polynomialInverse(cl, s + 2);
			reverse(cl);
			long nowT = n + s + 1;
			List<Long> track = new ArrayList<>();
			track.add(nowT);
			while (nowT >= s + 1) {
				nowT >>= 1;
				track.add(nowT);
			}
			Collections.reverse(track);
			long[] poly = new long[s + 1];
			Arrays.fill(poly, 0L);
			poly[(int) nowT] = 1L;
			for (int i = 1; i < track.size(); i++) {
				poly = convolution(poly, poly);
				if (1L == (1L & track.get(i))) {
					long[] poly2 = new long[poly.length + 1];
					poly2[0] = 0L;
					System.arraycopy(poly, 0, poly2, 1, poly.length);
					poly = poly2;
				} else {
					poly = Arrays.copyOf(poly, poly.length + 1);
				}
				long[] p1 = Arrays.copyOfRange(poly, s + 1, poly.length);
				reverse(p1);
				long[] p2 = convolution(p1, gl);
				p2 = Arrays.copyOf(p2, s + 1);
				reverse(p2);
				long[] p3 = convolution(p2, cl);
				for (int j = 0; j < s + 1; j++) {
					poly[j] = (poly[j] - p3[j] + MOD) % MOD;
				}
				poly = Arrays.copyOf(poly, s + 1);
			}
			System.out.println(poly[s]);
		}
	}

	/**
	 * 初期化
	 */
	private static void init() {
		IntStream.range(0, N).forEach(i -> {
			fwdPow[i] = powMod(M, (MOD - 1) >> i);
			reversePow[i] = powMod(M, (MOD - 1) - ((MOD - 1) >> i));
		});
	}

	/**
	 * 配列aの順番を逆転する
	 *
	 * @param a 配列
	 */
	private static void reverse(long[] a) {
		IntStream.range(0, a.length >> 1).forEach(i -> {
			long temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		});
	}

	/**
	 * n ^ m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n ^ m mod MOD
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
	 * フーリエ変換を行う
	 *
	 * @param x       入力配列
	 * @param inverse 逆変換かどうか
	 * @return 変換後の配列
	 */
	private static long[] fourierTransform(long[] x, boolean inverse) {
		int n = x.length, level = 0;
		long[] y = new long[n];
		for (int i = n >> 1; i >= 1; i >>= 1) {
			level++;
			long p = inverse ? reversePow[level] : fwdPow[level], mul = 1L;
			for (int j = 0; (j << 1) < n; j += i) {
				for (int k = 0; k < i; k++) {
					long g = mul * x[(j << 1) + k + i] % MOD;
					y[j + k] = (x[(j << 1) + k] + g) % MOD;
					y[j + k + (n >> 1)] = (x[(j << 1) + k] - g + MOD) % MOD;
				}
				mul = mul * p % MOD;
			}
			System.arraycopy(y, 0, x, 0, n);
		}
		return x;
	}

	/**
	 * 多項式の積 A(x) * B(x) を計算量 O(n log n) で求める
	 *
	 * @param a A(x)を表す配列
	 * @param b B(x)を表す配列
	 * @return 多項式の積 A(x) * B(x)
	 */
	static long[] convolution(long[] a, long[] b) {
		int l = a.length + b.length - 1, size = 2;
		while (size < l) {
			size <<= 1;
		}
		long[] na = fourierTransform(Arrays.copyOf(a, size), false);
		long[] nb = fourierTransform(Arrays.copyOf(b, size), false);
		for (int i = 0; i < size; i++) {
			na[i] = na[i] * nb[i] % MOD;
		}
		na = fourierTransform(na, true);
		long inverse = powMod(size, MOD - 2);
		long[] result = new long[l];
		for (int i = 0; i < l; i++) {
			result[i] = na[i] * inverse % MOD;
		}
		return result;
	}

	/**
	 * (C[0] + C[1] * x + ... * C[N-1] * x^(N-1)) * P(x) == 1 (mod x^L) を満たす、L-1 次以下の多項式 P(x) を計算量 O(N log N) で求める <br/>
	 * 制約: C[0] == 1 でなければならない
	 *
	 * @param c C(X)を表す配列
	 * @param l
	 * @return P(x)を表す配列
	 */
	private static long[] polynomialInverse(long[] c, int l) {
		int n = c.length, level = 0;
		long[] a = new long[] { 1L, 0L };
		while ((1 << level) < l) {
			int cs = Math.min(2 << level, n);
			long[] p = convolution(a, Arrays.copyOf(c, cs));
			long[] q = new long[2 << level];
			q[0] = 1L;
			IntStream.range(1 << level, 2 << level).forEach(j -> q[j] = (MOD - p[j]) % MOD);
			a = convolution(a, q);
			a = Arrays.copyOf(a, 4 << level);
			level++;
		}
		return Arrays.copyOf(a, l);
	}
}
