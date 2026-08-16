package abc.abc201_250.abc240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc240/editorial/3441 の実装<br/>
 * https://atcoder.jp/contests/abc240/submissions/29496482 にも参考
 */
public class ProblemEx別回答 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	private static final int N = 20;

	/** aaa[k][i]=[i,i+2**k)の最小値 */
	private static int[][] aaa;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String s = scanner.next();
			int[] sa = AtcoderString.suffixArray(s);
			int[] lcpa = AtcoderString.lcpArray(s, sa);
			int[] invsa = new int[n];
			IntStream.range(0, n).forEach(i -> invsa[sa[i]] = i);

			aaa = new int[N][n];
			System.arraycopy(lcpa, 0, aaa[0], 0, lcpa.length);
			IntStream.range(0, N - 1).forEach(k -> IntStream.range(0, n - 1)
					.forEach(i -> aaa[k + 1][i] = Math.min(aaa[k][i], aaa[k][Math.min(n - 1, i + (1 << k))])));

			int u = (int) (Math.sqrt(8 * n + 1) - 1) / 2;
			List<int[]> list = new ArrayList<>();
			IntStream.range(0, n).forEach(
					l -> IntStream.rangeClosed(l + 1, Math.min(l + u, n)).forEach(r -> list.add(new int[] { l, r })));
			list.sort((p, q) -> {
				int pl = p[0], pr = p[1], ql = q[0], qr = q[1];
				int lcpn = rmq(Math.min(invsa[pl], invsa[ql]), Math.max(invsa[pl], invsa[ql]));
				if ((lcpn >= pr - pl) || (lcpn >= qr - ql)) {
					if (pr - pl == qr - ql) {
						return Integer.compare(ql, pl);
					} else {
						return Integer.compare(pr - pl, qr - ql);
					}
				}
				return Character.compare(s.charAt(pl + lcpn), s.charAt(ql + lcpn));
			});
			IntSegTree seg = new IntSegTree(n + 1, (x, y) -> Math.max(x, y), () -> 0);
			list.forEach(a -> {
				int l = a[0], r = a[1];
				seg.set(r, Math.max(seg.get(r), seg.prod(0, l + 1) + 1));
			});
			System.out.println(seg.allProd());
		}
	}

	/**
	 * [sa[l],n)と[sa[r],n)のLCPを計算する
	 *
	 * @param l
	 * @param r
	 * @return [sa[l],n)と[sa[r],n)のLCP
	 */
	private static int rmq(int l, int r) {
		if (l == r) {
			return INF;
		}
		int k = Integer.SIZE - 1 - Integer.numberOfLeadingZeros(r - l);
		return Math.min(aaa[k][l], aaa[k][r - (1 << k)]);
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp を参考に作成
	 */
	static class IntSegTree {
		final int n, size;
		final int[] d;
		final IntBinaryOperator op;
		final IntSupplier e;

		/**
		 * コンストラクター
		 *
		 * @param op
		 * @param e
		 */
		IntSegTree(IntBinaryOperator op, IntSupplier e) {
			this(0, op, e);
		}

		/**
		 * コンストラクター
		 *
		 * @param n
		 * @param op
		 * @param e
		 */
		IntSegTree(int n, IntBinaryOperator op, IntSupplier e) {
			this.n = n;
			this.op = op;
			this.e = e;
			size = bitCeil(n);
			d = new int[size << 1];
			Arrays.fill(d, e.getAsInt());
			for (int i = size - 1; i >= 1; i--) {
				update(i);
			}
		}

		/**
		 * コンストラクター
		 *
		 * @param v
		 * @param op
		 * @param e
		 */
		IntSegTree(int[] v, IntBinaryOperator op, IntSupplier e) {
			n = v.length;
			this.e = e;
			this.op = op;
			size = bitCeil(n);
			d = new int[size << 1];
			Arrays.fill(d, e.getAsInt());
			// https://atcoder.jp/contests/practice2/submissions/17594068 に参考
			// そのまま代入の場合、REが発生する
			System.arraycopy(v, 0, d, size, n);
			for (int i = size - 1; i >= 1; i--) {
				update(i);
			}
		}

		/**
		 * a[p] に x を代入する
		 *
		 * @param p
		 * @param x
		 */
		void set(int p, int x) {
			if (!(0 <= p && p < n)) {
				throw new IllegalArgumentException("p is " + p);
			}
			p += size;
			d[p] = x;
			while (p > 1) {
				p >>= 1;
				update(p);
			}
		}

		/**
		 * a[p] を返す
		 *
		 * @param p
		 * @return a[p]
		 */
		int get(int p) {
			if (!(0 <= p && p < n)) {
				throw new IllegalArgumentException("p is " + p);
			}
			return d[p + size];
		}

		/**
		 * op(a[l], ..., a[r - 1]) を、モノイドの性質を満たしていると仮定して計算します。
		 *
		 * @param l
		 * @param r
		 * @return op(a[l], ..., a[r - 1])、 l==r のときは e()。
		 */
		int prod(int l, int r) {
			if (!(0 <= l && l <= r && r <= n)) {
				throw new IllegalArgumentException("l is " + l + ", r is " + r);
			}
			int sml = e.getAsInt(), smr = e.getAsInt();
			l += size;
			r += size;

			while (l < r) {
				if (0 != (l & 1)) {
					sml = op.applyAsInt(sml, d[l++]);
				}
				if (0 != (r & 1)) {
					smr = op.applyAsInt(d[--r], smr);
				}
				l >>= 1;
				r >>= 1;
			}
			return op.applyAsInt(sml, smr);
		}

		/**
		 * op(a[0], ..., a[n - 1]) を計算します。n==0 のときは e() を返します。
		 *
		 * @return op(a[0], ..., a[n - 1])、n==0 のときは e()。
		 */
		int allProd() {
			return d[1];
		}

		/**
		 * 以下の条件を両方満たす r を(いずれか一つ)返します。<br/>
		 * r = l もしくは fRight(op(a[l], a[l + 1], ..., a[r - 1])) = true <br/>
		 * r = n もしくは fRight(op(a[l], a[l + 1], ..., a[r])) = false <br/>
		 * fが単調だとすれば、fRight(op(a[l], a[l + 1], ..., a[r - 1])) = true となる最大の r、と解釈することが可能です。
		 *
		 * @param l
		 * @param f
		 * @return 条件を両方満たす r を(いずれか一つ)
		 */
		int maxRight(int l, IntPredicate f) {
			if (!(0 <= l && l <= n)) {
				throw new IllegalArgumentException("l is " + l);
			}
			if (!f.test(e.getAsInt())) {
				throw new IllegalArgumentException("f.test(e()) is " + f.test(e.getAsInt()));
			}
			if (l == n) {
				return n;
			}
			l += size;
			int sm = e.getAsInt();
			do {
				while (0 == (l & 1)) {
					l >>= 1;
				}
				if (!f.test(op.applyAsInt(sm, d[l]))) {
					while (l < size) {
						l <<= 1;
						int tmp = op.applyAsInt(sm, d[l]);
						if (f.test(tmp)) {
							sm = tmp;
							l++;
						}
					}
					return l - size;
				}
				sm = op.applyAsInt(sm, d[l]);
				l++;
			} while ((l & -l) != l);
			return n;
		}

		/**
		 * 以下の条件を両方満たす l を(いずれか一つ)返します。<br/>
		 * l = r もしくは f(op(a[l], a[l + 1], ..., a[r - 1])) = true <br/>
		 * l = 0 もしくは f(op(a[l - 1], a[l], ..., a[r - 1])) = false <br/>
		 * fが単調だとすれば、f(op(a[l], a[l + 1], ..., a[r - 1])) = true となる最小の l、と解釈することが可能です。
		 *
		 * @param r
		 * @param f
		 * @return 条件を両方満たす l を(いずれか一つ)
		 */
		int minLeft(int r, IntPredicate f) {
			if (!(0 <= r && r <= n)) {
				throw new IllegalArgumentException("r is " + r);
			}
			if (!f.test(e.getAsInt())) {
				throw new IllegalArgumentException("f.test(e()) is " + f.test(e.getAsInt()));
			}
			if (0 == r) {
				return 0;
			}
			r += size;
			int sm = e.getAsInt();
			do {
				r--;
				while (r > 1 && 0 != (r & 1)) {
					r >>= 1;
				}
				if (!f.test(op.applyAsInt(d[r], sm))) {
					while (r < size) {
						r = (2 * r + 1);
						int tmp = op.applyAsInt(d[r], sm);
						if (f.test(tmp)) {
							sm = tmp;
							r--;
						}
					}
					return r + 1 - size;
				}
				sm = op.applyAsInt(d[r], sm);
			} while ((r & -r) != r);
			return 0;
		}

		private void update(int k) {
			d[k] = op.applyAsInt(d[k << 1], d[(k << 1) | 1]);
		}

		/**
		 * n以上最小の2^xの数字を計算する
		 *
		 * @param n
		 * @return n以上最小の2^xの数字
		 */
		private static int bitCeil(int n) {
			if (!(0 <= n)) {
				throw new IllegalArgumentException("n is " + n);
			}
			int x = 1;
			while (x < n) {
				x <<= 1;
			}
			return x;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/string.hpp を参考に作成
	 */
	static class AtcoderString {
		static int[] saNaive(int[] s) {
			int n = s.length;
			return IntStream.range(0, n).boxed().sorted((l, r) -> {
				if (Objects.equals(l, r)) {
					return 0;
				}
				while (l < n && r < n) {
					if (s[l] != s[r]) {
						return Integer.compare(s[l], s[r]);
					}
					l++;
					r++;
				}
				return (l == n) ? -1 : 1;
			}).mapToInt(Integer::intValue).toArray();
		}

		static int[] saDoubling(int[] s) {
			int n = s.length;
			Integer[] sa = IntStream.range(0, n).boxed().toArray(Integer[]::new);
			int[] rnk2 = Arrays.copyOf(s, n), tmp = new int[n];
			for (int k2 = 0; (1 << k2) < n; k2++) {
				int[] rnk = rnk2;
				int k = 1 << k2;
				Arrays.sort(sa, (x, y) -> {
					if (rnk[x] != rnk[y]) {
						return Integer.compare(rnk[x], rnk[y]);
					}
					int rx = (x + k < n) ? rnk[x + k] : -1;
					int ry = (y + k < n) ? rnk[y + k] : -1;
					return Integer.compare(rx, ry);
				});
				tmp[sa[0]] = 0;
				for (int i = 1; i < n; i++) {
					tmp[sa[i]] = tmp[sa[i - 1]] + (cmp(sa[i - 1], sa[i], n, k, rnk) ? 1 : 0);
				}
				int[] tmp2 = tmp;
				tmp = rnk2;
				rnk2 = tmp2;
			}
			return Arrays.stream(sa).mapToInt(Integer::intValue).toArray();
		}

		private static boolean cmp(final int x, final int y, final int n, final int k, final int[] rnk) {
			if (rnk[x] != rnk[y]) {
				return rnk[x] < rnk[y];
			}
			int rx = (x + k < n) ? rnk[x + k] : -1;
			int ry = (y + k < n) ? rnk[y + k] : -1;
			return rx < ry;
		}

		private static final int THRESHOLD_NAIVE = 10;
		private static final int THRESHOLD_DOUBLING = 40;

		static int[] saIs(int[] s, int upper) {
			return saIs(s, upper, THRESHOLD_NAIVE, THRESHOLD_DOUBLING);
		}

		static int[] saIs(int[] s, int upper, final int naive, final int doubling) {
			if (null == s) {
				return new int[] {};
			}
			int n = s.length;
			if (0 == n) {
				return new int[] {};
			}
			if (1 == n) {
				return new int[] { 0 };
			}
			if (2 == n) {
				if (s[0] < s[1]) {
					return new int[] { 0, 1 };
				} else {
					return new int[] { 1, 0 };
				}
			}
			if (n < naive) {
				return saNaive(s);
			}
			if (n < doubling) {
				return saDoubling(s);
			}
			int[] sa = new int[n];
			boolean[] ls = new boolean[n];
			for (int i = n - 2; i >= 0; i--) {
				ls[i] = (s[i] == s[i + 1]) ? ls[i + 1] : (s[i] < s[i + 1]);
			}
			int[] sumL = new int[upper + 1], sumS = new int[upper + 1];
			for (int i = 0; i < n; i++) {
				if (!ls[i]) {
					sumS[s[i]]++;
				} else {
					sumL[s[i] + 1]++;
				}
			}
			for (int i = 0; i <= upper; i++) {
				sumS[i] += sumL[i];
				if (i < upper) {
					sumL[i + 1] += sumS[i];
				}
			}
			int[] lmsMap = new int[n + 1];
			Arrays.fill(lmsMap, -1);
			int m = 0;
			for (int i = 1; i < n; i++) {
				if (!ls[i - 1] && ls[i]) {
					lmsMap[i] = m++;
				}
			}
			int[] lms = IntStream.range(1, n).filter(i -> !ls[i - 1] && ls[i]).toArray();
			induce(n, s, upper, sa, ls, sumL, sumS, lms);

			if (0 != m) {
				int[] sortedLms = Arrays.stream(sa).filter(v -> lmsMap[v] != -1).toArray();
				int[] recS = new int[m];
				int recUpper = 0;
				recS[lmsMap[sortedLms[0]]] = 0;
				for (int i = 1; i < m; i++) {
					int l = sortedLms[i - 1], r = sortedLms[i];
					int endL = (lmsMap[l] + 1 < m) ? lms[lmsMap[l] + 1] : n;
					int endR = (lmsMap[r] + 1 < m) ? lms[lmsMap[r] + 1] : n;
					boolean same = true;
					if (endL - l != endR - r) {
						same = false;
					} else {
						while (l < endL) {
							if (s[l] != s[r]) {
								break;
							}
							l++;
							r++;
						}
						if ((l == n) || (s[l] != s[r])) {
							same = false;
						}
					}
					if (!same) {
						recUpper++;
					}
					recS[lmsMap[sortedLms[i]]] = recUpper;
				}
				int[] recSa = saIs(recS, recUpper);

				for (int i = 0; i < m; i++) {
					sortedLms[i] = lms[recSa[i]];
				}
				induce(n, s, upper, sa, ls, sumL, sumS, sortedLms);
			}
			return sa;
		}

		private static void induce(int n, int[] s, int upper, int[] sa, boolean[] ls, int[] sumL, int[] sumS,
				int[] lms) {
			Arrays.fill(sa, -1);
			int[] buf = new int[upper + 1];
			System.arraycopy(sumS, 0, buf, 0, upper + 1);
			for (int d : lms) {
				if (d != n) {
					sa[buf[s[d]]++] = d;
				}
			}
			System.arraycopy(sumL, 0, buf, 0, upper + 1);
			sa[buf[s[n - 1]]++] = n - 1;
			for (int i = 0; i < n; i++) {
				int v = sa[i];
				if ((v >= 1) && !ls[v - 1]) {
					sa[buf[s[v - 1]]++] = v - 1;
				}
			}
			System.arraycopy(sumL, 0, buf, 0, upper + 1);
			for (int i = n - 1; i >= 0; i--) {
				int v = sa[i];
				if ((v >= 1) && ls[v - 1]) {
					sa[--buf[s[v - 1] + 1]] = v - 1;
				}
			}
		}

		/**
		 * 配列sのSuffix Arrayを計算する
		 *
		 * @param s     配列
		 * @param upper sの最大値
		 * @return 配列sのSuffix Array
		 */
		static int[] suffixArray(int[] s, int upper) {
			if (!(0 <= upper)) {
				throw new IllegalArgumentException("upper is " + upper);
			}
			for (int d : s) {
				if (!(0 <= d && d <= upper)) {
					throw new IllegalArgumentException("upper is " + upper + ", d is " + d);
				}
			}
			return saIs(s, upper);
		}

		/**
		 * 配列sのSuffix Arrayを計算する
		 *
		 * @param s 配列
		 * @return 配列sのSuffix Array
		 */
		static int[] suffixArray(int[] s) {
			int n = s.length;
			int[] idx = IntStream.range(0, n).boxed().sorted((a, b) -> Integer.compare(s[a], s[b])).mapToInt(i -> i)
					.toArray();
			int[] s2 = new int[n];
			int now = 0;
			for (int i = 0; i < n; i++) {
				if ((i > 0) && (s[idx[i - 1]] != s[idx[i]])) {
					now++;
				}
				s2[idx[i]] = now;
			}
			return saIs(s2, now);
		}

		/**
		 * 文字列sのSuffix Arrayを計算する
		 *
		 * @param s 文字列
		 * @return 文字列sのSuffix Array
		 */
		static int[] suffixArray(String s) {
			return saIs(IntStream.range(0, s.length()).map(i -> s.charAt(i)).toArray(), 255);
		}

		/**
		 * 配列sのLCP Arrayを計算する
		 *
		 * @param s  配列
		 * @param sa sのSuffix Array
		 * @return 配列sのLCP Array，i番目の要素は s[sa[i]..n), s[sa[i+1]..n) の LCP(Longest Common Prefix) の長さ。
		 */
		static int[] lcpArray(int[] s, int[] sa) {
			if (!(s.length == sa.length)) {
				throw new IllegalArgumentException("s.length=" + s.length + ", sa.length=" + sa.length);
			}
			int n = s.length;
			if (!(n >= 1)) {
				throw new IllegalArgumentException("n is " + n);
			}
			int[] rnk = new int[n];
			for (int i = 0; i < n; i++) {
				if (!((sa[i] >= 0) && (sa[i] < n))) {
					throw new IllegalArgumentException("sa[" + i + "]=" + sa[i]);
				}
				rnk[sa[i]] = i;
			}
			int[] lcp = new int[n - 1];
			int h = 0;
			for (int i = 0; i < n; i++) {
				if (h > 0) {
					h--;
				}
				if (0 == rnk[i]) {
					continue;
				}
				int j = sa[rnk[i] - 1];
				for (; (j + h < n) && (i + h < n); h++) {
					if (s[j + h] != s[i + h]) {
						break;
					}
				}
				lcp[rnk[i] - 1] = h;
			}
			return lcp;
		}

		/**
		 * 配列sのLCP Arrayを計算する
		 *
		 * @param s  配列
		 * @param sa sのSuffix Array
		 * @return 配列sのLCP Array，i番目の要素は s[sa[i]..n), s[sa[i+1]..n) の LCP(Longest Common Prefix) の長さ。
		 */
		static int[] lcpArray(long[] s, int[] sa) {
			int n = s.length;
			if (!(n >= 1)) {
				throw new IllegalArgumentException("n is " + n);
			}
			int[] rnk = new int[n];
			for (int i = 0; i < n; i++) {
				rnk[sa[i]] = i;
			}
			int[] lcp = new int[n - 1];
			int h = 0;
			for (int i = 0; i < n; i++) {
				if (h > 0) {
					h--;
				}
				if (0 == rnk[i]) {
					continue;
				}
				int j = sa[rnk[i] - 1];
				for (; (j + h < n) && (i + h < n); h++) {
					if (s[j + h] != s[i + h]) {
						break;
					}
				}
				lcp[rnk[i] - 1] = h;
			}
			return lcp;
		}

		/**
		 * 文字列sのLCP Arrayを計算する
		 *
		 * @param s  文字列
		 * @param sa sのSuffix Array
		 * @return 文字列sのLCP Array，i番目の要素は s[sa[i]..n), s[sa[i+1]..n) の LCP(Longest Common Prefix) の長さ。
		 */
		static int[] lcpArray(String s, int[] sa) {
			return lcpArray(IntStream.range(0, s.length()).map(i -> s.charAt(i)).toArray(), sa);
		}

		/**
		 * @param s 配列
		 * @return 長さnの配列。 i番目の要素は s[0..n)とs[i..n)のLCP(Longest Common Prefix)の長さ。
		 */
		static int[] zAlgorithm(int[] s) {
			int n = s.length;
			if (0 == n) {
				return new int[] {};
			}
			int[] z = new int[n];
			z[0] = 0;
			for (int i = 1, j = 0; i < n; i++) {
				z[i] = (j + z[j] <= i) ? 0 : Math.min(j + z[j] - i, z[i - j]);
				while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
					z[i]++;
				}
				if (j + z[j] < i + z[i]) {
					j = i;
				}
			}
			z[0] = n;
			return z;
		}

		/**
		 * @param s 配列
		 * @return 長さnの配列。 i番目の要素は s[0..n)とs[i..n)のLCP(Longest Common Prefix)の長さ。
		 */
		static int[] zAlgorithm(char[] s) {
			int n = s.length;
			if (0 == n) {
				return new int[] {};
			}
			int[] z = new int[n];
			z[0] = 0;
			for (int i = 1, j = 0; i < n; i++) {
				z[i] = (j + z[j] <= i) ? 0 : Math.min(j + z[j] - i, z[i - j]);
				while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
					z[i]++;
				}
				if (j + z[j] < i + z[i]) {
					j = i;
				}
			}
			z[0] = n;
			return z;
		}

		/**
		 * @param s 文字列
		 * @return 長さnの配列。 i番目の要素は s[0..n)とs[i..n)のLCP(Longest Common Prefix)の長さ。
		 */
		static int[] zAlgorithm(String s) {
			return zAlgorithm(s.toCharArray());
		}
	}
}
