package abc.abc201_250.abc201;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** 青を表す文字 */
	private static final char BLUE = '+';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] a = new char[h][];
			IntStream.range(0, h).forEach(i -> a[i] = scanner.next().toCharArray());
			// dp[i][j]はi,jから計算する高橋の得点と青木の得点の差
			int[][] dp = new int[h][w];
			IntStream.range(0, h)
					.forEach(i -> IntStream.range(0, w).forEach(j -> dp[i][j] = (0 == ((i + j) & 1)) ? -INF : INF));
			dp[h - 1][w - 1] = 0;
			for (int i = h - 1; i >= 0; i--) {
				for (int j = w - 1; j >= 0; j--) {
					if (1 == ((i + j) & 1)) {
						// 高橋の計算
						if (i > 0) {
							dp[i - 1][j] = Math.max(dp[i - 1][j], dp[i][j] + (BLUE == a[i][j] ? 1 : -1));
						}
						if (j > 0) {
							dp[i][j - 1] = Math.max(dp[i][j - 1], dp[i][j] + (BLUE == a[i][j] ? 1 : -1));
						}
					} else {
						// 青木の計算
						if (i > 0) {
							dp[i - 1][j] = Math.min(dp[i - 1][j], dp[i][j] - (BLUE == a[i][j] ? 1 : -1));
						}
						if (j > 0) {
							dp[i][j - 1] = Math.min(dp[i][j - 1], dp[i][j] - (BLUE == a[i][j] ? 1 : -1));
						}
					}
				}
			}
			System.out.println((0 == dp[0][0]) ? "Draw" : ((dp[0][0] > 0) ? "Takahashi" : "Aoki"));
		}
	}
}
