package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem042 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			if (0 != (k % 9)) {
				System.out.println(0);
				return;
			}
			long[] dp = new long[k + 10];
			Arrays.fill(dp, 0L);
			dp[0] = 1L;
			IntStream.range(0, k)
					.forEach(i -> IntStream.rangeClosed(1, 9).forEach(j -> dp[i + j] = (dp[i + j] + dp[i]) % MOD));
			System.out.println(dp[k]);
		}
	}
}
