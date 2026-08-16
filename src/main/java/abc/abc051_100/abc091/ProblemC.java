package abc.abc051_100.abc091;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] blues = new Point[n], reds = new Point[n];
			IntStream.range(0, n).forEach(i -> reds[i] = new Point(scanner.nextInt(), scanner.nextInt()));
			IntStream.range(0, n).forEach(i -> blues[i] = new Point(scanner.nextInt(), scanner.nextInt()));
			Arrays.sort(blues, (a, b) -> a.x - b.x);
			System.out.println(IntStream.range(0, n).map(i -> {
				Optional<Point> first = Arrays.stream(reds)
						.filter(point -> (!point.visited) && (point.x < blues[i].x) && (point.y < blues[i].y))
						.sorted((a, b) -> b.y - a.y).findFirst();
				if (first.isPresent()) {
					first.get().visited = true;
					return 1;
				} else {
					return 0;
				}
			}).sum());
		}
	}

	/**
	 * 点を表すクラス
	 */
	private static class Point {
		/** X座標 */
		int x;
		/** Y座標 */
		int y;
		/** すでにペアリングしているかどうか */
		boolean visited = false;

		/**
		 * コンストラクタ
		 *
		 * @param x
		 * @param y
		 */
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
