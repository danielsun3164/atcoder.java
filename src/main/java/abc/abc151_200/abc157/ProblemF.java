package abc.abc151_200.abc157;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	/** 誤差 */
	private static final double TOLERANCE = 1E-7d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			double[] c = new double[n];
			Point[] points = IntStream.range(0, n).mapToObj(i -> {
				Point point = new Point(scanner.nextDouble(), scanner.nextDouble());
				c[i] = scanner.nextDouble();
				return point;
			}).toArray(Point[]::new);
			if (1 == k) {
				System.out.println(0.0d);
				return;
			}
			double ok = 150000.0d, ng = 0.0d;
			while (ok - ng > TOLERANCE) {
				double med = (((ok - ng) < 1.0d) && (ng > 0.0d)) ? Math.sqrt(ok * ng) : (ok + ng) / 2.0d;
				if (ok(n, k, points, c, med)) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}

	/**
	 * 指定された時間で焼ける肉の数が必要な肉の数以上かを計算する
	 *
	 * @param n      肉の数
	 * @param k      必要な肉の数
	 * @param points 肉の座標一覧
	 * @param c      肉の焼にくさ一覧
	 * @param time   時間
	 * @return 指定された時間で焼ける肉の数が必要な肉の数以上か
	 */
	private static boolean ok(int n, int k, Point[] points, double[] c, double time) {
		List<Point> list = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> {
			double xi = points[i].x, yi = points[i].y, ri = time / c[i];
			list.add(points[i]);
			IntStream.range(i + 1, n).forEach(j -> {
				double xj = points[j].x, yj = points[j].y, rj = time / c[j];
				// https://qiita.com/tydesign/items/7cb4d189451095b4d667 に参考して交差点を計算する
				double a = 2 * (xj - xi), b = 2 * (yj - yi),
						cc = (xi + xj) * (xi - xj) + (yi + yj) * (yi - yj) + (rj + ri) * (rj - ri);
				double d = Math.abs(a * xi + b * yi + cc), e = a * a + b * b, f = e * ri * ri - d * d;
				if (f >= 0.0d) {
					double h = Math.sqrt(f);
					list.add(new Point((a * d - b * h) / e + xi, (b * d + a * h) / e + yi));
					if (f > TOLERANCE) {
						list.add(new Point((a * d + b * h) / e + xi, (b * d - a * h) / e + yi));
					}
				}
			});
		});
		for (Point point : list) {
			if (IntStream.range(0, n)
					.filter(i -> Math.hypot(point.x - points[i].x, point.y - points[i].y) * c[i] < time + TOLERANCE)
					.count() >= k) {
				return true;
			}
		}
		return false;
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Point {
		double x, y;

		Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
