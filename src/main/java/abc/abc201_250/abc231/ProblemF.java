package abc.abc201_250.abc231;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc231/editorial/3059 の実装<br/>
 * https://atcoder.jp/contests/abc231/submissions/27806000 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = compress(scanner, n), b = compress(scanner, n);
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(-a[i], b[i]))
					.sorted((x, y) -> (x.a == y.a) ? Integer.compare(x.b, y.b) : Integer.compare(x.a, y.a))
					.toArray(Data[]::new);
			SegTree<Long> seg = new SegTree<>(n) {
				@Override
				Long e() {
					return 0L;
				}

				@Override
				Long op(Long a, Long b) {
					return a + b;
				}
			};
			long answer = 0L;
			for (int i = 0; i < n; i++) {
				int count = 1;
				while ((i + 1 < n) && (datas[i].a == datas[i + 1].a) && (datas[i].b == datas[i + 1].b)) {
					count++;
					i++;
				}
				int bi = datas[i].b;
				answer += count * (count + seg.prod(0, bi + 1));
				seg.set(bi, seg.get(bi) + count);
			}
			System.out.println(answer);
		}
	}

	/**
	 * 標準入力から長さnの配列を座標圧縮した結果配列を計算する
	 *
	 * @param scanner 標準入力
	 * @param n       長さ
	 * @return 標準入力から長さnの配列を座標圧縮した結果配列
	 */
	private static int[] compress(Scanner scanner, int n) {
		int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
		int[] b = Arrays.stream(a).distinct().sorted().toArray();
		Map<Integer, Integer> map = new HashMap<>();
		IntStream.range(0, b.length).forEach(i -> map.put(b[i], i));
		return IntStream.range(0, n).map(i -> map.get(a[i])).toArray();
	}

	/**
	 * aとbを格納するクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp を参考に作成
	 */
	abstract static class SegTree<S> {
		final int n, size;
		final S[] d;

		abstract S e();

		abstract S op(S a, S b);

		/**
		 * コンストラクター
		 */
		SegTree() {
			this(0);
		}

		/**
		 * コンストラクター
		 *
		 * @param n
		 */
		@SuppressWarnings({ "unchecked" })
		SegTree(int n) {
			this.n = n;
			size = bitCeil(n);
			d = (S[]) new Object[size << 1];
			Arrays.fill(d, e());
			for (int i = size - 1; i >= 1; i--) {
				update(i);
			}
		}

		/**
		 * コンストラクター
		 *
		 * @param v
		 */
		@SuppressWarnings("unchecked")
		SegTree(S[] v) {
			n = v.length;
			size = bitCeil(n);
			d = (S[]) new Object[size << 1];
			Arrays.fill(d, e());
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
			S sml = e(), smr = e();
			l += size;
			r += size;

			while (l < r) {
				if (0 != (l & 1)) {
					sml = op(sml, d[l++]);
				}
				if (0 != (r & 1)) {
					smr = op(d[--r], smr);
				}
				l >>= 1;
				r >>= 1;
			}
			return op(sml, smr);
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
			if (!f.test(e())) {
				throw new IllegalArgumentException("f.test(e()) is " + f.test(e()));
			}
			if (l == n) {
				return n;
			}
			l += size;
			S sm = e();
			do {
				while (0 == (l & 1)) {
					l >>= 1;
				}
				if (!f.test(op(sm, d[l]))) {
					while (l < size) {
						l <<= 1;
						if (f.test(op(sm, d[l]))) {
							sm = op(sm, d[l]);
							l++;
						}
					}
					return l - size;
				}
				sm = op(sm, d[l]);
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
			if (!f.test(e())) {
				throw new IllegalArgumentException("f.test(e()) is " + f.test(e()));
			}
			if (0 == r) {
				return 0;
			}
			r += size;
			S sm = e();
			do {
				r--;
				while (r > 1 && 0 != (r & 1)) {
					r >>= 1;
				}
				if (!f.test(op(d[r], sm))) {
					while (r < size) {
						r = (2 * r + 1);
						if (f.test(op(d[r], sm))) {
							sm = op(d[r], sm);
							r--;
						}
					}
					return r + 1 - size;
				}
				sm = op(d[r], sm);
			} while ((r & -r) != r);
			return 0;
		}

		private void update(int k) {
			d[k] = op(d[k << 1], d[k << 1 | 1]);
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
