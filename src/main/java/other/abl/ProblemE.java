package other.abl;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abl/submissions/17016942 を参考に作成したソースコード
 *
 * TLE対策のため、System.out.printlnを代わりにStringBuilderを使用
 */
public class ProblemE {

	private static final long MOD = 998_244_353L;
	/** 最大桁数 */
	private static final int N = 1_000_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			// ten[i]は10のi乗 mod MOD、one[i]はi桁の1 mod MOD
			final long[] ten = new long[N], one = new long[N];
			ten[0] = 1L;
			IntStream.range(1, N).forEach(i -> ten[i] = (ten[i - 1] * 10L) % MOD);
			one[0] = 0L;
			IntStream.range(1, N).forEach(i -> one[i] = ((one[i - 1] * 10L) + 1L) % MOD);
			SData[] datas = new SData[n];
			Arrays.fill(datas, SData.ONE);
			LazySegTree<SData, Integer> seg = new LazySegTree<>(datas) {
				@Override
				SData op(SData a, SData b) {
					return new SData(a.length + b.length, ((a.value * ten[b.length]) + b.value) % MOD);
				}

				@Override
				SData e() {
					return SData.ZERO;
				}

				@Override
				SData mapping(Integer f, SData s) {
					if (0 == f) {
						return s;
					}
					return new SData(s.length, (one[s.length] * f) % MOD);
				}

				@Override
				Integer composition(Integer a, Integer b) {
					return (0 == a) ? b : a;
				}

				@Override
				Integer id() {
					return 0;
				}
			};
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int l = scanner.nextInt() - 1, r = scanner.nextInt(), d = scanner.nextInt();
				seg.apply(l, r, d);
				sb.append(seg.prod(0, n).value).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	private static class SData {
		/** 数字の桁数 */
		int length;
		/** 数字の値 */
		long value;

		static final SData ZERO = new SData(0, 0L);
		static final SData ONE = new SData(1, 1L);

		SData(int length, long value) {
			super();
			this.length = length;
			this.value = value;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/lazysegtree.hpp を参考に作成
	 */
	private static abstract class LazySegTree<S, F> {
		final int n, size, log;
		final S[] d;
		final F[] lz;

		abstract S op(S a, S b);

		abstract S e();

		abstract S mapping(F f, S s);

		abstract F composition(F a, F b);

		abstract F id();

		@SuppressWarnings({ "unchecked", "unused" })
		public LazySegTree(int n) {
			this.n = n;
			log = ceilPow2(n);
			size = 1 << log;
			d = (S[]) new Object[size << 1];
			Arrays.fill(d, e());
			lz = (F[]) new Object[size];
			Arrays.fill(lz, id());
			for (int i = size - 1; i >= 1; i--) {
				update(i);
			}
		}

		@SuppressWarnings("unchecked")
		public LazySegTree(S[] v) {
			n = v.length;
			log = ceilPow2(n);
			size = 1 << log;
			d = (S[]) new Object[size << 1];
			Arrays.fill(d, e());
			lz = (F[]) new Object[size];
			Arrays.fill(lz, id());
			System.arraycopy(v, 0, d, size, n);
			for (int i = size - 1; i >= 1; i--) {
				update(i);
			}
		}

		/**
		 * a[p] = x と設定する
		 *
		 * @param p
		 * @param x
		 */
		@SuppressWarnings("unused")
		void set(int p, S x) {
			if (!((0 <= p) && (p < n))) {
				throw new IllegalArgumentException("p is " + p);
			}
			p += size;
			pushTo(p);
			d[p] = x;
			updateFrom(p);
		}

		/**
		 * a[p] を返す
		 *
		 * @param p
		 * @return a[p]
		 */
		@SuppressWarnings("unused")
		S get(int p) {
			if (!((0 <= p) && (p < n))) {
				new IllegalArgumentException("p is " + p);
			}
			p += size;
			pushTo(p);
			return d[p];
		}

		/**
		 * op(a[l], ..., a[r - 1]) を、モノイドの性質を満たしていると仮定して計算する。l==r のときは e() を返す。
		 *
		 * @param l
		 * @param r
		 * @return op(a[l], ..., a[r - 1])
		 */
		S prod(int l, int r) {
			if (!((0 <= l) && (l <= r) && (r <= n))) {
				throw new IllegalArgumentException("l is " + l + ", r is " + r);
			}
			if (l == r) {
				return e();
			}

			l += size;
			r += size;
			for (int i = log; i >= 1; i--) {
				if (((l >> i) << i) != l) {
					push(l >> i);
				}
				if (((r >> i) << i) != r) {
					push(r >> i);
				}
			}

			S sml = e(), smr = e();
			while (l < r) {
				if ((l & 1) > 0) {
					sml = op(sml, d[l++]);
				}
				if ((r & 1) > 0) {
					smr = op(d[--r], smr);
				}
				l >>= 1;
				r >>= 1;
			}
			return op(sml, smr);
		}

		/**
		 * op(a[0], ..., a[n-1]) を計算する。n==0 のときは e() を返す。
		 *
		 * @return op(a[0], ..., a[n-1])
		 */
		@SuppressWarnings("unused")
		S allProd() {
			return d[1];
		}

		/**
		 * a[p] = f(a[p]) と設定する
		 *
		 * @param p
		 * @param f
		 */
		@SuppressWarnings("unused")
		void apply(int p, F f) {
			if (!((0 <= p) && (p < n))) {
				throw new IllegalArgumentException("p is " + p);
			}
			p += size;
			pushTo(p);
			d[p] = mapping(f, d[p]);
			updateFrom(p);
		}

		/**
		 * i = l..r-1についてa[i] = f(a[i]) と設定する
		 *
		 * @param l
		 * @param r
		 * @param f
		 */
		void apply(int l, int r, F f) {
			if (!((0 <= l) && (l <= r) && (r <= n))) {
				throw new IllegalArgumentException("l is " + l + ", r is " + r);
			}
			if (l == r) {
				return;
			}

			l += size;
			r += size;
			for (int i = log; i >= 1; i--) {
				if (((l >> i) << i) != l) {
					push(l >> i);
				}
				if (((r >> i) << i) != r) {
					push((r - 1) >> i);
				}
			}

			{
				int l2 = l, r2 = r;
				while (l2 < r2) {
					if ((l2 & 1) > 0) {
						allApply(l2++, f);
					}
					if ((r2 & 1) > 0) {
						allApply(--r2, f);
					}
					l2 >>= 1;
					r2 >>= 1;
				}
			}

			for (int i = 1; i <= log; i++) {
				if (((l >> i) << i) != l) {
					update(l >> i);
				}
				if (((r >> i) << i) != r) {
					update((r - 1) >> i);
				}
			}
		}

		/**
		 * 以下の条件を両方満たす r を(いずれか一つ)返します。<br/>
		 * r = l もしくは g(op(a[l], a[l + 1], ..., a[r - 1])) = true <br/>
		 * r = n もしくは g(op(a[l], a[l + 1], ..., a[r])) = false <br/>
		 * gが単調だとすれば、g(op(a[l], a[l + 1], ..., a[r - 1])) = true となる最大の r、と解釈することが可能です。
		 *
		 * @param l
		 * @param g
		 * @return
		 */
		@SuppressWarnings("unused")
		int maxRight(int l, Predicate<S> g) {
			if (!((0 <= l) && (l <= n))) {
				throw new IllegalArgumentException("l is " + l);
			}
			if (!g.test(e())) {
				throw new IllegalArgumentException("g.test(e()) is " + g.test(e()));
			}
			if (l == n) {
				return n;
			}
			l += size;
			pushTo(l);
			S sm = e();
			do {
				while (0 == (l & 1)) {
					l >>= 1;
				}
				if (!g.test(op(sm, d[l]))) {
					while (l < size) {
						push(l);
						l = (2 * l);
						if (g.test(op(sm, d[l]))) {
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
		 * l = r もしくは g(op(a[l], a[l + 1], ..., a[r - 1])) = true <br/>
		 * l = 0 もしくは g(op(a[l - 1], a[l], ..., a[r - 1])) = false <br/>
		 * gが単調だとすれば、g(op(a[l], a[l + 1], ..., a[r - 1])) = true となる最小の l、と解釈することが可能です。
		 *
		 * @param r
		 * @param g
		 * @return
		 */
		@SuppressWarnings("unused")
		int minLeft(int r, Predicate<S> g) {
			if (!((0 <= r) && (r <= n))) {
				throw new IllegalArgumentException("r is " + r);
			}
			if (!g.test(e())) {
				throw new IllegalArgumentException("g.test(e()) is " + g.test(e()));
			}
			if (0 == r) {
				return 0;
			}
			r += size;
			for (int i = log; i >= 1; i--) {
				push((r - 1) >> i);
			}
			S sm = e();
			do {
				r--;
				while ((r > 1) && ((r & 1) > 0)) {
					r >>= 1;
				}
				if (!g.test(op(d[r], sm))) {
					while (r < size) {
						push(r);
						r = ((2 * r) + 1);
						if (g.test(op(d[r], sm))) {
							sm = op(d[r], sm);
							r--;
						}
					}
					return (r + 1) - size;
				}
				sm = op(d[r], sm);
			} while ((r & -r) != r);
			return 0;
		}

		private void update(int k) {
			d[k] = op(d[k << 1], d[(k << 1) | 1]);
		}

		private void allApply(int k, F f) {
			d[k] = mapping(f, d[k]);
			if (k < size) {
				lz[k] = composition(f, lz[k]);
			}
		}

		private void push(int k) {
			allApply(k << 1, lz[k]);
			allApply((k << 1) | 1, lz[k]);
			lz[k] = id();
		}

		private void pushTo(int p) {
			for (int i = log; i >= 1; i--) {
				push(p >> i);
			}
		}

		private void updateFrom(int p) {
			while (p > 1) {
				p >>= 1;
				update(p);
			}
		}
	}

	/**
	 *
	 * @param n `0 <= n`
	 * @return minimum non-negative `x` s.t. `n <= 2**x`
	 */
	private static int ceilPow2(int n) {
		if (!(0 <= n)) {
			throw new IllegalArgumentException("n is " + n);
		}
		int x = 0;
		while ((1 << x) < n) {
			x++;
		}
		return x;
	}
}
