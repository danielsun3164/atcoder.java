package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem050 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), l = scanner.nextInt();
			long[] dp = new long[n + 1];
			Arrays.fill(dp, 0L);
			dp[0] = 1L;
			IntStream.range(0, n).forEach(i -> {
				dp[i + 1] = (dp[i + 1] + dp[i]) % MOD;
				if (i + l <= n) {
					dp[i + l] = (dp[i + l] + dp[i]) % MOD;
				}
			});
			System.out.println(dp[n]);
		}
	}
}
