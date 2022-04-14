package abc.abc201_250.abc215;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** 文字の種類数 */
	private static final int N = 10;
	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), p = 1 << N;
			int[] s = scanner.next().chars().map(c -> c - 'A').toArray();
			long[][][] dp = new long[2][p][N + 1];
			IntStream.range(0, 2).forEach(i -> IntStream.range(0, p).forEach(j -> Arrays.fill(dp[i][j], 0L)));
			dp[0][0][N] = 1L;
			IntStream.range(0, n).forEach(i -> {
				int q = 1 << s[i];
				IntStream.range(0, p).forEach(j -> Arrays.fill(dp[1 & (i + 1)][j], 0L));
				IntStream.range(0, p).forEach(
						j -> IntStream.range(0, (0 == j) ? N + 1 : N).filter(k -> dp[1 & i][j][k] > 0L).forEach(k -> {
							dp[1 & (i + 1)][j][k] = (dp[1 & (i + 1)][j][k] + dp[1 & i][j][k]) % MOD;
							if ((k == N) || (k == s[i]) || (0 == (j & q))) {
								dp[1 & (i + 1)][j | q][s[i]] = (dp[1 & (i + 1)][j | q][s[i]] + dp[1 & i][j][k]) % MOD;
							}
						}));
			});
			System.out.println(IntStream.range(1, p)
					.mapToLong(j -> IntStream.range(0, N).mapToLong(k -> dp[1 & n][j][k]).sum()).sum() % MOD);
		}
	}
}
