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
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/090-07b.cpp を参考に実装
 */
public class Problem090別回答 {

	/** mod対象数字 */
	private static final int MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int k = scanner.nextInt();
			int[][] dp = new int[k + 1][];
			dp[k] = new int[] { 1, 1, 1 };
			for (int i = k - 1; i >= 1; i--) {
				int limit = (int) Math.min(k / i, n);
				int[] pdp = dp[i + 1], c = new int[pdp.length];
				c[0] = 1;
				IntStream.range(1, c.length).forEach(j -> c[j] = (MOD - pdp[j]) % MOD);
				dp[i] = polynomialInverse(c, limit + 2);
			}
			int s = (int) Math.min(k, n);
			int[] cl = new int[s + 2];
			cl[0] = 1;
			IntStream.range(1, s + 2).forEach(i -> cl[i] = (MOD - dp[1][i]) % MOD);
			int[] gl = polynomialInverse(cl, s + 2);
			reverse(cl);
			long nowT = n + s + 1;
			List<Long> track = new ArrayList<>();
			track.add(nowT);
			while (nowT >= s + 1) {
				nowT >>= 1;
				track.add(nowT);
			}
			Collections.reverse(track);
			int[] poly = new int[s + 1];
			Arrays.fill(poly, 0);
			poly[(int) nowT] = 1;
			for (int i = 1; i < track.size(); i++) {
				poly = Convolution.convolution(poly, poly, MOD);
				if (1L == (1L & track.get(i))) {
					int[] poly2 = new int[poly.length + 1];
					poly2[0] = 0;
					System.arraycopy(poly, 0, poly2, 1, poly.length);
					poly = poly2;
				} else {
					poly = Arrays.copyOf(poly, poly.length + 1);
				}
				int[] p1 = Arrays.copyOfRange(poly, s + 1, poly.length);
				reverse(p1);
				int[] p2 = Convolution.convolution(p1, gl, MOD);
				p2 = Arrays.copyOf(p2, s + 1);
				reverse(p2);
				int[] p3 = Convolution.convolution(p2, cl, MOD);
				for (int j = 0; j < s + 1; j++) {
					poly[j] = (int) ((poly[j] - (long) p3[j] + MOD) % MOD);
				}
				poly = Arrays.copyOf(poly, s + 1);
			}
			System.out.println(poly[s]);
		}
	}

	/**
	 * 配列aの順番を逆転する
	 *
	 * @param a 配列
	 */
	private static void reverse(int[] a) {
		IntStream.range(0, a.length >> 1).forEach(i -> {
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		});
	}

	/**
	 * (C[0] + C[1] * x + ... * C[N-1] * x^(N-1)) * P(x) == 1 (mod x^L) を満たす、L-1 次以下の多項式 P(x) を計算量 O(N log N) で求める <br/>
	 * 制約: C[0] == 1 でなければならない
	 *
	 * @param c C(X)を表す配列
	 * @param l
	 * @return P(x)を表す配列
	 */
	private static int[] polynomialInverse(int[] c, int l) {
		int n = c.length, level = 0;
		int[] a = new int[] { 1, 0 };
		while ((1 << level) < l) {
			int cs = Math.min(2 << level, n);
			int[] p = Convolution.convolution(a, Arrays.copyOf(c, cs), MOD);
			int[] q = new int[2 << level];
			q[0] = 1;
			IntStream.range(1 << level, 2 << level).forEach(j -> q[j] = (MOD - p[j]) % MOD);
			a = Convolution.convolution(a, q, MOD);
			a = Arrays.copyOf(a, 4 << level);
			level++;
		}
		return Arrays.copyOf(a, l);
	}

	/**
	 * https://atcoder.jp/contests/abc213/submissions/25074532 をもとに作成
	 */
	private static class Convolution {
		static int MOD = -1;

		private static int[] convolutionNaive(int[] a, int aFromIndex, int aToIndex, int[] b, int bFromIndex,
				int bToIndex) {
			int n = aToIndex - aFromIndex, m = bToIndex - bFromIndex;
			int[] ans = new int[n + m - 1];
			if (n < m) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						ans[i + j] = safeMod(ans[i + j] + a[i + aFromIndex] * (long) b[j + bFromIndex]);
					}
				}
			} else {
				for (int j = 0; j < m; j++) {
					for (int i = 0; i < n; i++) {
						ans[i + j] = safeMod(ans[i + j] + a[i + aFromIndex] * (long) b[j + bFromIndex]);
					}
				}
			}
			return ans;
		}

		/**
		 * https://atcoder.jp/contests/abc213/submissions/25074532 を参考に作成
		 *
		 * @param a
		 * @param aFromIndex
		 * @param aToIndex
		 * @param b
		 * @param bFromIndex
		 * @param bToIndex
		 * @return fftでの計算結果
		 */
		private static int[] convolutionFft(int[] a, int aFromIndex, int aToIndex, int[] b, int bFromIndex,
				int bToIndex) {
			int n = aToIndex - aFromIndex, m = bToIndex - bFromIndex;
			int z = 1 << ceilPow2(n + m - 1);

			double[] aReal = new double[z];
			double[] aImag = new double[z];

			IntStream.range(0, n).forEach(i -> {
				aReal[i] = a[i + aFromIndex] & ((1 << 15) - 1);
				aImag[i] = a[i + aFromIndex] >> 15;
			});
			FastFourierTransform.fft(new double[][] { aReal, aImag }, false);

			double[] bReal = new double[z];
			double[] bImag = new double[z];
			IntStream.range(0, m).forEach(i -> {
				bReal[i] = b[i + bFromIndex] & ((1 << 15) - 1);
				bImag[i] = b[i + bFromIndex] >> 15;
			});
			FastFourierTransform.fft(new double[][] { bReal, bImag }, false);

			for (int i = 0, j = 0; i <= j; i++, j = z - i) {
				double ari = aReal[i];
				double aii = aImag[i];
				double bri = bReal[i];
				double bii = bImag[i];
				double arj = aReal[j];
				double aij = aImag[j];
				double brj = bReal[j];
				double bij = bImag[j];

				double a1r = (ari + arj) / 2;
				double a1i = (aii - aij) / 2;
				double a2r = (aii + aij) / 2;
				double a2i = (arj - ari) / 2;

				double b1r = (bri + brj) / 2;
				double b1i = (bii - bij) / 2;
				double b2r = (bii + bij) / 2;
				double b2i = (brj - bri) / 2;

				aReal[i] = a1r * b1r - a1i * b1i - a2r * b2i - a2i * b2r;
				aImag[i] = a1r * b1i + a1i * b1r + a2r * b2r - a2i * b2i;
				bReal[i] = a1r * b2r - a1i * b2i + a2r * b1r - a2i * b1i;
				bImag[i] = a1r * b2i + a1i * b2r + a2r * b1i + a2i * b1r;

				if (i != j) {
					a1r = (arj + ari) / 2;
					a1i = (aij - aii) / 2;
					a2r = (aij + aii) / 2;
					a2i = (ari - arj) / 2;

					b1r = (brj + bri) / 2;
					b1i = (bij - bii) / 2;
					b2r = (bij + bii) / 2;
					b2i = (bri - brj) / 2;

					aReal[j] = a1r * b1r - a1i * b1i - a2r * b2i - a2i * b2r;
					aImag[j] = a1r * b1i + a1i * b1r + a2r * b2r - a2i * b2i;
					bReal[j] = a1r * b2r - a1i * b2i + a2r * b1r - a2i * b1i;
					bImag[j] = a1r * b2i + a1i * b2r + a2r * b1i + a2i * b1r;
				}
			}

			FastFourierTransform.fft(new double[][] { aReal, aImag }, true);
			FastFourierTransform.fft(new double[][] { bReal, bImag }, true);

			int[] ans = new int[n + m - 1];
			IntStream.range(0, n + m - 1).forEach(i -> {
				long aa = safeMod(Math.round(aReal[i]));
				long bb = safeMod(Math.round(bReal[i]));
				long cc = safeMod(Math.round(aImag[i]));
				ans[i] = safeMod(aa + (bb << 15) + (cc << 30));
			});

			return ans;
		}

		private static int[] convolution(int[] a, int aFromIndex, int aToIndex, int[] b, int bFromIndex, int bToIndex) {
			int n = aToIndex - aFromIndex, m = bToIndex - bFromIndex;
			if ((0 == n) || (0 == m)) {
				return new int[0];
			}
			if (Math.min(n, m) <= 50) {
				return convolutionNaive(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex);
			} else {
				return convolutionFft(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex);
			}
		}

		/**
		 * 畳み込みを mod m で計算します。a,b の少なくとも一方が空配列の場合は空配列を返します。
		 *
		 * @param a
		 * @param b
		 * @param m
		 * @return 計算した結果配列
		 */
		static int[] convolution(int[] a, int[] b, int m) {
			return convolution(a, 0, a.length, b, 0, b.length, m);
		}

		/**
		 * 畳み込みを mod m で計算します。a,b の少なくとも一方が空配列の場合は空配列を返します。
		 *
		 * @param a
		 * @param aFromIndex
		 * @param aToIndex
		 * @param b
		 * @param bFromIndex
		 * @param bToIndex
		 * @param m
		 * @return 計算した結果配列
		 */
		static int[] convolution(int[] a, int aFromIndex, int aToIndex, int[] b, int bFromIndex, int bToIndex, int m) {
			if (!(aFromIndex >= 0)) {
				throw new IllegalArgumentException("aFromIndex is " + aFromIndex);
			}
			if (!(aFromIndex <= aToIndex)) {
				throw new IllegalArgumentException("aFromIndex is " + aFromIndex + ", aToIndex is " + aToIndex);
			}
			if (!(aToIndex <= a.length)) {
				throw new IllegalArgumentException("aToIndex is " + aToIndex);
			}
			if (!(bFromIndex >= 0)) {
				throw new IllegalArgumentException("bFromIndex is " + bFromIndex);
			}
			if (!(bFromIndex <= bToIndex)) {
				throw new IllegalArgumentException("bFromIndex is " + bFromIndex + ", bToIndex is " + bToIndex);
			}
			if (!(bToIndex <= b.length)) {
				throw new IllegalArgumentException("bToIndex is " + bToIndex);
			}
			MOD = m;
			return convolution(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex);
		}

		// 以下 https://github.com/atcoder/ac-library/blob/master/atcoder/internal_math.hpp を参考に作成
		/**
		 * x mod MOD を安全に計算する
		 *
		 * @param x
		 * @return x mod MOD
		 */
		private static int safeMod(long x) {
			return safeMod(x, MOD);
		}

		/**
		 * x mod m を安全に計算する
		 *
		 * @param x
		 * @param m
		 * @return x mod m
		 */
		static int safeMod(long x, int m) {
			if ((x >= 0) && (x < m)) {
				return (int) x;
			}
			if ((x >= m) && (x < (m << 1))) {
				return (int) (x - m);
			}
			if ((x < -m) || (x >= m)) {
				x %= m;
			}
			if (x < 0) {
				x += m;
			}
			return (int) x;
		}

		/**
		 *
		 * @param n `0 <= n`
		 * @return minimum non-negative `x` s.t. `n <= 2**x`
		 */
		static int ceilPow2(int n) {
			if (!(0 <= n)) {
				throw new IllegalArgumentException("n is " + n);
			}
			int x = 0;
			while ((1L << x) < n) {
				x++;
			}
			return x;
		}

		static class FastFourierTransform {
			private static double[][] realLevels = new double[30][];
			private static double[][] imgLevels = new double[30][];

			private static void prepareLevel(int i) {
				if (realLevels[i] == null) {
					realLevels[i] = new double[1 << i];
					imgLevels[i] = new double[1 << i];
					for (int j = 0, s = 1 << i; j < s; j++) {
						realLevels[i][j] = Math.cos(Math.PI / s * j);
						imgLevels[i][j] = Math.sin(Math.PI / s * j);
					}
				}
			}

			public static void fft(double[][] p, boolean inv) {
				int m = Convolution.ceilPow2(p[0].length);
				int n = 1 << m;
				int shift = 32 - Integer.numberOfTrailingZeros(n);
				for (int i = 1; i < n; i++) {
					int j = Integer.reverse(i << shift);
					if (i < j) {
						swap(p[0], i, j);
						swap(p[1], i, j);
					}
				}

				double[][] t = new double[2][1];
				for (int d = 0; d < m; d++) {
					int s = 1 << d;
					int s2 = s << 1;
					prepareLevel(d);
					for (int i = 0; i < n; i += s2) {
						for (int j = 0; j < s; j++) {
							int a = i + j;
							int b = a + s;
							mul(realLevels[d][j], imgLevels[d][j], p[0][b], p[1][b], t, 0);
							sub(p[0][a], p[1][a], t[0][0], t[1][0], p, b);
							add(p[0][a], p[1][a], t[0][0], t[1][0], p, a);
						}
					}
				}

				if (inv) {
					for (int i = 0, j = 0; i <= j; i++, j = n - i) {
						double a = p[0][j];
						double b = p[1][j];
						div(p[0][i], p[1][i], n, p, j);
						if (i != j) {
							div(a, b, n, p, i);
						}
					}
				}
			}

			public static void add(double r1, double i1, double r2, double i2, double[][] r, int i) {
				r[0][i] = r1 + r2;
				r[1][i] = i1 + i2;
			}

			public static void sub(double r1, double i1, double r2, double i2, double[][] r, int i) {
				r[0][i] = r1 - r2;
				r[1][i] = i1 - i2;
			}

			public static void mul(double r1, double i1, double r2, double i2, double[][] r, int i) {
				r[0][i] = r1 * r2 - i1 * i2;
				r[1][i] = r1 * i2 + i1 * r2;
			}

			public static void div(double r1, double i1, double r2, double[][] r, int i) {
				r[0][i] = r1 / r2;
				r[1][i] = i1 / r2;
			}

			private static void swap(double[] data, int i, int j) {
				double tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
	}
}
