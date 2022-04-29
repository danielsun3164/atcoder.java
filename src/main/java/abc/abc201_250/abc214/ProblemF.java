package abc.abc201_250.abc214;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	/** 英小文字の数 */
	private static final int N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int n = s.length;
			long[] dp = new long[n + 1];
			Arrays.fill(dp, 0L);
			// sum[i]は文字(i+'a')のこれまでのdpの合計値
			long[] sum = new long[N];
			Arrays.fill(sum, 1L);
			IntStream.range(0, n).forEach(i -> {
				dp[i + 1] = (dp[i + 1] + sum[s[i] - 'a']) % MOD;
				sum[s[i] - 'a'] = 0L;
				IntStream.range(0, N).forEach(j -> sum[j] = (sum[j] + dp[i]) % MOD);
			});
			System.out.println(Arrays.stream(dp).sum() % MOD);
		}
	}
}
