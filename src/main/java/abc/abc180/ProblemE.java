package abc.abc180;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc180/submissions/17511629 にも参考
 */
public class ProblemE {

	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n], z = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
				z[i] = scanner.nextInt();
			});

			int m = 1 << n;
			// dist[i][j]はiからjへの距離
			int[][] dist = new int[n][n];
			int[][] dp = new int[n][m];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(
					j -> dist[i][j] = Math.abs(x[j] - x[i]) + Math.abs(y[j] - y[i]) + Math.max(0, z[j] - z[i])));
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(dp[i], INF);
				dp[i][0] = 0;
			});
			IntStream.range(1, m).forEach(s -> IntStream.range(0, n).filter(i -> (s & (1 << i)) > 0).forEach(i -> {
				if (1 == Integer.bitCount(s)) {
					// 最初のところは始点からの距離を計算
					dp[i][s] = dist[0][i];
				} else {
					IntStream.range(0, n).filter(j -> ((s - (1 << i)) & (1 << j)) > 0)
							.forEach(j -> dp[i][s] = Math.min(dp[i][s], dp[j][s - (1 << i)] + dist[j][i]));
				}
			}));
			System.out.println(IntStream.range(1, n).map(i -> dp[i][m - 1] + dist[i][0]).min().getAsInt());
		}
	}
}
