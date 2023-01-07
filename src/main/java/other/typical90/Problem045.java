package other.typical90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem045 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			// x座標を小さい順で並べた一覧
			Point[] xPoints = IntStream.range(0, n).mapToObj(i -> new Point(scanner.nextLong(), scanner.nextLong()))
					.sorted((a, b) -> (a.x == b.x) ? Long.compare(a.y, b.y) : Long.compare(a.x, b.x))
					.toArray(Point[]::new);
			// y座標を小さい順で並べた一覧
			Point[] yPoints = IntStream.range(0, n).mapToObj(i -> xPoints[i])
					.sorted((a, b) -> (a.y == b.y) ? Long.compare(a.x, b.x) : Long.compare(a.y, b.y))
					.toArray(Point[]::new);

			long ng = 0, ok = INF;
			while (ok > ng + 1) {
				long med = (ng + ok) >> 1;
				if ((calcGroups(xPoints, med) <= k) || (calcGroups(yPoints, med) <= k)) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}

	/**
	 * 指定されたグループ内点の間の距離の最大値で点のグループ数を計算する
	 *
	 * @param points 点の一覧
	 * @param value  グループ内点の間の距離の最大値
	 * @return グループ数
	 */
	private static int calcGroups(Point[] points, long value) {
		List<List<Point>> groups = new ArrayList<>();
		for (Point point : points) {
			boolean hasGroup = false;
			for (List<Point> group : groups) {
				if (group.stream().mapToLong(p -> (point.x - p.x) * (point.x - p.x) + (point.y - p.y) * (point.y - p.y))
						.max().getAsLong() <= value) {
					group.add(point);
					hasGroup = true;
					break;
				}
			}
			if (!hasGroup) {
				List<Point> group = new ArrayList<>();
				group.add(point);
				groups.add(group);
			}
		}
		return groups.size();
	}

	/**
	 * x座標、y座標を格納するクラス
	 */
	private static class Point {
		long x, y;

		Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
