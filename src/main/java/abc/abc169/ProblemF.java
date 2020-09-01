package abc.abc169;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), s = scanner.nextInt();
			int[] a = new int[n + 1];
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = scanner.nextInt());
			long[][] dp = new long[n + 1][s + 1];
			Arrays.fill(dp[0], 0L);
			dp[0][0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				IntStream.range(0, Math.min(a[i], s + 1)).forEach(j -> dp[i][j] = 2 * dp[i - 1][j] % MOD);
				IntStream.rangeClosed(a[i], s)
						.forEach(j -> dp[i][j] = (2 * dp[i - 1][j] % MOD + dp[i - 1][j - a[i]]) % MOD);
			});
			System.out.println(dp[n][s]);
		}
	}
}
