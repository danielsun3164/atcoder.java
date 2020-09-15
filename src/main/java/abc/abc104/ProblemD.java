package abc.abc104;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** 文字列ABC */
	private static final char[] ABC = new char[] { 'A', 'B', 'C' };
	/** 文字? */
	private static final char ALL = '?';
	/** 1_000_000_007 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			long[][] dp = new long[n + 1][4];
			dp[n][3] = 1L;
			dp[n][0] = dp[n][1] = dp[n][2] = 0L;
			IntStream.rangeClosed(1, n).map(i -> n - i).forEach(i -> {
				dp[i][3] = ((ALL == s[i]) ? 3 : 1) * dp[i + 1][3] % MOD;
				IntStream.range(0, 3).forEach(j -> dp[i][j] = (((ALL == s[i]) ? 3 : 1) * dp[i + 1][j] % MOD
						+ (((ALL == s[i]) || (ABC[j] == s[i])) ? 1 : 0) * dp[i + 1][j + 1] % MOD) % MOD);
			});
			System.out.println(dp[0][0]);
		}
	}
}
