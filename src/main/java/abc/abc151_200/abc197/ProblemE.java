package abc.abc151_200.abc197;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// min[i]は色iの最小値、max[i]は色iの最大値
			int[] min = new int[n + 1], max = new int[n + 1];
			Arrays.fill(min, INF);
			Arrays.fill(max, -INF);
			min[0] = max[0] = 0;
			IntStream.range(0, n).forEach(i -> {
				int x = scanner.nextInt(), c = scanner.nextInt();
				min[c] = Math.min(min[c], x);
				max[c] = Math.max(max[c], x);
			});
			// dp[i][0]は色iの最小座標まで収集した結果、dp[i][1]は色iの最大座標まで収集した結果
			long[][] dp = new long[n + 1][2];
			dp[0][0] = dp[0][1] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				if (INF == min[i]) {
					dp[i][0] = dp[i - 1][0];
					dp[i][1] = dp[i - 1][1];
					min[i] = min[i - 1];
					max[i] = max[i - 1];
				} else {
					dp[i][0] = Math.min(dp[i - 1][0] + Math.abs(max[i] - min[i - 1]) + (max[i] - min[i]),
							dp[i - 1][1] + Math.abs(max[i] - max[i - 1]) + (max[i] - min[i]));
					dp[i][1] = Math.min(dp[i - 1][0] + Math.abs(min[i] - min[i - 1]) + (max[i] - min[i]),
							dp[i - 1][1] + Math.abs(min[i] - max[i - 1]) + (max[i] - min[i]));
				}
			});
			System.out.println(Math.min(dp[n][0] + Math.abs(min[n]), dp[n][1] + Math.abs(max[n])));
		}
	}
}
