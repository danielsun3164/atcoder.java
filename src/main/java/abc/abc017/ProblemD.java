package abc.abc017;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc017/submissions/2421749 を参考に作成
 */
public class ProblemD {

	private static long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] f = new int[n];
			IntStream.range(0, n).forEach(i -> f[i] = scanner.nextInt() - 1);
			// 個々の味の数の配列
			int[] taste = new int[m];
			Arrays.fill(taste, 0);
			// 結果の配列
			long[] dp = new long[n + 1];
			dp[0] = 1;
			int left = 0;
			long sum = 1;
			for (int i = 0; i < n; i++) {
				taste[f[i]]++;
				while (taste[f[i]] > 1) {
					taste[f[left]]--;
					sum = (sum - dp[left++] + MOD) % MOD;
				}
				dp[i + 1] = sum;
				sum = (sum + dp[i + 1]) % MOD;
			}
			System.out.println(dp[n]);
		}
	}
}
