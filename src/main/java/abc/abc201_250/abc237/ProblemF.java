package abc.abc201_250.abc237;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc237/editorial/3320 の実装
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[][][][] dp = new long[n + 1][m + 2][m + 2][m + 2];
			IntStream.range(0, n + 1).forEach(i -> IntStream.range(0, m + 2)
					.forEach(a1 -> IntStream.range(0, m + 2).forEach(a2 -> Arrays.fill(dp[i][a1][a2], 0L))));
			dp[0][m + 1][m + 1][m + 1] = 1L;
			IntStream.range(0, n)
					.forEach(i -> IntStream.rangeClosed(1, m + 1)
							.forEach(a1 -> IntStream.rangeClosed(a1, m + 1).forEach(a2 -> IntStream
									.rangeClosed(a2, m + 1).forEach(a3 -> IntStream.rangeClosed(1, m).forEach(x -> {
										if (x <= a1) {
											dp[i + 1][x][a2][a3] = (dp[i + 1][x][a2][a3] + dp[i][a1][a2][a3]) % MOD;
										} else if (x <= a2) {
											dp[i + 1][a1][x][a3] = (dp[i + 1][a1][x][a3] + dp[i][a1][a2][a3]) % MOD;
										} else if (x <= a3) {
											dp[i + 1][a1][a2][x] = (dp[i + 1][a1][a2][x] + dp[i][a1][a2][a3]) % MOD;
										}
									})))));
			System.out.println(IntStream.rangeClosed(1, m).mapToLong(a1 -> IntStream.rangeClosed(a1, m)
					.mapToLong(a2 -> IntStream.rangeClosed(a2, m).mapToLong(a3 -> dp[n][a1][a2][a3]).sum()).sum()).sum()
					% MOD);
		}
	}
}
