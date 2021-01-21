package abc.abc101_150.abc134;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[][][] dp = new long[n + 1][n + 1][k + 1];
			dp[0][0][0] = 1L;
			IntStream.rangeClosed(1, n).forEach(
					i -> IntStream.rangeClosed(0, n).forEach(j -> IntStream.rangeClosed(2 * j, k).forEach(l -> {
						dp[i][j][l] = ((2 * j + 1) * dp[i - 1][j][l - 2 * j] % MOD
								+ ((j < n) ? (j + 1) * (j + 1) * dp[i - 1][j + 1][l - 2 * j] % MOD : 0L)
								+ ((j > 0) ? dp[i - 1][j - 1][l - 2 * j] % MOD : 0L)) % MOD;
					})));
			System.out.println(dp[n][0][k]);
		}
	}
}
