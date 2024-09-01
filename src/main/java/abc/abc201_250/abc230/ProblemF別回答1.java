package abc.abc201_250.abc230;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc230/editorial/3034 の実装<br/>
 * https://atcoder.jp/contests/abc230/submissions/27665738 にも参考
 */
public class ProblemF別回答1 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n + 1];
			a[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = scanner.nextLong());
			long sum = 0L;
			int[] f = new int[n + 1];
			Map<Long, Integer> map = new HashMap<>();
			for (int i = 0; i <= n; i++) {
				sum += a[i];
				f[i] = map.getOrDefault(sum, 0);
				map.put(sum, i);
			}
			long[] dp = new long[n + 1];
			dp[0] = 0L;
			dp[1] = 1L;
			IntStream.range(1, n).forEach(i -> dp[i + 1] = (dp[i] * 2 - dp[f[i]] + MOD) % MOD);
			System.out.println(dp[n]);
		}
	}
}
