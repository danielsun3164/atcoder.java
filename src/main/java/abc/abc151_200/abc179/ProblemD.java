package abc.abc151_200.abc179;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] dp = new long[n + 2];
			Arrays.fill(dp, 0L);
			dp[0] = 1L;
			dp[2] = -1L;
			int[] l = new int[k], r = new int[k];
			IntStream.range(0, k).forEach(i -> {
				l[i] = scanner.nextInt();
				r[i] = scanner.nextInt();
			});
			IntStream.rangeClosed(1, n).forEach(i -> {
				dp[i] = (dp[i] + dp[i - 1]) % MOD;
				IntStream.range(0, k).filter(j -> i + l[j] <= n).forEach(j -> {
					dp[i + l[j]] = (dp[i + l[j]] + dp[i]) % MOD;
					dp[Math.min(n + 1, i + r[j] + 1)] = (dp[Math.min(n + 1, i + r[j] + 1)] - dp[i] + MOD) % MOD;
				});
			});
			System.out.println(dp[n]);
		}
	}
}
