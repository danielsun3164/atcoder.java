package abc.abc089;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), d = scanner.nextInt();
			Map<Integer, Point> map = new HashMap<>();
			IntStream.range(0, h)
					.forEach(i -> IntStream.range(0, w).forEach(j -> map.put(scanner.nextInt(), new Point(i, j))));
			// すべての結果を計算
			int[] result = new int[h * w + 1];
			IntStream.rangeClosed(0, d).forEach(i -> result[i] = 0);
			IntStream.rangeClosed(d + 1, h * w).forEach(i -> {
				Point now = map.get(i);
				Point prev = map.get(i - d);
				result[i] = result[i - d] + Math.abs(now.x - prev.x) + Math.abs(now.y - prev.y);
			});
			int q = scanner.nextInt();
			IntStream.range(0, q).forEach(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt();
				System.out.println(result[r] - result[l]);
			});
		}
	}

	/**
	 * 座標データを格納するクラス
	 */
	static class Point {
		/** X座標 */
		final int x;
		/** Y座標 */
		final int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
