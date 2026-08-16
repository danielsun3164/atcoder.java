package abc.abc201_250.abc239;

import java.util.Scanner;

public class ProblemC {

	/** X座標の差分 */
	private static final int[] XS = { 1, 1, -1, -1, 2, 2, -2, -2 };
	/** Y座標の差分 */
	private static final int[] YS = { 2, -2, 2, -2, 1, -1, 1, -1 };
	/** 5 */
	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x1 = scanner.nextLong(), y1 = scanner.nextLong(), x2 = scanner.nextLong(), y2 = scanner.nextLong();
			for (int i = 0; i < XS.length; i++) {
				long nx = x1 + XS[i], ny = y1 + YS[i];
				if (N == distance2(nx, ny, x2, y2)) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
	}

	/**
	 * (x1,y1)から(x2,y2)の距離の平方を計算する
	 *
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return (x1,y1)から(x2,y2)の距離の平方
	 */
	private static long distance2(long x1, long y1, long x2, long y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
