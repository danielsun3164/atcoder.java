package abc.abc201_250.abc217;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc217/editorial/2390 の解説の実装
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[][] dp = new long[2][n + 1];
			IntStream.range(0, 2).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				Arrays.fill(dp[i & 1], 0L);
				IntStream.rangeClosed(1, n).forEach(
						j -> dp[i & 1][j] = (dp[(i - 1) & 1][j - 1] + (j - (i - 1) / m) * dp[(i - 1) & 1][j] % MOD)
								% MOD);
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n).forEach(i -> sb.append(dp[n & 1][i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
