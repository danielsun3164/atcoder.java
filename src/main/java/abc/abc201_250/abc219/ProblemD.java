package abc.abc201_250.abc219;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			int[][] dp = new int[x + 1][y + 1];
			IntStream.rangeClosed(0, x).forEach(i -> Arrays.fill(dp[i], INF));
			dp[0][0] = 0;
			IntStream.range(0, n).forEach(i -> {
				IntStream.rangeClosed(0, x).map(j -> x - j)
						.forEach(j -> IntStream.rangeClosed(0, y).map(k -> y - k).filter(k -> INF != dp[j][k])
								.forEach(k -> dp[Math.min(x, j + a[i])][Math.min(y, k + b[i])] = Math
										.min(dp[Math.min(x, j + a[i])][Math.min(y, k + b[i])], dp[j][k] + 1)));
			});
			System.out.println((INF == dp[x][y]) ? -1 : dp[x][y]);
		}
	}
}
