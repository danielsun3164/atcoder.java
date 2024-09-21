package other.math_and_algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem034別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] points = IntStream.range(0, n).mapToObj(i -> new Point(scanner.nextInt(), scanner.nextInt()))
					.sorted((a, b) -> (a.x == b.x) ? Integer.compare(a.y, b.y) : Integer.compare(a.x, b.x))
					.toArray(Point[]::new);
			System.out.println(closestPair(points, 0, n));
		}
	}

	/**
	 * 配列の[l,r)の範囲の2点間の最短距離を計算する
	 *
	 * @param points 配列
	 * @param l
	 * @param r
	 * @return 配列の[l,r)の範囲の2点間の最短距離
	 */
	private static double closestPair(Point[] points, int l, int r) {
		int n = r - l;
		if (n <= 1) {
			return Double.MAX_VALUE;
		}
		int m = l + n / 2;
		double x = points[m].x, d = Math.min(closestPair(points, l, m), closestPair(points, m, r));
		inplaceMerge(points, l, m, r, (a, b) -> Integer.compare(a.y, b.y));

		List<Point> list = new ArrayList<>();
		for (int i = l; i < r; i++) {
			if (Math.abs(points[i].x - x) < d) {
				for (int j = list.size() - 1; j >= 0; j--) {
					double dx = points[i].x - list.get(j).x, dy = points[i].y - list.get(j).y;
					if (dy < d) {
						d = Math.min(d, Math.hypot(dx, dy));
					}
				}
				list.add(points[i]);
			}
		}
		return d;
	}

	/**
	 * ソート対象配列の[l,m)と[m,r)の範囲をマージする
	 *
	 * @param points     ソート対象配列
	 * @param l
	 * @param m
	 * @param r
	 * @param comparator 比較方法
	 */
	private static void inplaceMerge(Point[] points, int l, int m, int r, Comparator<Point> comparator) {
		Point[] temp = new Point[r - l];
		System.arraycopy(points, l, temp, 0, r - l);
		int index1 = 0, index2 = m - l;
		for (int i = l; i < r; i++) {
			if (index1 == m - l) {
				points[i] = temp[index2++];
			} else if ((index2 == r - l) || (comparator.compare(temp[index1], temp[index2]) < 0)) {
				points[i] = temp[index1++];
			} else {
				points[i] = temp[index2++];
			}
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
}
