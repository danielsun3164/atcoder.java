package abc.abc101_150.abc130;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc130/submissions/15248353 にも参考
 */
public class ProblemE {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] s = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] t = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			long[][] dp = new long[n + 1][m + 1];
			IntStream.rangeClosed(0, n).forEach(i -> {
				Arrays.fill(dp[i], 0L);
				dp[i][0] = 1L;
			});
			Arrays.fill(dp[0], 1L);
			IntStream.range(0, n).forEach(i -> IntStream.range(0, m).forEach(j -> {
				dp[i + 1][j + 1] = (dp[i][j + 1] + dp[i + 1][j] + ((s[i] == t[j]) ? 0L : MOD - dp[i][j])) % MOD;
			}));
			System.out.println(dp[n][m]);
		}
	}
}
