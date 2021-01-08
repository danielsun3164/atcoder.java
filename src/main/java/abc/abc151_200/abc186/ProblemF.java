package abc.abc151_200.abc186;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc186/submissions/18885152 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), m = scanner.nextInt();
			int[] minH = new int[w], minW = new int[h];
			Arrays.fill(minH, h);
			Arrays.fill(minW, w);
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
				minW[x] = Math.min(minW[x], y);
				minH[y] = Math.min(minH[y], x);
			});
			long answer = IntStream.range(0, minW[0]).mapToLong(i -> minH[i]).sum();
			answer += IntStream.range(0, minH[0]).mapToLong(i -> minW[i]).sum();
			// 0〜minW[0]の間にある重複するマスを計算する
			int[] towers = IntStream.range(0, minW[0]).boxed().sorted((x, y) -> Integer.compare(minH[x], minH[y]))
					.mapToInt(i -> i).toArray();
			FenwickTree tree = new FenwickTree(w + 1);
			Arrays.stream(towers).forEach(x -> tree.add(x, 1));
			int index = 0;
			for (int i = 0; i < minH[0]; i++) {
				// i列目を計算する
				while ((index < towers.length) && (i >= minH[towers[index]])) {
					// i>=minH[x]の場合、xを重複の対象から除く
					tree.add(towers[index++], -1);
				}
				answer -= tree.sum(0, minW[i]);
			}
			System.out.println(answer);
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
