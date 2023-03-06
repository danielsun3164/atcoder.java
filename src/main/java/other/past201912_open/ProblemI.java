package other.past201912_open;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemI {

	/** 大きい値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] s = new int[m], c = new int[m];
			IntStream.range(0, m).forEach(i -> {
				s[i] = Integer.parseInt(scanner.next().replaceAll("Y", "1").replaceAll("N", "0"), 2);
				c[i] = scanner.nextInt();
			});
			// 2のn乗
			int pow = (1 << n);
			long[][] dp = new long[m + 1][pow];
			Arrays.fill(dp[0], INF);
			dp[0][0] = 0L;
			IntStream.range(0, m).forEach(i -> {
				IntStream.range(0, pow).forEach(j -> dp[i + 1][j] = dp[i][j]);
				IntStream.range(0, pow)
						.forEach(j -> dp[i + 1][j | s[i]] = Math.min(dp[i + 1][j | s[i]], dp[i][j] + c[i]));
			});
			System.out.println((dp[m][pow - 1] >= INF) ? -1L : dp[m][pow - 1]);
		}
	}
}
