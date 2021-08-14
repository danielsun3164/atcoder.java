package abc.abc201_250.abc209;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc209/submissions/24099043 にも参考
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] h = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long[][] dp = new long[2][];
			dp[0] = new long[n];
			Arrays.fill(dp[0], 0L);
			dp[0][0] = 1L;
			IntStream.range(0, n - 1).forEach(i -> {
				dp[1] = new long[n];
				Arrays.fill(dp[1], 0L);
				if (h[i] < h[i + 1]) {
					long sum = 0L;
					for (int j = 0; j < i + 2; j++) {
						dp[1][j] = sum;
						sum = (sum + dp[0][j]) % MOD;
					}
				} else if (h[i] > h[i + 1]) {
					long sum = 0L;
					for (int j = i + 1; j >= 0; j--) {
						dp[1][j] = sum = (sum + dp[0][j]) % MOD;
					}
				} else {
					long sum = IntStream.range(0, i + 1).mapToLong(j -> dp[0][j]).sum() % MOD;
					Arrays.fill(dp[1], 0, i + 2, sum);
				}
				dp[0] = dp[1];
			});
			System.out.println(IntStream.range(0, n).mapToLong(i -> dp[0][i]).sum() % MOD);
		}
	}
}
