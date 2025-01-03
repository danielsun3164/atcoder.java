package abc.abc201_250.abc202;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * Monotone Chain の実装
 */
public class ProblemF {

	/** modの対象値 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Point[] points = IntStream.range(0, n).mapToObj(i -> new Point(scanner.nextInt(), scanner.nextInt()))
					.sorted((a, b) -> (a.x == b.x) ? Integer.compare(a.y, b.y) : Integer.compare(a.x, b.x))
					.toArray(Point[]::new);
			int[][][] inside = new int[n][n][n], parity = new int[n][n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> Arrays.fill(inside[i][j], 0)));
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).filter(j -> j != i)
					.forEach(j -> IntStream.range(0, n).filter(k -> (k != i) && (k != j)).forEach(k -> {
						int area = area2(points, i, j, k);
						parity[i][j][k] = area & 1;
						IntStream.range(0, n).filter(l -> (l != i) && (l != j) && (l != k)).filter(
								l -> (area2(points, l, i, j) + area2(points, l, j, k) + area2(points, l, k, i)) == area)
								.forEach(l -> inside[i][j][k]++);
					})));
			// pow2[i]は2^i mod MOD
			long[] pow2 = new long[n + 1];
			pow2[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> pow2[i] = (pow2[i - 1] * 2L) % MOD);
			long[][][] upper = new long[n][n][2], lower = new long[n][n][2];
			System.out.println((((IntStream.range(0, n).map(i -> n - 1 - i).mapToLong(must -> {
				// points[must] を左下の点とする凸多角形
				IntStream.range(must, n).forEach(i -> IntStream.range(must, n).forEach(j -> {
					Arrays.fill(upper[i][j], 0);
					Arrays.fill(lower[i][j], 0);
				}));
				IntStream.range(must + 1, n).forEach(i -> upper[must][i][0] = lower[must][i][0] = 1);
				IntStream.range(must, n).forEach(i -> IntStream.range(i + 1, n)
						.forEach(j -> IntStream.range(0, 2).forEach(k -> IntStream.range(j + 1, n).forEach(l -> {
							// 線分 P_iP_j と線分 P_jP_l の関係を調べる
							if (cross(points[l].x - points[j].x, points[l].y - points[j].y, points[j].x - points[i].x,
									points[j].y - points[i].y) > 0) {
								// 新たに P_must, P_j, P_l を頂点にもつ三角形を貼り合わせる
								upper[j][l][k ^ parity[must][j][l]] = (upper[j][l][k ^ parity[must][j][l]]
										+ ((upper[i][j][k] * pow2[inside[must][j][l]]) % MOD)) % MOD;
							} else {
								lower[j][l][k ^ parity[must][j][l]] = (lower[j][l][k ^ parity[must][j][l]]
										+ ((lower[i][j][k] * pow2[inside[must][j][l]]) % MOD)) % MOD;
							}
						}))));
				return IntStream.range(must + 1, n).mapToLong(j -> IntStream.range(0, 2).mapToLong(
						k -> (LongStream.range(must, j).reduce(0L, (sum, i) -> (sum + upper[(int) i][j][k]) % MOD)
								* LongStream.range(must, j).reduce(0L, (sum, i) -> (sum + lower[(int) i][j][k]) % MOD))
								% MOD)
						.sum() % MOD).sum() % MOD;
			}).sum() - ((n * (n - 1L)) / 2L)) % MOD) + MOD) % MOD);
		}
	}

	/**
	 * i番目、j番目とk番目の点で構成される三角形の面積の2倍を計算する
	 *
	 * @param points 点の一覧
	 * @param i
	 * @param j
	 * @param k
	 * @return i番目、j番目とk番目の点で構成される三角形の面積の2倍
	 */
	private static int area2(Point[] points, int i, int j, int k) {
		return Math.abs(cross(points[j].x - points[i].x, points[j].y - points[i].y, points[k].x - points[i].x,
				points[k].y - points[i].y));
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
			this.x = x;
			this.y = y;
		}
	}
}
