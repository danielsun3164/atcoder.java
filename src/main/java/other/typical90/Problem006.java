package other.typical90;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Problem006 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			// 各文字がsでの出現場所を保存するマップ
			Map<Character, NavigableSet<Integer>> map = new HashMap<>();
			SegTree<Character> st = new SegTree<>(n) {
				@Override
				Character e() {
					return '{';
				}

				@Override
				Character op(Character a, Character b) {
					return (a.compareTo(b) < 0) ? a : b;
				}
			};
			IntStream.range(0, n).forEach(i -> {
				add(map, s[i], i);
				st.set(i, s[i]);
			});
			StringBuilder sb = new StringBuilder();
			int prev = -1;
			for (int i = 1; i <= k; i++) {
				Character c = st.prod(prev + 1, (n - k) + i);
				sb.append(c);
				prev = map.get(c).ceiling(prev + 1);
				st.set(prev, '{');
				map.get(c).remove(prev);
				if (map.get(c).isEmpty()) {
					map.remove(c);
				}
			}
			System.out.println(sb.toString());
		}
	}

	/**
	 * マップに文字cの出現場所iを追加
	 *
	 * @param map マップ
	 * @param c   文字
	 * @param i   出現場所
	 */
	private static void add(Map<Character, NavigableSet<Integer>> map, char c, int i) {
		if (!map.containsKey(c)) {
			map.put(c, new TreeSet<>());
		}
		map.get(c).add(i);
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp を参考に作成
	 */
	private static abstract class SegTree<S> {
		final int n, size;
		final S[] d;

		abstract S e();

		abstract S op(S a, S b);

		/**
		 * コンストラクター
		 */
		@SuppressWarnings("unused")
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
		@SuppressWarnings({ "unchecked", "unused" })
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
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
