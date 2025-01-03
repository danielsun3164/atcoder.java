package abc.abc201_250.abc207;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] l = new long[n], r = new long[n];
			SortedSet<Long> set = new TreeSet<>();
			IntStream.range(0, n).forEach(i -> {
				int t = scanner.nextInt();
				l[i] = scanner.nextLong() * 2L;
				r[i] = scanner.nextLong() * 2L;
				if ((1 & t) == 0) {
					r[i]--;
				}
				if (t >= 3) {
					l[i]++;
				}
				set.add(l[i]);
				set.add(r[i]);
			});
			Map<Long, Integer> map = new HashMap<>();
			int count = 1;
			for (Long key : set) {
				map.put(key, count++);
			}
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(map.get(l[i]), map.get(r[i])))
					.sorted((a, b) -> (a.r == b.r) ? Integer.compare(a.l, b.l) : Integer.compare(a.r, b.r))
					.toArray(Data[]::new);
			FenwickTree ft = new FenwickTree(set.size() + 2);
			long answer = 0L;
			for (Data data : datas) {
				answer += ft.sum(data.l, data.r + 1);
				ft.add(data.r, 1);
			}
			System.out.println(answer);
		}
	}

	/**
	 * l,rを格納するクラス
	 */
	private static class Data {
		int l, r;

		Data(int l, int r) {
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
