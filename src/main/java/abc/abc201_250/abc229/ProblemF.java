package abc.abc201_250.abc229;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc229/editorial/2964 の実装
 */
public class ProblemF {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n + 1], b = new long[n + 1];
			a[0] = b[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = scanner.nextLong());
			IntStream.rangeClosed(1, n).forEach(i -> b[i] = scanner.nextLong());
			long[][][] dp = new long[n + 1][2][2];
			IntStream.rangeClosed(0, n).forEach(i -> IntStream.range(0, 2).forEach(j -> Arrays.fill(dp[i][j], INF)));
			dp[1][0][0] = a[1];
			dp[1][1][1] = 0L;
			IntStream.rangeClosed(2, n)
					.forEach(i -> IntStream.range(0, 2).forEach(j -> IntStream.range(0, 2)
							.forEach(k -> IntStream.range(0, 2).forEach(prej -> dp[i][j][k] = Math.min(dp[i][j][k],
									dp[i - 1][prej][k] + ((0 == j) ? a[i] : 0L) + ((prej == j) ? b[i - 1] : 0L))))));
			System.out.println(IntStream.range(0, 2).mapToLong(
					j -> IntStream.range(0, 2).mapToLong(k -> dp[n][j][k] + ((j == k) ? b[n] : 0L)).min().getAsLong())
					.min().getAsLong());
		}
	}
}
