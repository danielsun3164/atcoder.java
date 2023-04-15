package abc.abc201_250.abc218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc218/editorial/2632 の実装<br/>
 * BITの実装は https://qiita.com/drken/items/1b7e6e459c24a83bb7fd を参考
 */
public class ProblemG別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			// aの値を圧縮する
			int[] sortedA = Arrays.stream(a).sorted().distinct().toArray();
			int n2 = sortedA.length;
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n2).forEach(i -> map.put(sortedA[i], i));
			boolean[] used = new boolean[n];
			Arrays.fill(used, false);
			used[0] = true;
			BinaryTrie bit = new BinaryTrie(n2);
			bit.add(map.get(a[0]), 1);
			System.out.println(calc(n, a, edges, used, sortedA, map, bit, 1, 0, true));
		}
	}

	/**
	 * 現在の頂点の処理結果を求める
	 *
	 * @param n       頂点の数
	 * @param a       Aの値の配列
	 * @param edges   辺の一覧
	 * @param used    頂点が使われたかどうかの配列
	 * @param sortedA Aをソートした配列
	 * @param map     Aの値をindexへ変換するためのマップ
	 * @param bit     Binary Trieの実装
	 * @param count   処理済みの頂点
	 * @param now     現在処理中の頂点
	 * @param max     最大値を計算するかどうか（falseのとき最小値を計算する）
	 * @return 現在の頂点の処理結果
	 */
	private static int calc(int n, int[] a, List<Integer>[] edges, boolean[] used, int[] sortedA,
			Map<Integer, Integer> map, BinaryTrie bit, int count, int now, boolean max) {
		if (edges[now].stream().filter(next -> !used[next]).count() > 0) {
			int result = max ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			for (int next : edges[now]) {
				if (!used[next]) {
					used[next] = true;
					bit.add(map.get(a[next]), 1);
					int nextResult = calc(n, a, edges, used, sortedA, map, bit, count + 1, next, !max);
					result = max ? Math.max(result, nextResult) : Math.min(result, nextResult);
					bit.add(map.get(a[next]), -1);
					used[next] = false;
				}
			}
			return result;
		}
		return (1 == (1 & count)) ? sortedA[bit.get(count >> 1)]
				: ((sortedA[bit.get(count >> 1)] + sortedA[bit.get((count - 1) >> 1)]) >> 1);
	}

	/**
	 * n以上最小の2^xの数字を計算する
	 *
	 * @param n
	 * @return n以上最小の2^xの数字
	 */
	static int bitCeil(int n) {
		if (!(0 <= n)) {
			throw new IllegalArgumentException("n is " + n);
		}
		int x = 1;
		while (x < n) {
			x <<= 1;
		}
		return x;
	}

	/**
	 * BinaryTrieの実装
	 *
	 * https://qiita.com/drken/items/1b7e6e459c24a83bb7fd を参考に作成
	 */
	private static class BinaryTrie extends FenwickTree {
		BinaryTrie(int n) {
			super(n);
		}

		/**
		 * 0-indexのk番目の要素値を取得する
		 *
		 * @param k
		 * @return 0-indexのk番目の要素値
		 */
		int get(long k) {
			k++;
			int res = 0, m = bitCeil(n);
			for (int i = m >> 1; i > 0; i >>= 1) {
				if ((res + i < n) && (data[res + i - 1] < k)) {
					k -= data[res + i - 1];
					res += i;
				}
			}
			return res;
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
