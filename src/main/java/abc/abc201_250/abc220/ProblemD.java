package abc.abc201_250.abc220;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 10 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long[][] dp = new long[n][N];
			IntStream.range(0, n).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][a[0]] = 1L;
			IntStream.range(1, n).forEach(i -> IntStream.range(0, N).filter(j -> dp[i - 1][j] > 0).forEach(j -> {
				dp[i][(j + a[i]) % N] = (dp[i][(j + a[i]) % N] + dp[i - 1][j]) % MOD;
				dp[i][(j * a[i]) % N] = (dp[i][(j * a[i]) % N] + dp[i - 1][j]) % MOD;
			}));
			IntStream.range(0, N).mapToLong(i -> dp[n - 1][i]).forEach(System.out::println);
		}
	}
}
