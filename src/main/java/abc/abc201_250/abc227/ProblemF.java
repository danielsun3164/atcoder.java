package abc.abc201_250.abc227;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc227/editorial/2914 の実装
 */
public class ProblemF {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), k = scanner.nextInt();
			long[][] a = IntStream.range(0, h)
					.mapToObj(i -> IntStream.range(0, w).mapToLong(j -> scanner.nextLong()).toArray())
					.toArray(long[][]::new);
			long answer = INF;
			for (long[] ai : a) {
				for (long x : ai) {
					long[][][] dp = new long[k + 1][h][w];
					IntStream.range(0, k + 1)
							.forEach(i -> IntStream.range(0, h).forEach(j -> Arrays.fill(dp[i][j], INF)));
					if (a[0][0] >= x) {
						dp[1][0][0] = a[0][0];
					}
					if (a[0][0] <= x) {
						dp[0][0][0] = 0L;
					}
					for (int i = 0; i < k + 1; i++) {
						for (int j = 0; j < h; j++) {
							for (int l = 0; l < w; l++) {
								if (j != h - 1) {
									if ((i != k) && a[j + 1][l] >= x) {
										dp[i + 1][j + 1][l] = Math.min(dp[i + 1][j + 1][l], dp[i][j][l] + a[j + 1][l]);
									}
									if (a[j + 1][l] <= x) {
										dp[i][j + 1][l] = Math.min(dp[i][j + 1][l], dp[i][j][l]);
									}
								}
								if (l != w - 1) {
									if ((i != k) && (a[j][l + 1] >= x)) {
										dp[i + 1][j][l + 1] = Math.min(dp[i + 1][j][l + 1], dp[i][j][l] + a[j][l + 1]);
									}
									if (a[j][l + 1] <= x) {
										dp[i][j][l + 1] = Math.min(dp[i][j][l + 1], dp[i][j][l]);
									}
								}
							}
						}
					}
					answer = Math.min(answer, dp[k][h - 1][w - 1]);
				}
			}
			System.out.println(answer);
		}
	}
}
