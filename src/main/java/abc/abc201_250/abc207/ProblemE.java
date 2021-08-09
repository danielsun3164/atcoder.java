package abc.abc201_250.abc207;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** modの対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n], sum = new long[n + 1];
			sum[0] = 0L;
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextLong();
				sum[i + 1] = sum[i] + a[i];
			});
			long[][] dp = new long[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], 0L));
			IntStream.rangeClosed(1, n).forEach(i -> dp[i][1] = 1L);
			IntStream.rangeClosed(2, n).forEach(j -> {
				long[] tempSums = new long[j];
				Arrays.fill(tempSums, 0L);
				tempSums[(int) (sum[j - 1] % j)] = dp[j - 1][j - 1];
				IntStream.rangeClosed(j, n).forEach(i -> {
					int remainder = (int) (sum[i] % j);
					dp[i][j] = tempSums[remainder];
					tempSums[remainder] = (tempSums[remainder] + dp[i][j - 1]) % MOD;
				});
			});
			System.out.println(IntStream.rangeClosed(1, n).mapToLong(i -> dp[n][i]).sum() % MOD);
		}
	}
}
