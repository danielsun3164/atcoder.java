package other.typical90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem041 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] points = IntStream.range(0, n).mapToObj(i -> new Point(scanner.nextLong(), scanner.nextLong()))
					.sorted((a, b) -> (a.x == b.x) ? Long.compare(a.y, b.y) : Long.compare(a.x, b.x))
					.toArray(Point[]::new);
			List<Point> g1 = new ArrayList<>(), g2 = new ArrayList<>(), totsuhou = new ArrayList<>();
			g1.add(points[0]);
			g2.add(points[0]);
			g1.add(points[1]);
			g2.add(points[1]);
			for (int i = 2; i < n; i++) {
				while ((g1.size() >= 2) && (crs(g1.get(g1.size() - 1), g1.get(g1.size() - 2), points[i]) <= 0)) {
					g1.remove(g1.size() - 1);
				}
				while ((g2.size() >= 2) && (crs(g2.get(g2.size() - 1), g2.get(g2.size() - 2), points[i]) >= 0)) {
					g2.remove(g2.size() - 1);
				}
				g1.add(points[i]);
				g2.add(points[i]);
			}
			totsuhou.addAll(g1);
			for (int i = g2.size() - 2; i >= 1; i--) {
				totsuhou.add(g2.get(i));
			}
			int m = totsuhou.size();
			long edgePoint = m + IntStream.range(0, m).mapToLong(i -> {
				long ax = totsuhou.get(i).x, ay = totsuhou.get(i).y;
				long bx = totsuhou.get((i + 1) % m).x, by = totsuhou.get((i + 1) % m).y;
				return gcd(Math.abs(bx - ax), Math.abs(by - ay)) - 1L;
			}).sum();
			long area = Math.abs(IntStream.range(0, m).mapToLong(i -> {
				long ax = totsuhou.get(i).x, ay = totsuhou.get(i).y;
				long bx = totsuhou.get((i + 1) % m).x, by = totsuhou.get((i + 1) % m).y;
				return (bx - ax) * (by + ay);
			}).sum());
			System.out.println((area + edgePoint) / 2L + 1L - n);
		}
	}

	/**
	 * a-b と c-a の外積を求める
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return a-b と c-a の外積
	 */
	private static long crs(Point a, Point b, Point c) {
		return (a.x - b.x) * (c.y - a.y) - (a.y - b.y) * (c.x - a.x);
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
	}

	/**
	 * 座標を表すクラス
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
