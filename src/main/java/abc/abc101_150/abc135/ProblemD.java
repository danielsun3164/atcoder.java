package abc.abc101_150.abc135;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemD {

	/** 割る数字 */
	private static final int N = 13;
	/** 目標の余り数 */
	private static final int REMAINDER = 5;
	/** modの対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			long[][] dp = new long[2][N];
			dp[1 & n][0] = 1L;
			int power = 1;
			for (int i = n - 1; i >= 0; i--) {
				if (('0' <= s[i]) && (s[i] <= '9')) {
					int t = s[i] - '0';
					for (int j = 0; j < N; j++) {
						dp[1 & i][(t * power + j) % N] = (dp[1 & i][(t * power + j) % N] + dp[1 & (i + 1)][j]) % MOD;
					}
				} else {
					for (int t = 0; t <= 9; t++) {
						for (int j = 0; j < N; j++) {
							dp[1 & i][(t * power + j) % N] = (dp[1 & i][(t * power + j) % N] + dp[1 & (i + 1)][j])
									% MOD;
						}
					}
				}
				Arrays.fill(dp[1 & (i - 1)], 0L);
				power = power * 10 % N;
			}
			System.out.println(dp[0][REMAINDER]);
		}
	}
}
