package abc.abc185;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			FenwickTree ft = new FenwickTree(n);
			IntStream.range(0, n).forEach(i -> ft.add(i, scanner.nextInt()));
			IntStream.range(0, q).forEach(i -> {
				int t = scanner.nextInt(), x = scanner.nextInt() - 1, y = scanner.nextInt();
				if (1 == t) {
					ft.add(x, y);
				} else {
					System.out.println(ft.sum(x, y));
				}
			});
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/fenwicktree.hpp をもとに作成
	 */
	private static class FenwickTree {
		/** 項目数 */
		final int n;
		/** データ */
		final int[] data;

		/**
		 * コンストラクター
		 * 
		 * @param n 項目数
		 */
		FenwickTree(int n) {
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
				data[p - 1] ^= x;
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
			return sum(r) ^ sum(l);
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
				s ^= data[r - 1];
				r -= r & -r;
			}
			return s;
		}
	}
}
