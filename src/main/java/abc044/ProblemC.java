package abc044;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通り実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int[] y = new int[n];
			int maxX = IntStream.range(0, n).map(i -> {
				int x = scanner.nextInt();
				y[i] = x - a;
				return x;
			}).max().getAsInt();
			// 回答の格納する配列
			long[][] dp = new long[n + 1][2 * n * maxX + 1];
			Arrays.fill(dp[0], 0L);
			dp[0][n * maxX] = 1L;
			IntStream.rangeClosed(1, n).forEach(j -> IntStream.range(0, 2 * n * maxX + 1).forEach(t -> {
				if (((t - y[j - 1]) >= 0) && ((t - y[j - 1]) <= 2 * n * maxX)) {
					dp[j][t] = dp[j - 1][t] + dp[j - 1][t - y[j - 1]];
				} else {
					dp[j][t] = dp[j - 1][t];
				}
			}));
			System.out.println(dp[n][n * maxX] - 1);
		}
	}
}
