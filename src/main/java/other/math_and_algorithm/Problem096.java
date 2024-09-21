package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem096 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] t = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int tSum = Arrays.stream(t).sum();
			boolean[][] dp = new boolean[2][tSum + 1];
			Arrays.fill(dp[0], false);
			dp[0][0] = true;
			IntStream.range(0, n).forEach(i -> {
				System.arraycopy(dp[1 & i], 0, dp[1 & (i + 1)], 0, t[i]);
				IntStream.rangeClosed(t[i], tSum)
						.forEach(j -> dp[1 & (i + 1)][j] = dp[1 & i][j - t[i]] || dp[1 & i][j]);
			});
			System.out.println(IntStream.rangeClosed(0, tSum / 2).filter(i -> dp[1 & n][i])
					.map(i -> Math.max(i, tSum - i)).min().getAsInt());
		}
	}
}
