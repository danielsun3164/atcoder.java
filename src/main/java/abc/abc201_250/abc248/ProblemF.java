package abc.abc201_250.abc248;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/3794 の実装
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), p = scanner.nextInt();
			long[][][] dp = new long[2][n + 2][2];
			IntStream.range(0, 2).forEach(i -> IntStream.rangeClosed(0, n + 1).forEach(j -> Arrays.fill(dp[i][j], 0L)));
			dp[0][0][0] = dp[0][1][1] = 1L;
			IntStream.range(0, n - 1).forEach(i -> {
				IntStream.range(0, i + 3).forEach(j -> Arrays.fill(dp[1 & (i + 1)][j], 0L));
				IntStream.range(0, i + 2).forEach(j -> IntStream.range(0, 2).forEach(a -> IntStream.range(0, 2)
						.forEach(b -> IntStream.range(0, 2).filter(c -> (j + a + b + c) <= n + 1).forEach(c -> {
							if ((a + b + c) <= 1) {
								dp[1 & (i + 1)][j + a + b + c][0] += dp[1 & i][j][0];
							} else if ((a + b) <= 1) {
								dp[1 & (i + 1)][j + a + b + c][1] += dp[1 & i][j][0];
							}
							if (0 == (a + b + c)) {
								dp[1 & (i + 1)][j + a + b + c][0] += dp[1 & i][j][1];
							} else if (0 == (a + b)) {
								dp[1 & (i + 1)][j + a + b + c][1] += dp[1 & i][j][1];
							}
						}))));
				IntStream.range(0, i + 3).forEach(j -> IntStream.range(0, 2).forEach(k -> dp[1 & (i + 1)][j][k] %= p));
			});
			System.out.println(IntStream.range(1, n).mapToObj(j -> String.valueOf(dp[1 & (n - 1)][j][0]))
					.collect(Collectors.joining(" ")));
		}
	}
}
