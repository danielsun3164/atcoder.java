package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem017 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] v1 = new int[n + 1], v2 = new int[n + 1], v3 = new int[n + 1];
			Arrays.fill(v1, 0);
			Arrays.fill(v2, 0);
			Arrays.fill(v3, 0);
			Line[] lines = IntStream.range(0, m).mapToObj(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt();
				v1[r]++;
				v2[l - 1]++;
				v3[l]++;
				v3[r]++;
				return new Line(l, r);
			}).sorted((a, b) -> (a.r == b.r) ? Integer.compare(a.l, b.l) : Integer.compare(a.r, b.r))
					.toArray(Line[]::new);

			long answer1 = IntStream.rangeClosed(1, n).mapToLong(i -> {
				v1[i] += v1[i - 1];
				return v1[i] * (long) v2[i];
			}).sum();

			long answer2 = IntStream.rangeClosed(1, n).mapToLong(i -> (v3[i] * (v3[i] - 1L)) / 2L).sum();

			FenwickTree bit = new FenwickTree(n + 2);
			long answer3 = Arrays.stream(lines).mapToLong(line -> {
				long result = bit.sum(line.l, line.r);
				bit.add(line.l - 1, 1L);
				return result;
			}).sum();
			System.out.println(((m * (m - 1L)) / 2L) - answer1 - answer2 - answer3);
		}
	}

	/**
	 * 線を表すクラス
	 */
	private static class Line {
		int l, r;

		Line(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/fenwicktree.hpp をもとに作成
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
