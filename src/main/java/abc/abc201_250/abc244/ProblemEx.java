package abc.abc201_250.abc244;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc244/editorial/3602 の実装<br/>
 * https://atcoder.jp/contests/abc244/submissions/30254721 にも参考
 */
public class ProblemEx {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;
	/** 黄金比 */
	private static final double INV_PHI = (Math.sqrt(5.0d) - 1) / 2.0d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			List<ConvexHull> s = new ArrayList<>();
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= q; i++) {
				long x = scanner.nextLong(), y = scanner.nextLong(), a = scanner.nextLong(), b = scanner.nextLong();
				s.add(new ConvexHull(new Point(x, y)));
				for (int j = 1; 0 == (i & j); j <<= 1) {
					s.set(s.size() - 2, new ConvexHull(s.get(s.size() - 2), s.get(s.size() - 1)));
					s.remove(s.size() - 1);
				}
				long answer = -INF;
				for (ConvexHull si : s) {
					answer = Math.max(answer, si.get(a, b));
				}
				sb.append(answer).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 外積を計算する
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return 外積。1：A → B → C は反時計回り、−1：A → B → C は時計回り
	 */
	private static long ccw(Point a, Point b, Point c) {
		long cross = (b.x - a.x) * (c.y - b.y) - (b.y - a.y) * (c.x - b.x);
		return (0L == cross) ? 0L : ((cross > 0) ? 1L : -1L);
	}

	/**
	 * 与えられた点集合の「凸包」を保持し、その凸包上で A*x + B*y の最大値を高速に求めるクラス
	 */
	private static class ConvexHull {
		/** lower → 下側の凸包、upper → 上側の凸包 */
		List<Point> lower = new ArrayList<>(), upper = new ArrayList<>();

		ConvexHull(Point p) {
			lower.add(p);
			upper.add(p);
		}

		ConvexHull(ConvexHull a, ConvexHull b) {
			List<Point> list = new ArrayList<>();
			merge(a.lower, b.lower, list);
			for (Point p : list) {
				while ((lower.size() >= 2) && ccw(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) <= 0L) {
					lower.remove(lower.size() - 1);
				}
				lower.add(p);
			}
			list.clear();
			merge(a.upper, b.upper, list);
			for (Point p : list) {
				while ((upper.size() >= 2) && ccw(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) >= 0L) {
					upper.remove(upper.size() - 1);
				}
				upper.add(p);
			}
		}

		/**
		 * ソート済みのaとbの配列をlistへマージする
		 *
		 * @param a
		 * @param b
		 * @param list
		 */
		private void merge(List<Point> a, List<Point> b, List<Point> list) {
			int aIndex = 0, bIndex = 0;
			while ((aIndex < a.size()) && (bIndex < b.size())) {
				if (a.get(aIndex).compareTo(b.get(bIndex)) < 0) {
					list.add(a.get(aIndex++));
				} else {
					list.add(b.get(bIndex++));
				}
			}
			while (aIndex < a.size()) {
				list.add(a.get(aIndex++));
			}
			while (bIndex < b.size()) {
				list.add(b.get(bIndex++));
			}
		}

		/**
		 * 黄金分割探索でa*x+b*yの最大値を検索する
		 *
		 * @param a
		 * @param b
		 * @return a*x+b*yの最大値
		 */
		long get(long a, long b) {
			List<Point> s = (b < 0) ? lower : upper;
			int l = 0, r = s.size() - 1, r2 = (int) Math.round(r * INV_PHI);
			long fr2 = f(a, b, s.get(r2));
			while (Math.abs(l - r) >= 6) {
				int l2 = r + (int) Math.round((l - r) * INV_PHI);
				long fl2 = f(a, b, s.get(l2));
				if (fl2 < fr2) {
					l = r;
					r = l2;
				} else {
					r = r2;
					r2 = l2;
					fr2 = fl2;
				}
			}
			long answer = -INF;
			if (l > r) {
				int tmp = r;
				r = l;
				l = tmp;
			}
			for (int i = l; i <= r; i++) {
				answer = Math.max(answer, f(a, b, s.get(i)));
			}
			return answer;
		}

		/**
		 * a*x+b*yを計算する
		 *
		 * @param a
		 * @param b
		 * @param p x,yを格納するクラス
		 * @return a*x+b*y
		 */
		private long f(long a, long b, Point p) {
			return a * p.x + b * p.y;
		}
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Point implements Comparable<Point> {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return (x == o.x) ? Long.compare(y, o.y) : Long.compare(x, o.x);
		}
	}
}
