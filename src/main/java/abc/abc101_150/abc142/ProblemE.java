package abc.abc101_150.abc142;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m], c = new int[m];
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt();
				c[i] = IntStream.range(0, scanner.nextInt()).map(j -> 1 << (scanner.nextInt() - 1)).sum();
			});
			int[][] dp = new int[m + 1][1 << n];
			IntStream.rangeClosed(0, m).forEach(i -> Arrays.fill(dp[i], INF));
			dp[0][0] = 0;
			IntStream.rangeClosed(1, m).forEach(i -> IntStream.range(0, 1 << n).forEach(j -> {
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
				dp[i][j | c[i - 1]] = Math.min(dp[i][j | c[i - 1]], dp[i - 1][j] + a[i - 1]);
			}));
			System.out.println((INF == dp[m][(1 << n) - 1]) ? -1 : dp[m][(1 << n) - 1]);
		}
	}
}
