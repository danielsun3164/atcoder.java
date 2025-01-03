package other.joi2007ho;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] points = IntStream.range(0, n).mapToObj(i -> new Point(scanner.nextInt(), scanner.nextInt()))
					.toArray(Point[]::new);
			// contains確認用
			Set<Point> set = Arrays.stream(points).collect(Collectors.toSet());
			// 結果の最大値
			long answer = 0L;
			Map<Long, List<Point>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				map.clear();
				for (int j = 0; j < n; j++) {
					if (i != j) {
						long distance = distance(points[i], points[j]);
						if (distance > answer) {
							Point q = new Point(points[j].x - points[j].y + points[i].y,
									points[j].y + points[j].x - points[i].x);
							Point r = new Point(points[i].x - points[j].y + points[i].y,
									points[i].y + points[j].x - points[i].x);
							if (set.contains(q) && set.contains(r)) {
								answer = distance;
							}
						}
					}
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * point1とpoint2の間の距離の平方を取得する
	 *
	 * @param point1
	 * @param point2
	 * @return point1とpoint2の間の距離の平方
	 */
	private static long distance(Point point1, Point point2) {
		return (point1.x - point2.x) * (long) (point1.x - point2.x)
				+ (point1.y - point2.y) * (long) (point1.y - point2.y);
	}

	/**
	 * x,y座標を表すクラス
	 */
	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point p = (Point) o;
				return (x == p.x) && (y == p.y);
			}
			return false;
		}
	}
}
