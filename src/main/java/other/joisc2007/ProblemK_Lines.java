package other.joisc2007;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemK_Lines {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Line[] lines = IntStream.range(0, n)
					.mapToObj(i -> new Line(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()))
					.toArray(Line[]::new);
			System.out.println(IntStream.range(0, lines.length).map(i -> {
				Set<Point> set = new HashSet<>();
				int sum = IntStream.range(0, i).map(j -> {
					Point point = lines[i].itIntersect(lines[j]);
					if (null != point) {
						set.add(point);
					}
					return lines[i].sameLine(lines[j]) ? 1 : 0;
				}).sum();
				return (sum > 0) ? 0 : 1 + set.size();
			}).sum() + 1);
		}
	}

	// https://stackoverflow.com/questions/23596788/how-to-find-intersections-of-two-lines を参考に作成
	/**
	 * 点を表すクラス
	 */
	private static class Point {
		double x, y;

		Point(double x, double y) {
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

	/**
	 * 線を表すクラス
	 */
	private static class Line {
		Point a, b;

		@SuppressWarnings("unused")
		Line(Point a, Point b) {
			this.a = a;
			this.b = b;
		}

		Line(double xa, double ya, double xb, double yb) {
			this.a = new Point(xa, ya);
			this.b = new Point(xb, yb);
		}

		/**
		 * lineとの交差点を計算する
		 * 
		 * @param line
		 * @return lineとの交差点
		 */
		Point itIntersect(Line line) {
			double denominator = (a.x - b.x) * (line.a.y - line.b.y) - (a.y - b.y) * (line.a.x - line.b.x);
			if (0.0 != denominator) {
				double px = ((a.x * b.y - a.y * b.x) * (line.a.x - line.b.x)
						- (a.x - b.x) * (line.a.x * line.b.y - line.a.y * line.b.x)) / denominator;
				double py = ((a.x * b.y - a.y * b.x) * (line.a.y - line.b.y)
						- (a.y - b.y) * (line.a.x * line.b.y - line.a.y * line.b.x)) / denominator;
				return new Point(px, py);
			}
			return null;
		}

		/**
		 * lineと同じ線かどうかを判定する
		 * 
		 * https://atcoder.jp/contests/joisc2007/submissions/1229755 を参考に作成
		 * 
		 * @param line
		 * @return lineと同じ線かどうか
		 */
		boolean sameLine(Line line) {
			double p = (line.a.y * line.b.x - line.b.y * line.a.x) * (b.x - a.x)
					- (a.y * b.x - b.y * a.x) * (line.b.x - line.a.x);
			double q = (b.y - a.y) * (line.b.x - line.a.x) - (line.b.y - line.a.y) * (b.x - a.x);
			return (0.0 == p) && (0.0 == q);
		}
	}
}
