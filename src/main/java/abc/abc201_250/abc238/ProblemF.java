package abc.abc201_250.abc238;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc238/editorial/3354 の実装
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray(),
					q = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int[] v = new int[n];
			IntStream.range(0, n).forEach(i -> v[p[i]] = q[i]);
			long[][][] dp = new long[2][k + 1][n + 1];
			IntStream.range(0, k + 1).forEach(i -> Arrays.fill(dp[0][i], 0L));
			dp[0][0][n] = 1L;
			IntStream.range(0, n).forEach(i -> {
				IntStream.range(0, k + 1).forEach(j -> Arrays.fill(dp[(i + 1) & 1][j], 0L));
				IntStream.rangeClosed(0, k).forEach(x -> IntStream.rangeClosed(0, n).forEach(y -> {
					if ((x < k) && (v[i] < y)) {
						dp[(i + 1) & 1][x + 1][y] = (dp[(i + 1) & 1][x + 1][y] + dp[i & 1][x][y]) % MOD;
					}
					dp[(i + 1) & 1][x][Math.min(y, v[i])] = (dp[(i + 1) & 1][x][Math.min(y, v[i])] + dp[i & 1][x][y])
							% MOD;
				}));
			});
			System.out.println(Arrays.stream(dp[n & 1][k]).sum() % MOD);
		}
	}
}
