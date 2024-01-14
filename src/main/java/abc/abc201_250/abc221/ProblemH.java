package abc.abc201_250.abc221;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc221/editorial/2719 解法の実装
 */
public class ProblemH {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[][] dp = new long[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			long[] sum = new long[n + 1];
			Arrays.fill(sum, 0L);
			sum[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				IntStream.rangeClosed(i, n).forEach(j -> dp[i][j] = (sum[j - i] + dp[i][j - i]) % MOD);
				IntStream.rangeClosed(0, n).forEach(j -> {
					sum[j] = (sum[j] + dp[i][j]) % MOD;
					if (m <= i) {
						sum[j] = (sum[j] - dp[i - m][j] + MOD) % MOD;
					}
				});
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n).forEach(i -> sb.append(dp[i][n]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
