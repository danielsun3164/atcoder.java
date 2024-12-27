package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem095 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			FenwickTree[] ft = new FenwickTree[2];
			IntStream.range(0, 2).forEach(i -> ft[i] = new FenwickTree(n));
			IntStream.range(0, n).forEach(i -> {
				int c = scanner.nextInt() - 1, p = scanner.nextInt();
				ft[c].add(i, p);
			});
			int q = scanner.nextInt();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int l = scanner.nextInt() - 1, r = scanner.nextInt();
				sb.append(ft[0].sum(l, r)).append(" ").append(ft[1].sum(l, r)).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
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
		final int[] data;

		/**
		 * コンストラクター
		 */
		@SuppressWarnings("unused")
		FenwickTree() {
			this(0);
		}

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
			data = new int[n];
			Arrays.fill(data, 0);
		}

		/**
		 * インデックスpの値にxを加算する
		 *
		 * @param p 0-index
		 * @param x
		 */
		void add(int p, int x) {
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
		int sum(int l, int r) {
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
		private int sum(int r) {
			int s = 0;
			while (r > 0) {
				s += data[r - 1];
				r -= r & -r;
			}
			return s;
		}
	}
}
