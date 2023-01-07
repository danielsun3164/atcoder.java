package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem089 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			int[] a = new int[n + 1];
			a[0] = 0;
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = scanner.nextInt());
			int[] sortedA = Arrays.stream(a).sorted().distinct().toArray();
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = Arrays.binarySearch(sortedA, a[i]));
			FenwickTree ft = new FenwickTree(sortedA.length + 2);
			ft.add(a[n], 1);
			int[] cl = new int[n + 1];
			Arrays.fill(cl, 0);
			int l = n;
			long count = 0L;
			for (int r = n; r >= 1; r--) {
				while ((l > 0) && (count <= k)) {
					l--;
					count += ft.sum(a[l]);
					ft.add(a[l], 1);
				}
				ft.add(a[r], -1);
				count -= ft.sum(a[r] + 1, sortedA.length + 2);
				cl[r] = l;
			}
			long[] dp = new long[n + 1], dp2 = new long[n + 1];
			dp[0] = dp2[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				dp[i] = (0 == cl[i]) ? dp2[i - 1] : ((dp2[i - 1] - dp2[cl[i] - 1] + MOD) % MOD);
				dp2[i] = (dp2[i - 1] + dp[i]) % MOD;
			});
			System.out.println(dp[n]);
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
