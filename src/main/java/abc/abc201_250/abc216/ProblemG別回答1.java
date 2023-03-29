package abc.abc201_250.abc216;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc216/editorial/2569 の解説のFenwick Treeとキューの実装
 */
public class ProblemG別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] l = new int[m], r = new int[m], x = new int[m];
			IntStream.range(0, m).forEach(i -> {
				l[i] = scanner.nextInt() - 1;
				r[i] = scanner.nextInt();
				x[i] = scanner.nextInt();
			});
			Integer[] indexes = IntStream.range(0, m).boxed().sorted((a, b) -> Integer.compare(r[a], r[b]))
					.toArray(Integer[]::new);
			int[] a = new int[n];
			Arrays.fill(a, 0);
			FenwickTree ft = new FenwickTree(n);
			Deque<Integer> que = new ArrayDeque<>();
			int q = 0;
			for (int i : indexes) {
				for (; q < r[i]; q++) {
					que.add(q);
				}
				int ones = x[i] - ft.sum(l[i], r[i]);
				IntStream.range(0, ones).forEach(j -> {
					int p = que.pollLast();
					a[p] = 1;
					ft.add(p, 1);
				});
			}
			System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
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
