package other.typical90;

import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Problem036 {

	/** X座標係数の配列 */
	private static final int[] XS = { 1, 1 };
	/** Y座標係数の配列 */
	private static final int[] YS = { 1, -1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			NavigableMap<Long, Point>[] maps = new NavigableMap[XS.length];
			IntStream.range(0, XS.length).forEach(i -> maps[i] = new TreeMap<>());
			Point[] points = IntStream.range(0, n).mapToObj(i -> {
				long x = scanner.nextInt(), y = scanner.nextLong();
				Point point = new Point(x, y);
				IntStream.range(0, XS.length).forEach(j -> maps[j].put(x * XS[j] + y * YS[j], point));
				return point;
			}).toArray(Point[]::new);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int qi = scanner.nextInt() - 1;
				sb.append(IntStream.range(0, XS.length)
						.mapToLong(j -> Math.max(distance(points[qi], maps[j].firstEntry().getValue()),
								distance(points[qi], maps[j].lastEntry().getValue())))
						.max().getAsLong()).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * a と bのマンハッタン距離を計算する
	 *
	 * @param a
	 * @param b
	 * @return a と bのマンハッタン距離
	 */
	private static long distance(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	/**
	 * x,y を格納するクラス
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
