package abc.abc201_250.abc246;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3705 の実装<br/>
 * https://atcoder.jp/contests/abc212/submissions/24641867 にも参考
 */
public class ProblemEx {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 実行速度を上げるため、2次元配列を1次元に変換 */
	private static final long[][] MATRIX = { { 1, 1, 1, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 0, 0, 1 } };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			BinaryOperator<long[]> op = (a, b) -> {
				long a00 = a[0], a01 = a[1], a02 = a[2], a10 = a[3], a11 = a[4], a12 = a[5], a20 = a[6], a21 = a[7],
						a22 = a[8];
				long b00 = b[0], b01 = b[1], b02 = b[2], b10 = b[3], b11 = b[4], b12 = b[5], b20 = b[6], b21 = b[7],
						b22 = b[8];
				return new long[] { (a00 * b00 + a01 * b10 + a02 * b20) % MOD,
						(a00 * b01 + a01 * b11 + a02 * b21) % MOD, (a00 * b02 + a01 * b12 + a02 * b22) % MOD,
						(a10 * b00 + a11 * b10 + a12 * b20) % MOD, (a10 * b01 + a11 * b11 + a12 * b21) % MOD,
						(a10 * b02 + a11 * b12 + a12 * b22) % MOD, (a20 * b00 + a21 * b10 + a22 * b20) % MOD,
						(a20 * b01 + a21 * b11 + a22 * b21) % MOD, (a20 * b02 + a21 * b12 + a22 * b22) % MOD };
			};
			Supplier<long[]> e = () -> new long[] { 1, 0, 0, 0, 1, 0, 0, 0, 1 };
			long[][] v = IntStream.range(0, n).mapToObj(i -> switch (s[i]) {
			case '0' -> MATRIX[0];
			case '1' -> MATRIX[1];
			default -> MATRIX[2];
			}).toArray(long[][]::new);
			SegTree<long[]> seg = new SegTree<>(v, op, e);
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int x = scanner.nextInt() - 1;
				String c = scanner.next();
				seg.set(x, switch (c) {
				case "0" -> MATRIX[0];
				case "1" -> MATRIX[1];
				default -> MATRIX[2];
				});
				long[] result = seg.prod(0, n);
				sb.append((result[2] + result[5]) % MOD).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp を参考に作成
	 */
	static class SegTree<S> {
		final int n, size;
		final S[] d;
		final BinaryOperator<S> op;
		final Supplier<S> e;

		/**
		 * コンストラクター
		 *
		 * @param op
		 * @param e
		 */
		SegTree(BinaryOperator<S> op, Supplier<S> e) {
			this(0, op, e);
		}

		/**
		 * コンストラクター
		 *
		 * @param n
		 * @param op
		 * @param e
		 */
		@SuppressWarnings({ "unchecked" })
		SegTree(int n, BinaryOperator<S> op, Supplier<S> e) {
			this.n = n;
			this.op = op;
			this.e = e;
			size = bitCeil(n);
			d = (S[]) new Object[size << 1];
			Arrays.fill(d, e.get());
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
		@SuppressWarnings("unchecked")
		SegTree(S[] v, BinaryOperator<S> op, Supplier<S> e) {
			n = v.length;
			this.e = e;
			this.op = op;
			size = bitCeil(n);
			d = (S[]) new Object[size << 1];
			Arrays.fill(d, e.get());
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
		void set(int p, S x) {
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
		S get(int p) {
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
		S prod(int l, int r) {
			if (!(0 <= l && l <= r && r <= n)) {
				throw new IllegalArgumentException("l is " + l + ", r is " + r);
			}
			S sml = e.get(), smr = e.get();
			l += size;
			r += size;

			while (l < r) {
				if (0 != (l & 1)) {
					sml = op.apply(sml, d[l++]);
				}
				if (0 != (r & 1)) {
					smr = op.apply(d[--r], smr);
				}
				l >>= 1;
				r >>= 1;
			}
			return op.apply(sml, smr);
		}

		/**
		 * op(a[0], ..., a[n - 1]) を計算します。n==0 のときは e() を返します。
		 *
		 * @return op(a[0], ..., a[n - 1])、n==0 のときは e()。
		 */
		S allProd() {
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
		int maxRight(int l, Predicate<S> f) {
			if (!(0 <= l && l <= n)) {
				throw new IllegalArgumentException("l is " + l);
			}
			if (!f.test(e.get())) {
				throw new IllegalArgumentException("f.test(e()) is " + f.test(e.get()));
			}
			if (l == n) {
				return n;
			}
			l += size;
			S sm = e.get();
			do {
				while (0 == (l & 1)) {
					l >>= 1;
				}
				if (!f.test(op.apply(sm, d[l]))) {
					while (l < size) {
						l <<= 1;
						S tmp = op.apply(sm, d[l]);
						if (f.test(tmp)) {
							sm = tmp;
							l++;
						}
					}
					return l - size;
				}
				sm = op.apply(sm, d[l]);
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
		int minLeft(int r, Predicate<S> f) {
			if (!(0 <= r && r <= n)) {
				throw new IllegalArgumentException("r is " + r);
			}
			if (!f.test(e.get())) {
				throw new IllegalArgumentException("f.test(e()) is " + f.test(e.get()));
			}
			if (0 == r) {
				return 0;
			}
			r += size;
			S sm = e.get();
			do {
				r--;
				while (r > 1 && 0 != (r & 1)) {
					r >>= 1;
				}
				if (!f.test(op.apply(d[r], sm))) {
					while (r < size) {
						r = (2 * r + 1);
						S tmp = op.apply(d[r], sm);
						if (f.test(tmp)) {
							sm = tmp;
							r--;
						}
					}
					return r + 1 - size;
				}
				sm = op.apply(d[r], sm);
			} while ((r & -r) != r);
			return 0;
		}

		private void update(int k) {
			d[k] = op.apply(d[k << 1], d[(k << 1) | 1]);
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
