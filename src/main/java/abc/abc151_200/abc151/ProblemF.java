package abc.abc151_200.abc151;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc151/submissions/9492168 にも参考
 */
public class ProblemF {

	/** 誤差 */
	private static final double TOLERANCE = 1E-7d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] points = IntStream.range(0, n).mapToObj(i -> new Point(scanner.nextInt(), scanner.nextInt()))
					.toArray(Point[]::new);
			double left = 0.0d, right = 1500.0d;
			while (right - left > TOLERANCE) {
				double med = (((right - left) < 1.0d) && (left > 0.0d)) ? Math.sqrt(left * right)
						: (left + right) / 2.0d;
				if (ok(points, med)) {
					right = med;
				} else {
					left = med;
				}
			}
			System.out.println(right);
		}
	}

	/**
	 * N個の点が半径rの円に入るかどうかを計算する
	 *
	 * @param points N個の点の配列
	 * @param r      半径
	 * @return N個の点が半径rの円に入るかどうか
	 */
	private static boolean ok(Point[] points, double r) {
		List<Point> list = new ArrayList<>();
		// N個の半径Rの円を列挙し、2つの円の交点を全列挙する
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double dist = Math.hypot(points[i].x - points[j].x, points[i].y - points[j].y);
				if (Math.abs(dist - 2 * r) < TOLERANCE) {
					list.add(new Point((points[i].x + points[j].x) / 2.0d, (points[i].y + points[j].y) / 2.0d));
				} else if (dist < 2 * r) {
					double h = Math.sqrt(r * r - dist * dist / 4.0d);
					double mx = (points[i].x + points[j].x) / 2.0d, my = (points[i].y + points[j].y) / 2.0d;
					double[] vec = pv(h, points[i].y - points[j].y, points[j].x - points[i].x);
					list.add(new Point(mx + vec[0], my + vec[1]));
					list.add(new Point(mx - vec[0], my - vec[1]));
				}
			}
		}
		// それぞれの交点に対し、N個の点どれからも距離がR以下かを判定する。
		main: for (Point point : list) {
			for (Point heart : points) {
				double dist = Math.hypot(point.x - heart.x, point.y - heart.y);
				if (dist - r > TOLERANCE) {
					continue main;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * @param len
	 * @param x
	 * @param y
	 * @return pv
	 */
	private static double[] pv(double len, double x, double y) {
		double plen = Math.hypot(x, y);
		return new double[] { x * len / plen, y * len / plen };
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Point {
		double x, y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
