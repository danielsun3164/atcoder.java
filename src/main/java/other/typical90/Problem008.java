package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem008 {

	/** atcoderの文字数 */
	private static final int N = 7;
	/** atcoderの文字の配列 */
	private static final char[] ATCODER = "atcoder".toCharArray();
	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			long[][] dp = new long[n + 1][N + 1];
			Arrays.fill(dp[0], 0L);
			IntStream.rangeClosed(0, n).forEach(i -> dp[i][0] = 1L);
			IntStream.rangeClosed(1, n).forEach(i -> IntStream.rangeClosed(1, N).forEach(j -> {
				dp[i][j] = dp[i - 1][j];
				if (ATCODER[j - 1] == s[i - 1]) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
				}
			}));
			System.out.println(dp[n][N]);
		}
	}
}
