package abc.abc201_250.abc221;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc221/editorial/2737 解法の実装<br/>
 * https://atcoder.jp/contests/abc221/submissions/26313384 にも参考
 */
public class ProblemH別回答1 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[][] dp = new long[n + 1][n + 1], ps = new long[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> {
				Arrays.fill(dp[i], 0L);
				Arrays.fill(ps[i], 0L);
			});
			dp[0][0] = ps[0][0] = 1L;
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n).forEach(i -> {
				IntStream.rangeClosed(0, n).forEach(j -> ps[i][j] = ps[i - 1][j]);
				IntStream.rangeClosed(i, n).forEach(j -> {
					dp[i][j] = ps[i][j - i];
					if (i > m) {
						dp[i][j] = (dp[i][j] - ps[i - m - 1][j - i] + MOD) % MOD;
					}
					ps[i][j] = (ps[i][j] + dp[i][j]) % MOD;
				});
				sb.append(dp[i][n]).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
