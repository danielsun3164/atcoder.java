package abc.abc201_250.abc216;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc216/editorial/2569 の解説のSegtreeの実装
 */
public class ProblemG別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] l = new int[m], r = new int[m], x = new int[m];
			IntStream.range(0, m).forEach(i -> {
				l[i] = scanner.nextInt() - 1;
				r[i] = scanner.nextInt();
				x[i] = scanner.nextInt();
			});
			Integer[] indexes = IntStream.range(0, m).boxed().sorted((a, b) -> Integer.compare(r[a], r[b]))
					.toArray(Integer[]::new);
			int[] a = new int[n];
			Arrays.fill(a, 0);
			IntSegTree sumSegTree = new IntSegTree(n, (p, q) -> p + q, () -> 0);
			IntSegTree posSegTree = new IntSegTree(n, (p, q) -> Math.max(p, q), () -> -1);
			IntStream.range(0, n).forEach(i -> posSegTree.set(i, i));
			Arrays.stream(indexes).forEach(i -> {
				int ones = x[i] - sumSegTree.prod(l[i], r[i]);
				IntStream.range(0, ones).forEach(j -> {
					int p = posSegTree.prod(l[i], r[i]);
					a[p] = 1;
					sumSegTree.set(p, 1);
					posSegTree.set(p, -1);
				});
			});
			System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp を参考に作成
	 */
	private static class IntSegTree {
		final int n, size;
		final int[] d;
		final IntBinaryOperator op;
		final IntSupplier e;

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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
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
