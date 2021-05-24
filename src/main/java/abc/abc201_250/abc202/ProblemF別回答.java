package abc.abc201_250.abc202;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * Graham Scan の実装
 */
public class ProblemF別回答 {

	/** modの対象値 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] points = IntStream.range(0, n).mapToObj(i -> new Point(scanner.nextInt(), scanner.nextInt()))
					.sorted((a, b) -> (a.x == b.x) ? Integer.compare(a.y, b.y) : Integer.compare(a.x, b.x))
					.toArray(Point[]::new);
			long[] pow2 = new long[n + 1];
			pow2[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> pow2[i] = (pow2[i - 1] * 2L) % MOD);
			System.out.println(IntStream.range(0, n).mapToLong(leftmost -> {
				Point[] pts = IntStream.range(leftmost, n).mapToObj(j -> points[j].sub(points[leftmost]))
						.sorted((a, b) -> -cross(a.x, a.y, b.x, b.y)).toArray(Point[]::new);
				int len = pts.length;
				int[][] count = new int[len][len];
				IntStream.range(0, len).forEach(i -> Arrays.fill(count[i], 0));
				IntStream.range(0, len)
						.forEach(i -> IntStream.range(i + 1, len)
								.forEach(j -> IntStream.range(i + 1, j)
										.filter(k -> cross(pts[i].x - pts[k].x, pts[i].y - pts[k].y,
												pts[j].x - pts[k].x, pts[j].y - pts[k].y) > 0)
										.forEach(k -> count[i][j]++)));
				long[][][] dp = new long[len][len][2];
				IntStream.range(0, len).forEach(i -> IntStream.range(0, len).forEach(j -> Arrays.fill(dp[i][j], 0L)));
				IntStream.range(1, len).forEach(i -> dp[0][i][0]++);
				IntStream.range(0, len).forEach(i -> IntStream.range(i + 1, len)
						.forEach(j -> IntStream.range(0, 2).forEach(k -> IntStream.range(j + 1, len).forEach(l -> {
							if (cross(pts[j].x - pts[i].x, pts[j].y - pts[i].y, pts[l].x - pts[j].x,
									pts[l].y - pts[j].y) > 0) {
								int m = k ^ (cross(pts[j].x, pts[j].y, pts[l].x, pts[l].y) & 1);
								dp[j][l][m] = (dp[j][l][m] + ((dp[i][j][k] * pow2[count[j][l]]) % MOD)) % MOD;
							}
						}))));
				return IntStream.range(1, len)
						.mapToLong(i -> IntStream.range(i + 1, len).mapToLong(j -> dp[i][j][0]).sum() % MOD).sum()
						% MOD;
			}).sum() % MOD);
		}
	}

	/**
	 * 点1と点2のクロス積を計算する
	 *
	 * @param x1 点1のx座標
	 * @param y1 点1のy座標
	 * @param x2 点2のx座標
	 * @param y2 点2のy座標
	 * @return 点1と点2のクロス積
	 */
	private static int cross(int x1, int y1, int x2, int y2) {
		return (x1 * y2) - (y1 * x2);
	}

	/**
	 * x,yを格納するクラス
	 */
	private static class Point {
		int x, y;

		Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		Point sub(Point p) {
			return new Point(x - p.x, y - p.y);
		}
	}
}
