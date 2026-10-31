package abc.abc201_250.abc248;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			long[][] dp = new long[n + 1][k + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			IntStream.range(0, n).forEach(i -> {
				long sum = 0L;
				for (int j = i; j < k; j++) {
					sum = (sum + dp[i][j]) % MOD;
					if ((j >= m) && (dp[i][j - m] > 0L)) {
						sum = (sum + MOD - dp[i][j - m]) % MOD;
					}
					dp[i + 1][j + 1] = (dp[i + 1][j + 1] + sum) % MOD;
				}
			});
			System.out.println(Arrays.stream(dp[n]).sum() % MOD);
		}
	}
}
