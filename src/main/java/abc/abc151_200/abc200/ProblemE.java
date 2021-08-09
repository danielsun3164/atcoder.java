package abc.abc151_200.abc200;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			long[][] dp = new long[N + 1][(N * n) + 2];
			dp[0][0] = 1L;
			IntStream.range(0, N).forEach(i -> {
				IntStream.rangeClosed(0, i * n).forEach(j -> {
					dp[i + 1][j + 1] += dp[i][j];
					dp[i + 1][j + n + 1] -= dp[i][j];
				});
				IntStream.range(1, ((i + 1) * n) + 2).forEach(j -> dp[i + 1][j] += dp[i + 1][j - 1]);
			});
			int sum;
			for (sum = N; sum <= (N * n); sum++) {
				if (k <= dp[N][sum]) {
					break;
				}
				k -= dp[N][sum];
			}
			int[] ans = new int[N];
			for (int i = 0; i < (N - 1); i++) {
				for (int j = 1; j <= n; j++) {
					if (k <= dp[N - 1 - i][sum - j]) {
						ans[i] = j;
						sum -= j;
						break;
					}
					k -= dp[N - 1 - i][sum - j];
				}
			}
			ans[N - 1] = sum;
			System.out.println(Arrays.stream(ans).mapToObj(ai -> String.valueOf(ai)).collect(Collectors.joining(" ")));
		}
	}
}
