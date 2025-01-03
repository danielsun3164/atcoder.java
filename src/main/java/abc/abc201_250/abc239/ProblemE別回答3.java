package abc.abc201_250.abc239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://blog.hamayanhamayan.com/entry/2022/02/20/123049 の実装<br/>
 * https://atcoder.jp/contests/abc239/submissions/29488895 にも参考
 */
public class ProblemE別回答3 {

	/** 辺の一覧 */
	private static List<Integer>[] edges;
	/** */
	private static int[] l, r;
	/** */
	private static int index;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] x = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] v = new int[q], k = new int[q];
			IntStream.range(0, q).forEach(i -> {
				v[i] = scanner.nextInt() - 1;
				k[i] = scanner.nextInt();
			});
			l = new int[n];
			r = new int[n];
			{
				index = 0;
				euler(0, -1);
			}
			SegTree<Data> st = new SegTree<>(n + 1, () -> new Data(-1, -1), (a, b) -> max(a, b));
			IntStream.range(0, n).forEach(i -> st.set(l[i], new Data(x[i], l[i])));
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int li = l[v[i]], ri = r[v[i]];
				Data[] buffer = new Data[k[i] - 1];
				IntStream.range(0, k[i] - 1).forEach(j -> {
					Data data = st.prod(li, ri);
					buffer[j] = data;
					st.set(data.index, st.e.get());
				});
				sb.append(st.prod(li, ri).value).append(System.lineSeparator());
				Arrays.stream(buffer).forEach(data -> st.set(data.index, data));
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * l,r を再帰的に計算する
	 *
	 * @param now  現在計算中のノード
	 * @param prev 一つ前計算したノード
	 */
	private static void euler(int now, int prev) {
		l[now] = index++;
		for (int next : edges[now]) {
			if (prev != next) {
				euler(next, now);
			}
		}
		r[now] = index;
	}

	private static Data max(Data a, Data b) {
		return (a.value > b.value) ? a : b;
	}

	/**
	 * value, indexを格納するクラス
	 */
	private static class Data {
		int value, index;

		Data(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp を参考に作成
	 */
	private static class SegTree<S> {
		final int n, size;
		final S[] d;
		final Supplier<S> e;
		final BinaryOperator<S> op;

		/**
		 * コンストラクター
		 *
		 * @param n
		 */
		@SuppressWarnings({ "unchecked" })
		SegTree(int n, Supplier<S> e, BinaryOperator<S> op) {
			this.n = n;
			this.e = e;
			this.op = op;
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
		 */
		@SuppressWarnings({ "unchecked", "unused" })
		SegTree(S[] v, Supplier<S> e, BinaryOperator<S> op) {
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
		@SuppressWarnings("unused")
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
