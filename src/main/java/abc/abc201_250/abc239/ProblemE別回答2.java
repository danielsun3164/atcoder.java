package abc.abc201_250.abc239;

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
 * https://jupiro.hatenablog.com/entry/2022/02/20/110013 の実装<br/>
 * https://atcoder.jp/contests/abc239/submissions/29487166 にも参考
 */
public class ProblemE別回答2 {

	/** 辺の一覧 */
	private static List<Integer>[] edges;
	/** */
	private static int[] in, out;
	/** */
	private static int index;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			CoordinateCompress cc = new CoordinateCompress(IntStream.range(0, n).map(i -> scanner.nextInt()).toArray());
			int[] x = cc.compressedX;
			edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] v = new int[q], k = new int[q];
			IntStream.range(0, q).forEach(i -> {
				v[i] = scanner.nextInt() - 1;
				k[i] = scanner.nextInt();
			});
			in = new int[n];
			out = new int[n];
			{
				index = 0;
				dfs(0, -1);
			}
			Data2[] vp = IntStream.range(0, n).mapToObj(i -> new Data2(x[i], in[i])).sorted(
					(a, b) -> (a.from == b.from) ? Integer.compare(b.to, a.to) : Integer.compare(b.from, a.from))
					.toArray(Data2[]::new);
			IntFenwickTree bit = new IntFenwickTree(n);
			int[] lf = new int[q], rg = new int[q];
			Arrays.fill(rg, cc.size());
			while (true) {
				boolean exit = true;
				List<Data3>[] query = new List[cc.size()];
				IntStream.range(0, cc.size()).forEach(i -> query[i] = new ArrayList<>());
				bit.reset();
				for (int i = 0; i < q; i++) {
					if (rg[i] - lf[i] > 1) {
						exit = false;
						query[(lf[i] + rg[i]) >> 1].add(new Data3(v[i], k[i], i));
					}
				}
				if (exit) {
					break;
				}

				int now = 0;
				for (int value = cc.size() - 1; value >= 0; value--) {
					while ((now < n) && vp[now].from >= value) {
						bit.add(vp[now].to, 1);
						now++;
					}
					for (Data3 data : query[value]) {
						int count = bit.sum(in[data.v], out[data.v]);
						if (data.k <= count) {
							lf[data.index] = value;
						} else {
							rg[data.index] = value;
						}
					}
				}
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> sb.append(cc.realValue(lf[i])).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}

	}

	/**
	 * in,out を再帰的に計算する
	 *
	 * @param now  現在計算中のノード
	 * @param prev 一つ前計算したノード
	 */
	private static void dfs(int now, int prev) {
		in[now] = index++;
		for (int next : edges[now]) {
			if (prev != next) {
				dfs(next, now);
			}
		}
		out[now] = index;
	}

	/**
	 * 座標圧縮するためのクラス
	 */
	private static class CoordinateCompress {
		int[] sortedX, compressedX;

		CoordinateCompress(int[] x) {
			sortedX = Arrays.stream(x).sorted().distinct().toArray();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, sortedX.length).forEach(i -> map.put(sortedX[i], i));
			compressedX = Arrays.stream(x).map(xi -> map.get(xi)).toArray();
		}

		int realValue(int x) {
			return sortedX[x];
		}

		int size() {
			return sortedX.length;
		}
	}

	/**
	 * from,toを格納するクラス
	 */
	private static class Data2 {
		int from, to;

		Data2(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	/**
	 * v,k,indexを格納するクラス
	 */
	private static class Data3 {
		int v, k, index;

		Data3(int v, int k, int index) {
			this.v = v;
			this.k = k;
			this.index = index;
		}
	}

	/**
	 * https://github.com/atcoder/ac-library/blob/master/atcoder/fenwicktree.hpp のJava実装
	 *
	 * 実行速度を重視するため、Genericsには対応しない
	 */
	private static class IntFenwickTree {
		/** 項目数 */
		final int n;
		/** データ */
		final int[] data;

		/**
		 * コンストラクター
		 *
		 * @param n 項目数
		 */
		IntFenwickTree(int n) {
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

		void reset() {
			Arrays.fill(data, 0);
		}
	}
}
