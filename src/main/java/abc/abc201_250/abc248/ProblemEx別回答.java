package abc.abc201_250.abc248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/11707 の実装<br/>
 * https://atcoder.jp/contests/abc248/submissions/61226464 にも参考
 */
public class ProblemEx別回答 {

	/** 共通変数 */
	private static int[] p;
	private static Data[] base;
	private static long answer;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			p = IntStream.range(0, n).map(_ -> scanner.nextInt() - 1).toArray();
			base = new Data[n + 2];
			answer = 0;
			calc(n, k, 0, n);
			System.out.println(answer);
		}
	}

	private static void calc(int n, int k, int l, int r) {
		if (l == r) {
			return;
		}
		if (l + 1 == r) {
			answer++;
			return;
		}
		int m = (l + r) >> 1;
		calc(n, k, l, m);
		calc(n, k, m + 1, r);
		base[m] = new Data(p[m], p[m]);
		IntStream.iterate(m - 1, i -> i >= l, i -> i - 1).forEach(i -> {
			base[i] = base[i + 1].copy();
			base[i].add(p[i]);
		});
		IntStream.range(m + 1, r).forEach(i -> {
			base[i] = base[i - 1].copy();
			base[i].add(p[i]);
		});
		int[] index = new int[] { m + 1, m + 1 };
		@SuppressWarnings("unchecked")
		List<int[]>[] b = new List[4];
		IntStream.range(0, 4).forEach(i -> b[i] = new ArrayList<>());
		for (int i = m; i >= l; i--) {
			for (int j = 0; j < 2; j++) {
				while (index[j] != r) {
					Data tmp = base[index[j]];
					if (((0 == j) && (tmp.x < base[i].x)) || ((1 == j) && (tmp.y > base[i].y))) {
						break;
					}
					index[j]++;
				}
			}
			int r0 = m, r1 = Math.min(index[0], index[1]), r2 = Math.max(index[0], index[1]), r3 = r;
			Data tmp = base[i];
			b[0].add(new int[] { tmp.y - tmp.x - k + i, r0 - m, r1 - m });
			if (r1 == index[0]) {
				b[1].add(new int[] { tmp.y - k + i, r1 - m, r2 - m });
			} else {
				b[2].add(new int[] { -tmp.x - k + i, r1 - m, r2 - m });
			}
			b[3].add(new int[] { i - k, r2 - m, r3 - m });
		}
		@SuppressWarnings("unchecked")
		List<int[]>[] a = new List[4];
		IntStream.range(0, 4).forEach(j -> a[j] = new ArrayList<>(r - m));
		IntStream.range(m, r).forEach(j -> {
			a[0].add(new int[] { j, j - m });
			a[1].add(new int[] { j + base[j].x, j - m });
			a[2].add(new int[] { j - base[j].y, j - m });
			a[3].add(new int[] { j - base[j].y + base[j].x, j - m });
		});
		for (int j = 0; j < 4; j++) {
			a[j].sort((p, q) -> Arrays.compare(q, p));
			b[j].sort((p, q) -> Arrays.compare(q, p));
			IntSegTree seg = new IntSegTree(r - m, (p, q) -> p + q, () -> 0);
			int aIndex = 0;
			for (int[] bji : b[j]) {
				while ((aIndex < a[j].size()) && (a[j].get(aIndex)[0] >= bji[0])) {
					seg.set(a[j].get(aIndex++)[1], 1);
				}
				answer += seg.prod(bji[1], bji[2]);
			}
		}
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Data {
		int x, y;

		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void add(int a) {
			x = Math.min(x, a);
			y = Math.max(y, a);
		}

		Data copy() {
			return new Data(x, y);
		}
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
}
