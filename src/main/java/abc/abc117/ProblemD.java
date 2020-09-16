package abc.abc117;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc117/submissions/15074397 にも参考
 */
public class ProblemD {

	/** kの最大桁数 */
	private static final int N = 40;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			int[] c = new int[N];
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			Arrays.stream(a).forEach(ai -> IntStream.range(0, N).forEach(j -> c[j] += ((ai & (1L << j)) > 0) ? 1 : 0));
			// dp[0]はxはkより小さい、dp[1]はxとkは同じ
			long[][] dp = new long[2][N + 1];
			IntStream.range(0, 2).forEach(i -> Arrays.fill(dp[i], -1L));
			dp[1][N] = 0;
			IntStream.rangeClosed(1, N).map(i -> N - i).forEach(i -> {
				long power = 1L << i;
				// x_iが1の場合はturnOn、0の場合はturnOff
				long turnOn = (n - c[i]) * power, turnOff = c[i] * power;
				if (dp[0][i + 1] >= 0) {
					dp[0][i] = dp[0][i + 1] + Math.max(turnOff, turnOn);
				}
				if ((k & power) > 0) {
					dp[0][i] = Math.max(dp[0][i], dp[1][i + 1] + turnOff);
					dp[1][i] = dp[1][i + 1] + turnOn;
				} else {
					dp[1][i] = dp[1][i + 1] + turnOff;
				}
			});
			System.out.println(Math.max(dp[0][0], dp[1][0]));
		}
	}
}
