package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem019 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = n << 1;
			int[] a = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			// dp[i][j]はa_i,...,a_jを消すための最小コスト
			int[][] dp = new int[m][m];
			IntStream.range(0, m).forEach(i -> Arrays.fill(dp[i], INF));
			IntStream.range(0, m - 1).forEach(i -> dp[i][i + 1] = Math.abs(a[i] - a[i + 1]));
			for (int j = 3; j < m; j += 2) {
				for (int i = 0; i < (m - j); i++) {
					for (int k = 1; k < j; k += 2) {
						dp[i][i + j] = Math.min(dp[i][i + j], dp[i][i + k] + dp[i + k + 1][i + j]);
					}
					dp[i][i + j] = Math.min(dp[i][i + j], dp[i + 1][(i + j) - 1] + Math.abs(a[i] - a[i + j]));
				}
			}
			System.out.println(dp[0][m - 1]);
		}
	}
}
