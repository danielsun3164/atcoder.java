package abc.abc201_250.abc230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc230/editorial/3036 の解説の実装<br/>
 * https://atcoder.jp/contests/abc230/submissions/27671434 にも参考
 */
public class ProblemH別回答 {

	/** mod対象数字 */
	private static final int MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] w = new long[n];
			Arrays.fill(w, 0L);
			IntStream.range(0, k).forEach(i -> {
				int t = scanner.nextInt();
				w[t - 1] = t;
			});
			RelaxedConvolution conv = new RelaxedConvolution(n);
			IntStream.range(1, n).forEach(i -> {
				for (int j = 0; (i - 1) + i * j < n; j++) {
					conv.g[(i - 1) + i * j] = (conv.g[(i - 1) + i * j] + w[j]) % MOD;
				}
			});
			conv.f[0] = 1L;
			IntStream.range(0, n).forEach(i -> {
				long temp = conv.f[i];
				if (0L == i) {
					temp--;
				}
				for (int j = 1; (j - 1) + i * j < n; j++) {
					conv.g[(j - 1) + i * j] = (conv.g[(j - 1) + i * j] + temp * (i + 1) % MOD) % MOD;
				}
				conv.fix();
				if (i + 1 < n) {
					conv.f[i + 1] = conv.h[i] * Convolution.invMod(i + 1, MOD) % MOD;
				}
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(1, n).forEach(i -> sb.append(conv.f[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	private static class RelaxedConvolution {
		List<Data>[] task;
		long[] f, g, h;
		int fixed;

		@SuppressWarnings("unchecked")
		RelaxedConvolution(int n) {
			int w = Convolution.bitCeil(n);
			task = new List[w + 1];
			IntStream.rangeClosed(0, w).forEach(i -> task[i] = new ArrayList<>());
			f = new long[n];
			g = new long[n];
			h = new long[n];
			Arrays.fill(h, 0L);
			fixed = 0;
			relaxed(w);
		}

		void fRelaxed(int i, int w) {
			if (1 == w) {
				task[i].add(new Data(i, i + 1, 0, 1));
				return;
			}
			w >>= 1;
			fRelaxed(i, w);
			task[i + w].add(new Data(i, i + w, w, w << 1));
			fRelaxed(i + w, w);
			task[i + (w << 1)].add(new Data(i + w, i + (w << 1), w, w << 1));
		}

		void gRelaxed(int i, int w) {
			if (1 == w) {
				task[i].add(new Data(0, 1, i, i + 1));
				return;
			}
			w >>= 1;
			gRelaxed(i, w);
			task[i + w].add(new Data(w, w << 1, i, i + w));
			gRelaxed(i + w, w);
			task[i + (w << 1)].add(new Data(w, w << 1, i + w, i + (w << 1)));
		}

		void relaxed(int w) {
			if (1 == w) {
				task[0].add(new Data(0, 1, 0, 1));
				return;
			}
			w >>= 1;
			relaxed(w);
			fRelaxed(w, w);
			gRelaxed(w, w);
			task[w << 1].add(new Data(w, w << 1, w, w << 1));
		}

		void fix() {
			for (Data data : task[fixed]) {
				long[] hs = Convolution.convolution(f, data.lf, data.rf, g, data.lg, data.rg, MOD);
				for (int i = 0; (data.lf + data.lg + i < h.length) && (i < hs.length); i++) {
					h[data.lf + data.lg + i] = (h[data.lf + data.lg + i] + hs[i]) % MOD;
				}
			}
			fixed++;
		}
	}

	private static class Data {
		int lf, rf, lg, rg;

		Data(int lf, int rf, int lg, int rg) {
			this.lf = lf;
			this.rf = rf;
			this.lg = lg;
			this.rg = rg;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/convolution.hpp をもとに作成
	 */
	private static class Convolution {
		static int MOD = -1;
		private static int g;
		private static FftInfo info;

		private static void butterfly(long[] a) {
			int n = a.length, h = countrZero(n);
			// a[i, i+(n>>len), i+2*(n>>len), ..] is transformed
			int len = 0;
			while (len < h) {
				if (h - len == 1) {
					int p = 1 << (h - len - 1);
					long rot = 1L;
					for (int s = 0; s < (1 << len); s++) {
						int offset = s << (h - len);
						for (int i = 0; i < p; i++) {
							long l = a[i + offset];
							long r = safeMod(a[i + offset + p] * rot);
							a[i + offset] = safeMod(l + r);
							a[i + offset + p] = safeMod(l - r);
						}
						if ((s + 1) != (1 << len)) {
							rot = safeMod(rot * info.rate2[countrZero(~s & Integer.MAX_VALUE)]);
						}
					}
					len++;
				} else {
					// 4-base
					int p = 1 << (h - len - 2);
					long rot = 1L, imag = info.root[2];
					for (int s = 0; s < (1 << len); s++) {
						long rot2 = safeMod(rot * rot);
						long rot3 = safeMod(rot2 * rot);
						int offset = s << (h - len);
						for (int i = 0; i < p; i++) {
							long a0 = a[i + offset];
							long a1 = safeMod(a[i + offset + p] * rot);
							long a2 = safeMod(a[i + offset + 2 * p] * rot2);
							long a3 = safeMod(a[i + offset + 3 * p] * rot3);
							long a1na3imag = safeMod((a1 - a3) * imag);
							long na2 = safeMod(MOD - a2);
							a[i + offset] = safeMod(a0 + a2 + a1 + a3);
							a[i + offset + 1 * p] = safeMod(a0 + a2 - (a1 + a3));
							a[i + offset + 2 * p] = safeMod(a0 + na2 + a1na3imag);
							a[i + offset + 3 * p] = safeMod(a0 + na2 - a1na3imag);
						}
						if ((s + 1) != (1 << len)) {
							rot = safeMod(rot * info.rate3[countrZero(~s & Integer.MAX_VALUE)]);
						}
					}
					len += 2;
				}
			}
		}

		private static void butterflyInv(long[] a) {
			int n = a.length, h = countrZero(n);

			int len = h; // a[i, i+(n>>len), i+2*(n>>len), ..] is transformed
			while (len > 0) {
				if (len == 1) {
					int p = 1 << (h - len);
					long irot = 1L;
					for (int s = 0; s < (1 << (len - 1)); s++) {
						int offset = s << (h - len + 1);
						for (int i = 0; i < p; i++) {
							long l = a[i + offset], r = a[i + offset + p];
							a[i + offset] = safeMod(l + r);
							a[i + offset + p] = safeMod((l - r) * irot);
						}
						if ((s + 1) != (1 << (len - 1))) {
							irot = safeMod(irot * info.irate2[countrZero(~s & Integer.MAX_VALUE)]);
						}
					}
					len--;
				} else {
					// 4-base
					int p = 1 << (h - len);
					long irot = 1, iimag = info.iroot[2];
					for (int s = 0; s < (1 << (len - 2)); s++) {
						long irot2 = irot * irot % MOD;
						long irot3 = irot2 * irot % MOD;
						int offset = s << (h - len + 2);
						for (int i = 0; i < p; i++) {
							long a0 = a[i + offset];
							long a1 = a[i + offset + 1 * p];
							long a2 = a[i + offset + 2 * p];
							long a3 = a[i + offset + 3 * p];

							long a2na3iimag = safeMod((a2 - a3) * iimag);

							a[i + offset] = safeMod(a0 + a1 + a2 + a3);
							a[i + offset + 1 * p] = safeMod((a0 - a1 + a2na3iimag) * irot);
							a[i + offset + 2 * p] = safeMod((a0 + a1 + -a2 - a3) * irot2);
							a[i + offset + 3 * p] = safeMod((a0 - a1 - a2na3iimag) * irot3);
						}
						if ((s + 1) != (1 << (len - 2))) {
							irot = safeMod(irot * info.irate3[countrZero(~s & Integer.MAX_VALUE)]);
						}
					}
					len -= 2;
				}
			}
		}

		private static long[] convolutionNaive(long[] a, int aFromIndex, int aToIndex, long[] b, int bFromIndex,
				int bToIndex) {
			int n = aToIndex - aFromIndex, m = bToIndex - bFromIndex;
			long[] ans = new long[(n + m) - 1];
			if (n < m) {
				for (int j = 0; j < m; j++) {
					for (int i = 0; i < n; i++) {
						ans[i + j] = safeMod(ans[i + j] + a[i + aFromIndex] * b[j + bFromIndex]);
					}
				}
			} else {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						ans[i + j] = safeMod(ans[i + j] + a[i + aFromIndex] * b[j + bFromIndex]);
					}
				}
			}
			return ans;
		}

		private static long[] convolutionFft(long[] a, int aFromIndex, int aToIndex, long[] b, int bFromIndex,
				int bToIndex) {
			int n = aToIndex - aFromIndex, m = bToIndex - bFromIndex;
			int z = bitCeil(n + m - 1);
			{
				long[] na = new long[z];
				System.arraycopy(a, aFromIndex, na, 0, n);
				long[] nb = new long[z];
				System.arraycopy(b, bFromIndex, nb, 0, m);
				a = na;
				b = nb;
			}
			butterfly(a);
			butterfly(b);
			for (int i = 0; i < z; i++) {
				a[i] = safeMod(a[i] * b[i]);
			}
			butterflyInv(a);
			a = Arrays.copyOf(a, (n + m) - 1);
			long iz = invMod(z);
			for (int i = 0; i < ((n + m) - 1); i++) {
				a[i] = safeMod(a[i] * iz);
			}
			return a;
		}

		private static long[] convolution(long[] a, int aFromIndex, int aToIndex, long[] b, int bFromIndex,
				int bToIndex) {
			int n = aToIndex - aFromIndex, m = bToIndex - bFromIndex;
			if ((0 == n) || (0 == m)) {
				return new long[0];
			}

			int z = bitCeil(n + m - 1);
			if (!(0 == (MOD - 1) % z)) {
				throw new IllegalArgumentException("(" + MOD + "-1)%" + z + "!=0");
			}

			if (Math.min(n, m) <= 60) {
				return convolutionNaive(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex);
			} else {
				return convolutionFft(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex);
			}
		}

		private static void init(int m) {
			if (m != MOD) {
				MOD = m;
				g = primitiveRoot(MOD);
				info = new FftInfo();
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
		static long[] convolution(long[] a, long[] b, int m) {
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
		static long[] convolution(long[] a, int aFromIndex, int aToIndex, long[] b, int bFromIndex, int bToIndex,
				int m) {
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
			init(m);
			return convolution(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex);
		}

		private static final long MOD1 = 754_974_721L; // 2^24
		private static final long MOD2 = 167_772_161L; // 2^25
		private static final long MOD3 = 469_762_049L; // 2^26
		private static final long M2M3 = MOD2 * MOD3;
		private static final long M1M3 = MOD1 * MOD3;
		private static final long M1M2 = MOD1 * MOD2;
		private static final long M1M2M3 = MOD1 * MOD2 * MOD3;

		private static final long i1 = invGcd(MOD2 * MOD3, MOD1)[1];
		private static final long i2 = invGcd(MOD1 * MOD3, MOD2)[1];
		private static final long i3 = invGcd(MOD1 * MOD2, MOD3)[1];

		private static final int MAX_AB_BIT = 24;

		/**
		 * 畳み込みを計算します。a,b の少なくとも一方が空配列の場合は空配列を返します。
		 *
		 * @param a
		 * @param b
		 * @return 計算した結果配列
		 */
		@SuppressWarnings("unused")
		static long[] convolutionLong(long[] a, long[] b) {
			return convolutionLong(a, 0, a.length, b, 0, b.length);
		}

		/**
		 * 畳み込みを計算します。a,b の少なくとも一方が空配列の場合は空配列を返します。
		 *
		 * @param a
		 * @param aFromIndex
		 * @param aToIndex
		 * @param b
		 * @param bFromIndex
		 * @param bToIndex
		 * @return 計算した結果配列
		 */
		static long[] convolutionLong(long[] a, int aFromIndex, int aToIndex, long[] b, int bFromIndex, int bToIndex) {
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
			int n = aToIndex - aFromIndex, m = bToIndex - bFromIndex;
			if ((0 == n) || (0 == m)) {
				return new long[0];
			}
			if (!(n + m - 1 <= (1 << MAX_AB_BIT))) {
				throw new IllegalArgumentException(
						"n=" + n + ", m=" + m + ", n+m-1=" + (n + m - 1) + ">" + (1 << MAX_AB_BIT));
			}

			long[] c1 = convolution(a, b, (int) MOD1);
			long[] c2 = convolution(a, b, (int) MOD2);
			long[] c3 = convolution(a, b, (int) MOD3);

			long[] c = new long[(n + m) - 1];
			for (int i = 0; i < ((n + m) - 1); i++) {
				long x = 0L;
				x += ((c1[i] * i1) % MOD1) * M2M3;
				x += ((c2[i] * i2) % MOD2) * M1M3;
				x += ((c3[i] * i3) % MOD3) * M1M2;
				int diff = (int) safeMod(c1[i] - safeMod(x, MOD1), MOD1);
				long[] offset = { 0L, 0L, M1M2M3, 2 * M1M2M3, 3 * M1M2M3 };
				x -= offset[diff % 5];
				c[i] = x;
			}

			return c;
		}

		// 以下 https://github.com/atcoder/ac-library/blob/master/atcoder/internal_math.hpp を参考に作成
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
		static long safeMod(long x, long m) {
			x %= m;
			if (x < 0) {
				x += m;
			}
			return x;
		}

		static long invMod(long x) {
			return invMod(x, MOD);
		}

		/**
		 * xy≡1(mod m) なる y のうち、0≤y<m を満たすものを返します。
		 *
		 * @param x
		 * @param m
		 * @return xy≡1 (mod m) なる y のうち、0≤y<m を満たすもの
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
		 * @param a
		 * @param b `1 <= b`
		 * @return {g, x} s.t. g = gcd(a, b), x a = g (mod b), 0 <= x < b/g
		 */
		static long[] invGcd(long a, long b) {
			a = safeMod(a, b);
			if (a == 0) {
				return new long[] { b, 0 };
			}

			long s = b, t = a;
			long m0 = 0L, m1 = 1L;

			while (t != 0) {
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
			for (int i = 3; ((long) (i) * i) <= x; i += 2) {
				if (0 == (x % i)) {
					divs[cnt++] = i;
					while (0 == (x % i)) {
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
		 * n以上最小の2^xの数字を計算する
		 *
		 * @param n
		 * @return n以上最小の2^xの数字
		 */
		static int bitCeil(int n) {
			int x = 1;
			while (x < n) {
				x <<= 1;
			}
			return x;
		}

		/**
		 * 入力数値を2進で表した場合に、右から連続した0のビットを数える
		 *
		 * @param n 数値
		 * @return 2進で表した場合に、右から連続した0のビット
		 */
		static int countrZero(int n) {
			return Integer.numberOfTrailingZeros(n);
		}

		private static class FftInfo {
			final int rank2;
			final long[] root;
			final long[] iroot;
			final long[] rate2;
			final long[] irate2;
			final long[] rate3;
			final long[] irate3;

			FftInfo() {
				rank2 = countrZero(MOD - 1);
				root = new long[rank2 + 1];
				iroot = new long[rank2 + 1];
				rate2 = new long[Math.max(0, rank2 - 2 + 1)];
				irate2 = new long[Math.max(0, rank2 - 2 + 1)];
				rate3 = new long[Math.max(0, rank2 - 3 + 1)];
				irate3 = new long[Math.max(0, rank2 - 3 + 1)];
				init();
			}

			void init() {
				root[rank2] = powMod(g, (MOD - 1) >> rank2);
				iroot[rank2] = invMod(root[rank2]);
				for (int i = rank2 - 1; i >= 0; i--) {
					root[i] = safeMod(root[i + 1] * root[i + 1]);
					iroot[i] = safeMod(iroot[i + 1] * iroot[i + 1]);
				}
				{
					long prod = 1L, iprod = 1L;
					for (int i = 0; i <= rank2 - 2; i++) {
						rate2[i] = safeMod(root[i + 2] * prod);
						irate2[i] = safeMod(iroot[i + 2] * iprod);
						prod = safeMod(prod * iroot[i + 2]);
						iprod = safeMod(iprod * root[i + 2]);
					}
				}
				{
					long prod = 1L, iprod = 1L;
					for (int i = 0; i <= rank2 - 3; i++) {
						rate3[i] = safeMod(root[i + 3] * prod);
						irate3[i] = safeMod(iroot[i + 3] * iprod);
						prod = safeMod(prod * iroot[i + 3]);
						iprod = safeMod(iprod * root[i + 3]);
					}
				}
			}
		}
	}
}
