package abc.abc201_250.abc234;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc234/editorial/3227 の実装
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] dp = new long[n + 1];
			Arrays.fill(dp, 0L);
			dp[0] = 1L;
			Deque<Long> max = new ArrayDeque<>(), min = new ArrayDeque<>(), maxV = new ArrayDeque<>(),
					minV = new ArrayDeque<>();
			long maxSum = 0L, minSum = 0L;
			for (int i = 0; i < n; i++) {
				{
					long sumV = dp[i];
					while (!max.isEmpty() && (max.peekLast() < a[i])) {
						maxSum = (maxSum + MOD - maxV.peekLast() * max.pollLast() % MOD) % MOD;
						sumV = (sumV + maxV.pollLast()) % MOD;
					}
					maxSum = (maxSum + sumV * a[i] % MOD) % MOD;
					max.addLast(a[i]);
					maxV.addLast(sumV);
				}
				{
					long sumV = dp[i];
					while (!min.isEmpty() && (min.peekLast() > a[i])) {
						minSum = (minSum + MOD - minV.peekLast() * min.pollLast() % MOD) % MOD;
						sumV = (sumV + minV.pollLast()) % MOD;
					}
					minSum = (minSum + sumV * a[i] % MOD) % MOD;
					min.addLast(a[i]);
					minV.addLast(sumV);
				}
				dp[i + 1] = (maxSum - minSum + MOD) % MOD;
			}
			System.out.println(dp[n]);
		}
	}
}
