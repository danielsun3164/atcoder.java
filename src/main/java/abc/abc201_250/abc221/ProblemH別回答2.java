package abc.abc201_250.abc221;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc221/editorial/2738 解法の実装<br/>
 * https://atcoder.jp/contests/abc221/submissions/26295827 にも参考
 */
public class ProblemH別回答2 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[][] dp = new long[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				IntStream.rangeClosed(0, n).forEach(j -> {
					// 1
					if (j >= 1) {
						dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
					}
					if ((i >= (m + 1)) && (j >= i)) {
						dp[i][j] = (dp[i][j] - dp[i - m - 1][j - i] + MOD) % MOD;
					}
					// 2
					if (j >= i) {
						dp[i][j] = (dp[i][j] + dp[i][j - i]) % MOD;
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
