package abc.abc201_250.abc233;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc233/editorial/3168 の実装<br/>
 * https://atcoder.jp/contests/abc233/submissions/28096318 にも参考
 */
public class ProblemEx {

	/** 最大値 */
	private static final int INF = 200_002;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] a = IntStream.range(0, n).mapToObj(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt();
				return new Point(x - y, x + y);
			}).sorted((x, y) -> (x.x == y.x) ? Integer.compare(x.y, y.y) : Integer.compare(x.x, y.x))
					.toArray(Point[]::new);
			int q = scanner.nextInt();
			Point[] b = new Point[q];
			int[] k = new int[q];
			IntStream.range(0, q).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt();
				b[i] = new Point(x - y, x + y);
				k[i] = scanner.nextInt();
			});
			int[] ok = new int[q], ng = new int[q], mid = new int[q];
			Arrays.fill(ok, INF);
			Arrays.fill(ng, -1);
			while (true) {
				boolean end = true;
				for (int i = 0; i < q; i++) {
					if (ok[i] > ng[i] + 1) {
						end = false;
					}
					mid[i] = (ok[i] + ng[i]) / 2;
				}
				if (end) {
					break;
				}
				Data[] c = new Data[q << 1];
				IntStream.range(0, q).forEach(i -> {
					c[i << 1] = new Data(i, new Point(b[i].x - mid[i] - 1, b[i].y), mid[i], -1);
					c[i << 1 | 1] = new Data(i, new Point(b[i].x + mid[i], b[i].y), mid[i], 1);
				});
				Arrays.sort(c, (c1, c2) -> Integer.compare(c1.point.x, c2.point.x));
				int[] count = new int[q];
				Arrays.fill(count, 0);
				IntFenwickTree seg = new IntFenwickTree(INF + 1);
				int cPos = 0, cs = c.length;
				for (int aPos = 0; aPos <= n; aPos++) {
					while ((cPos < cs) && ((n == aPos) || c[cPos].point.x < a[aPos].x)) {
						int value = seg.sum(Math.max(0, c[cPos].point.y - c[cPos].mid),
								Math.min(INF, c[cPos].point.y + c[cPos].mid) + 1);
						count[c[cPos].num] += value * c[cPos].kei;
						cPos++;
					}
					if (aPos < n) {
						seg.add(a[aPos].y, 1);
					}
				}
				IntStream.range(0, q).forEach(i -> {
					if (count[i] >= k[i]) {
						ok[i] = mid[i];
					} else {
						ng[i] = mid[i];
					}
				});
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(ok).forEach(oki -> sb.append(oki).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * num, mid, kei, pointを格納するクラス
	 */
	private static class Data {
		int num, mid, kei;
		Point point;

		Data(int num, Point point, int mid, int kei) {
			super();
			this.num = num;
			this.mid = mid;
			this.kei = kei;
			this.point = point;
		}

		@Override
		public String toString() {
			return num + ",{" + point.x + "," + point.y + "}," + mid + "," + kei;
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
	}
}
