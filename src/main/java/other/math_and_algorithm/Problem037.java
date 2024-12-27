package other.math_and_algorithm;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class Problem037 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x1 = scanner.nextLong(), y1 = scanner.nextLong(), x2 = scanner.nextLong(), y2 = scanner.nextLong(),
					x3 = scanner.nextLong(), y3 = scanner.nextLong(), x4 = scanner.nextLong(), y4 = scanner.nextLong();
			long answer1 = cross(x2 - x1, y2 - y1, x3 - x1, y3 - y1),
					answer2 = cross(x2 - x1, y2 - y1, x4 - x1, y4 - y1),
					answer3 = cross(x4 - x3, y4 - y3, x1 - x3, y1 - y3),
					answer4 = cross(x4 - x3, y4 - y3, x2 - x3, y2 - y3);
			if ((0L == answer1) && (0L == answer2) && (0L == answer3) && (0L == answer4)) {
				Point a = new Point(x1, y1), b = new Point(x2, y2), c = new Point(x3, y3), d = new Point(x4, y4);
				Point minAb = min(a, b), maxAb = max(a, b), minCd = min(c, d), maxCd = max(c, d);
				System.out.println((compare(max(minAb, minCd), min(maxAb, maxCd)) <= 0) ? "Yes" : "No");
				return;
			}
			boolean isAb = ((answer1 >= 0L) && (answer2 <= 0L)) || ((answer1 <= 0L) && (answer2 >= 0L)),
					isCd = ((answer3 >= 0L) && (answer4 <= 0L)) || ((answer3 <= 0L) && (answer4 >= 0L));
			System.out.println((isAb && isCd) ? "Yes" : "No");
		}
	}

	/**
	 * cross(a,b)を計算する
	 *
	 * @param ax aのx差分
	 * @param ay aのy差分
	 * @param bx bのx差分
	 * @param by bのy差分
	 * @return cross(a,b)
	 */
	private static long cross(long ax, long ay, long bx, long by) {
		return ax * by - ay * bx;
	}

	private static Point min(Point a, Point b) {
		return (compare(a, b) < 0) ? a : b;
	}

	private static Point max(Point a, Point b) {
		return (compare(a, b) < 0) ? b : a;
	}

	private static int compare(Point a, Point b) {
		return (a.x == b.x) ? Long.compare(a.y, b.y) : Long.compare(a.x, b.x);
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Point {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
