package abc007;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int R = scanner.nextInt();
			int C = scanner.nextInt();
			int sx = scanner.nextInt();
			int sy = scanner.nextInt();
			int gx = scanner.nextInt();
			int gy = scanner.nextInt();
			scanner.nextLine();
			boolean[][] c = new boolean[R][C];
			IntStream.range(0, R).forEach(i -> {
				String s = scanner.nextLine();
				IntStream.range(0, C).forEach(j -> {
					switch (s.charAt(j)) {
					case '.':
						c[i][j] = true;
						break;
					case '#':
					default:
						c[i][j] = false;
						break;
					}
				});
			});
			int[][] r = new int[R][C];
			IntStream.range(0, R).forEach(i -> IntStream.range(0, C).forEach(j -> r[i][j] = Integer.MAX_VALUE));
			r[sx - 1][sy - 1] = 0;
			calcResult(r, c, sx - 1, sy - 1);
			System.out.println(r[gx - 1][gy - 1]);
		}
	}

	/**
	 * 計算結果の配列を記入
	 * 
	 * @param r 計算結果の配列
	 * @param c 迷路のマスデータの配列
	 * @param x マスのX座標
	 * @param y マスのY座標
	 */
	private static void calcResult(int[][] r, boolean[][] c, int x, int y) {
		// 上へ移動
		if ((x > 0) && (c[x - 1][y]) && (r[x - 1][y] > r[x][y] + 1)) {
			r[x - 1][y] = r[x][y] + 1;
			calcResult(r, c, x - 1, y);
		}
		// 下へ移動
		if ((x < r.length - 1) && (c[x + 1][y]) && (r[x + 1][y] > r[x][y] + 1)) {
			r[x + 1][y] = r[x][y] + 1;
			calcResult(r, c, x + 1, y);
		}
		// 左へ移動
		if ((y > 0) && (c[x][y - 1]) && (r[x][y - 1] > r[x][y] + 1)) {
			r[x][y - 1] = r[x][y] + 1;
			calcResult(r, c, x, y - 1);
		}
		// 右へ移動
		if ((y < r[0].length - 1) && (c[x][y + 1]) && (r[x][y + 1] > r[x][y] + 1)) {
			r[x][y + 1] = r[x][y] + 1;
			calcResult(r, c, x, y + 1);
		}
	}
}
