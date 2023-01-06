package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem045別回答 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			long[][] d = new long[n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n)
					.forEach(j -> d[i][j] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j])));
			int p = 1 << n;
			long[] cost = new long[p];
			IntStream.range(0, p)
					.forEach(
							i -> cost[i] = IntStream.range(0, n)
									.mapToLong(j -> IntStream.range(0, n)
											.filter(l -> ((i & (1 << j)) > 0) && ((i & (1 << l)) > 0))
											.mapToLong(l -> d[j][l]).max().orElse(0L))
									.max().orElse(0L));
			long[][] dp = new long[k + 1][p];
			IntStream.rangeClosed(0, k).forEach(i -> Arrays.fill(dp[i], INF));
			dp[0][0] = 0L;
			IntStream.range(0, k).forEach(i -> IntStream.range(1, p).forEach(j -> {
				for (int l = j; l != 0; l = (l - 1) & j) {
					dp[i + 1][j] = Math.min(dp[i + 1][j], Math.max(dp[i][j - l], cost[l]));
				}
			}));
			System.out.println(dp[k][p - 1]);
		}
	}
}
