package abc.abc201_250.abc208;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m], b = new int[m], c = new int[m];
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				c[i] = scanner.nextInt();
			});
			int[][] dp = new int[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(dp[i], INF));
			IntStream.range(0, n).forEach(i -> dp[i][i] = 0);
			IntStream.range(0, m).forEach(i -> dp[a[i]][b[i]] = c[i]);
			System.out.println(IntStream.range(0, n).mapToLong(k -> {
				IntStream.range(0, n).forEach(
						i -> IntStream.range(0, n).forEach(j -> dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j])));
				return IntStream.range(0, n)
						.mapToLong(i -> IntStream.range(0, n).mapToLong(j -> (INF == dp[i][j]) ? 0 : dp[i][j]).sum())
						.sum();
			}).sum());
		}
	}
}
