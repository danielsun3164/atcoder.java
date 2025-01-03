package other.joi2008yo;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int m = scanner.nextInt();
			int[] xm = new int[m], ym = new int[m];
			IntStream.range(0, m).forEach(i -> {
				xm[i] = scanner.nextInt();
				ym[i] = scanner.nextInt();
			});
			int[] diffXm = new int[m - 1], diffYm = new int[m - 1];
			IntStream.range(0, m - 1).forEach(i -> {
				diffXm[i] = xm[i + 1] - xm[i];
				diffYm[i] = ym[i + 1] - ym[i];
			});
			int n = scanner.nextInt();
			Set<Point> set = IntStream.range(0, n).mapToObj(i -> new Point(scanner.nextInt(), scanner.nextInt()))
					.collect(Collectors.toSet());
			for (Point point : set) {
				int nx = point.x, ny = point.y;
				boolean found = true;
				for (int i = 0; i < m - 1; i++) {
					nx += diffXm[i];
					ny += diffYm[i];
					Point p = new Point(nx, ny);
					if (!set.contains(p)) {
						found = false;
						break;
					}
				}
				if (found) {
					System.out.println((point.x - xm[0]) + " " + (point.y - ym[0]));
					break;
				}
			}
		}
	}

	/**
	 * x,yを表すクラス
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
