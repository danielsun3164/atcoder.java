package abc.abc101_150.abc136;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc135/submissions/6588731 にも参考
 */
public class ProblemF {

	private static final long MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			Point[] points = new Point[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
				points[i] = new Point(x[i], y[i]);
			});
			Arrays.sort(x);
			Arrays.sort(y);
			IntStream.range(0, n).forEach(i -> {
				points[i].x = Arrays.binarySearch(x, points[i].x);
				points[i].y = Arrays.binarySearch(y, points[i].y);
			});
			// num[i]はそれぞれiより左上、右上、左下、右下にある点の数
			int[][] num = new int[n][4];
			// p2[i]は2^i mod MOD
			long[] p2 = new long[n + 1];
			p2[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> p2[i] = p2[i - 1] * 2L % MOD);
			{
				FenwickTree ft = new FenwickTree(n);
				Arrays.sort(points, (a, b) -> Integer.compare(a.x, b.x));
				IntStream.range(0, n).forEach(i -> {
					num[i][0] = ft.sum(points[i].y);
					num[i][1] = i - ft.sum(points[i].y + 1);
					ft.add(points[i].y, 1);
				});
			}
			{
				FenwickTree ft = new FenwickTree(n);
				Arrays.sort(points, (a, b) -> Integer.compare(b.x, a.x));
				IntStream.range(0, n).forEach(i -> {
					num[n - 1 - i][2] = ft.sum(points[i].y);
					num[n - 1 - i][3] = i - ft.sum(points[i].y + 1);
					ft.add(points[i].y, 1);
				});
			}
			long answer = 0L;
			for (int i = 0; i < n; i++) {
				long a = (p2[num[i][0]] + p2[num[i][3]] - 1L) % MOD;
				long b = (p2[num[i][1]] + p2[num[i][2]] - 1L) % MOD;
				answer = (answer + ((p2[n] - a * b) % MOD + MOD) % MOD) % MOD;
			}
			System.out.println(answer);
		}
	}

	/**
	 * x,yを表すクラス
	 */
	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
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
		@SuppressWarnings("unused")
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
