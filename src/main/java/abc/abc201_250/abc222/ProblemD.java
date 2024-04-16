package abc.abc201_250.abc222;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray(),
					b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int bMax = Arrays.stream(b).max().getAsInt();
			FenwickTree prev = new FenwickTree(bMax + 1);
			prev.add(0, 1L);
			for (int i = 0; i < n; i++) {
				FenwickTree now = new FenwickTree(bMax + 1);
				for (int j = a[i]; j <= b[i]; j++) {
					now.add(j, prev.sum(0, j + 1) % MOD);
				}
				prev = now;
			}
			System.out.println(prev.sum(0, bMax + 1) % MOD);
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/fenwicktree.hpp のJava実装
	 *
	 * 実行速度を重視するため、Genericsには対応しない
	 */
	private static class FenwickTree {
		/** 項目数 */
		final int n;
		/** データ */
		final long[] data;

		/**
		 * コンストラクター
		 *
		 * @param n 項目数
		 */
		FenwickTree(int n) {
			if (!(0 <= n)) {
				throw new IllegalArgumentException("n is " + n);
			}
			this.n = n;
			data = new long[n];
			Arrays.fill(data, 0L);
		}

		/**
		 * インデックスpの値にxを加算する
		 *
		 * @param p 0-index
		 * @param x
		 */
		void add(int p, long x) {
			if (!((0 <= p) && (p < n))) {
				throw new IllegalArgumentException("p is " + p);
			}
			p++;
			while (p <= n) {
				data[p - 1] += x;
				p += p & -p;
			}
		}

		/**
		 * dataの[l,r)の範囲の合計値を計算する
		 *
		 * @param l 0-index
		 * @param r 0-index
		 * @return dataの[l,r)の範囲の合計値
		 */
		long sum(int l, int r) {
			if (!((0 <= l) && (l <= r) && (r <= n))) {
				throw new IllegalArgumentException("l is " + l + ", r is " + r);
			}
			return sum(r) - sum(l);
		}

		/**
		 * インデックスがrより小さいのdataの合計値を計算する
		 *
		 * @param r 0-index
		 * @return インデックスがrより小さいのdataの合計値
		 */
		private long sum(int r) {
			long s = 0;
			while (r > 0) {
				s += data[r - 1];
				r -= r & -r;
			}
			return s;
		}
	}
}
