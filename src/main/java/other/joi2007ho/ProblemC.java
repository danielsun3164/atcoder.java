package other.joi2007ho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

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
							if (!map.containsKey(distance)) {
								map.put(distance, new ArrayList<>());
							}
							map.get(distance).add(points[j]);
						}
					}
				}
				@SuppressWarnings("unchecked")
				Entry<Long, List<Point>>[] entries = map.entrySet().stream()
						.sorted((a, b) -> Long.compare(b.getKey(), a.getKey())).toArray(Entry[]::new);
				for (Entry<Long, List<Point>> entry : entries) {
					if (answer > entry.getKey()) {
						break;
					}
					if (check(points[i], entry, set)) {
						answer = entry.getKey();
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
	 * ベースとなる座標とベースとなる座標との間の距離と座標の一覧で正方形が存在するかどうかをチェックする
	 *
	 * @param point ベースとなる座標
	 * @param entry ベースとなる座標との間の距離と座標の一覧
	 * @param set   座標一覧のセット(contains用)
	 * @return 正方形が存在するかどうか
	 */
	private static boolean check(Point point, Entry<Long, List<Point>> entry, Set<Point> set) {
		if (entry.getValue().size() >= 2) {
			for (Point point1 : entry.getValue()) {
				for (Point point2 : entry.getValue()) {
					if ((entry.getKey() * 2L == distance(point1, point2))
							&& set.contains(getOtherPoint(point, point1, point2))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * pointとpoint1とpoint2で正方形を組合せとき、残りの頂点の座標を計算する
	 *
	 * @param point
	 * @param point1
	 * @param point2
	 * @return 残りの頂点の座標
	 */
	private static Point getOtherPoint(Point point, Point point1, Point point2) {
		return new Point(point1.x + point2.x - point.x, point1.y + point2.y - point.y);
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
