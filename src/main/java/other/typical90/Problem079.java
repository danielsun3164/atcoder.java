package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem079 {

	/** X座標の差分一覧 */
	private static final int[] DX = { 0, 1, 1 };
	/** Y座標の差分一覧 */
	private static final int[] DY = { 1, 0, 1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[][] a = new int[h][w], c = new int[h][w];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> a[i][j] = scanner.nextInt()));
			IntStream.range(0, h)
					.forEach(i -> IntStream.range(0, w).forEach(j -> c[i][j] = scanner.nextInt() - a[i][j]));
			long answer = 0L;
			for (int i = 0; i < h - 1; i++) {
				for (int j = 0; j < w - 1; j++) {
					for (int k = 0; k < DX.length; k++) {
						c[i + DX[k]][j + DY[k]] -= c[i][j];
					}
					answer += Math.abs(c[i][j]);
					c[i][j] = 0;
				}
				if (0 != c[i][w - 1]) {
					System.out.println("No");
					return;
				}
			}
			for (int j = 0; j < w; j++) {
				if (0 != c[h - 1][j]) {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
			System.out.println(answer);
		}
	}
}
