package abc.abc201_250.abc221;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = Arrays.stream(a).sorted().distinct().toArray();
			int m = b.length;
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, m).forEach(i -> map.put(b[i], i));
			int[] c = IntStream.range(0, n).map(i -> map.get(a[i])).toArray();
			FenwickTree tree = new FenwickTree(m);
			long[] p2 = new long[n + 1], invP2 = new long[n + 1];
			p2[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> p2[i] = p2[i - 1] * 2L % MOD);
			invP2[n] = powMod(p2[n], MOD - 2);
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invP2[i] = invP2[i + 1] * 2L % MOD);
			long answer = 0L;
			for (int i = 0; i < n; i++) {
				answer = (answer + tree.sum(c[i] + 1) % MOD * p2[i] % MOD) % MOD;
				tree.add(c[i], invP2[i + 1]);
			}
			System.out.println(answer);
		}
	}

	/**
	 * n^m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = (result * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return result;
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
				data[p - 1] = (data[p - 1] + x) % MOD;
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
		long sum(int l, int r) {
			if (!((0 <= l) && (l <= r) && (r <= n))) {
				throw new IllegalArgumentException("l is " + l + ", r is " + r);
			}
			return (sum(r) - sum(l) + MOD) % MOD;
		}

		/**
		 * インデックスがrより小さいのdataの合計値を計算する
		 *
		 * @param r 0-index
		 * @return インデックスがrより小さいのdataの合計値
		 */
		private long sum(int r) {
			long s = 0L;
			while (r > 0) {
				s = (s + data[r - 1]) % MOD;
				r -= r & -r;
			}
			return s;
		}
	}
}
