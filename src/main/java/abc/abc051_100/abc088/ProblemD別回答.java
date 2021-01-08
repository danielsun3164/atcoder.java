package abc.abc051_100.abc088;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りではない別回答
 */
public class ProblemD別回答 {

	/** 白のコマ */
	private static final char WHITE = '.';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			boolean[][] s = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(s[i], false));
			int whiteCount = 0;
			for (int i = 0; i < h; i++) {
				char[] l = scanner.next().toCharArray();
				for (int j = 0; j < w; j++) {
					s[i][j] = (l[j] == WHITE);
					if (s[i][j]) {
						whiteCount++;
					}
				}
			}
			int[][] v = new int[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(v[i], Integer.MAX_VALUE));
			v[0][0] = 1;
			calcResult(0, 0, s, v);
			System.out.println((v[h - 1][w - 1] < Integer.MAX_VALUE) ? whiteCount - v[h - 1][w - 1] : -1);
		}
	}

	/**
	 * @param x X座標
	 * @param y Y座標
	 * @param s マスの状態の配列
	 * @param v (0,0)からそれぞれのマスへ移動する場合の通過マスの数の最小値
	 */
	private static void calcResult(int x, int y, final boolean[][] s, final int[][] v) {
		int h = s.length, w = s[0].length;
		if (((h - 1) == x) && ((w - 1) == y)) {
			// 終点の場合、終了
			return;
		}
		if ((x > 0) && s[x - 1][y] && (v[x][y] + 1 < v[x - 1][y])) {
			v[x - 1][y] = v[x][y] + 1;
			calcResult(x - 1, y, s, v);
		}
		if ((y > 0) && s[x][y - 1] && (v[x][y] + 1 < v[x][y - 1])) {
			v[x][y - 1] = v[x][y] + 1;
			calcResult(x, y - 1, s, v);
		}
		if ((x < h - 1) && s[x + 1][y] && (v[x][y] + 1 < v[x + 1][y])) {
			v[x + 1][y] = v[x][y] + 1;
			calcResult(x + 1, y, s, v);
		}
		if ((y < w - 1) && s[x][y + 1] && (v[x][y] + 1 < v[x][y + 1])) {
			v[x][y + 1] = v[x][y] + 1;
			calcResult(x, y + 1, s, v);
		}
	}
}
