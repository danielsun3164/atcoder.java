package abc.abc151_200.abc159;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc159/submissions/11096062 にも参考
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), s = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long[][][] dp = new long[n + 1][s + 1][3];
			dp[0][0][0] = 1L;
			IntStream.range(0, n).forEach(i -> IntStream.rangeClosed(0, s).forEach(j -> {
				dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][0]) % MOD;
				dp[i + 1][j][1] = (dp[i + 1][j][1] + dp[i][j][0] + dp[i][j][1]) % MOD;
				dp[i + 1][j][2] = (dp[i + 1][j][2] + dp[i][j][0] + dp[i][j][1] + dp[i][j][2]) % MOD;
				if (j + a[i] <= s) {
					dp[i + 1][j + a[i]][1] = (dp[i + 1][j + a[i]][1] + dp[i][j][0] + dp[i][j][1]) % MOD;
					dp[i + 1][j + a[i]][2] = (dp[i + 1][j + a[i]][2] + dp[i][j][0] + dp[i][j][1]) % MOD;
				}
			}));
			System.out.println(dp[n][s][2]);
		}
	}
}
