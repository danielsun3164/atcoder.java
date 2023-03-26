package practice.practice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * https://atcoder.github.io/ac-library/master/document_ja/lazysegtree.html を参考に作成
 *
 * TLE対応のため、以下のことを実施<br/>
 * 1．Scannerの代わりにBufferedReaderを使用<br/>
 * 2．System.out.printlnの代わりにStringBuilderを使用<br/>
 * 3．LazySegTreeの計算するメソッドに戻り値を引数として追加（新しいインスタンスを作成しない）
 */
public class ProblemK {

	/** mod対象の数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {
			String[] strings = br.readLine().split("\\s+");
			@SuppressWarnings("unused")
			int n = Integer.parseInt(strings[0]), q = Integer.parseInt(strings[1]);
			strings = br.readLine().split("\\s+");
			SData[] a = Arrays.stream(strings).map(s -> new SData(Integer.valueOf(s), 1)).toArray(SData[]::new);
			LazySegTree<SData, FData> seg = new LazySegTree<>(a) {
				@Override
				void op(SData a, SData b, SData ret) {
					long na = (a.a + b.a) % MOD;
					int nb = a.size + b.size;
					ret.a = na;
					ret.size = nb;
				}

				@Override
				SData e() {
					return new SData(0L, 0);
				}

				@Override
				void mapping(FData f, SData s, SData ret) {
					ret.a = ((s.a * f.a) + (s.size * f.b)) % MOD;
					ret.size = s.size;
				}

				@Override
				void composition(FData a, FData b, FData ret) {
					long na = (a.a * b.a) % MOD;
					long nb = ((b.b * a.a) + a.b) % MOD;
					ret.a = na;
					ret.b = nb;
				}

				@Override
				FData id() {
					return new FData(1L, 0L);
				}
			};
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < q; i++) {
				strings = br.readLine().split("\\s");
				int t = Integer.parseInt(strings[0]);
				int l = Integer.parseInt(strings[1]), r = Integer.parseInt(strings[2]);
				if (0 == t) {
					long b = Long.parseLong(strings[3]), c = Long.parseLong(strings[4]);
					seg.apply(l, r, new FData(b, c));
				} else {
					sb.append(seg.prod(l, r).a).append(System.lineSeparator());
				}
			}
			System.out.print(sb);
			System.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class SData {
		long a;
		int size;

		SData(long a, int size) {
			super();
			this.a = a;
			this.size = size;
		}
	}

	private static class FData {
		long a, b;

		FData(long a, long b) {
			super();
			this.a = a;
			this.b = b;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/lazysegtree.hpp を参考に作成
	 */
	private static abstract class LazySegTree<S, F> {
		final int n, size, log;
		final S[] d;
		final F[] lz;

		abstract void op(S a, S b, S ret);

		abstract S e();

		abstract void mapping(F f, S s, S ret);

		abstract void composition(F a, F b, F ret);

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
			// Arrays.fill使用できない
			IntStream.range(0, d.length).forEach(i -> d[i] = e());
			lz = (F[]) new Object[size];
			// Arrays.fill使用できない
			IntStream.range(0, lz.length).forEach(i -> lz[i] = id());
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
				throw new IllegalArgumentException("p is " + p);
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
					op(sml, d[l++], sml);
				}
				if ((r & 1) > 0) {
					op(d[--r], smr, smr);
				}
				l >>= 1;
				r >>= 1;
			}
			op(sml, smr, sml);
			return sml;
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
			mapping(f, d[p], d[p]);
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
		 * @return 条件を両方満たす r を(いずれか一つ)
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
				S s = e();
				op(sm, d[l], s);
				if (!g.test(s)) {
					while (l < size) {
						push(l);
						l = (2 * l);
						op(sm, d[l], s);
						if (g.test(s)) {
							op(sm, d[l], sm);
							l++;
						}
					}
					return l - size;
				}
				op(sm, d[l], sm);
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
		 * @return 条件を両方満たす l を(いずれか一つ)
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
				S s = e();
				op(d[r], sm, s);
				if (!g.test(s)) {
					while (r < size) {
						push(r);
						r = ((2 * r) + 1);
						op(d[r], sm, s);
						if (g.test(s)) {
							op(d[r], sm, sm);
							r--;
						}
					}
					return (r + 1) - size;
				}
				op(d[r], sm, sm);
			} while ((r & -r) != r);
			return 0;
		}

		private void update(int k) {
			op(d[k << 1], d[(k << 1) | 1], d[k]);
		}

		private void allApply(int k, F f) {
			mapping(f, d[k], d[k]);
			if (k < size) {
				composition(f, lz[k], lz[k]);
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
