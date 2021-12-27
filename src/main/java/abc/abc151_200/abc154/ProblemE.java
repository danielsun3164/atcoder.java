package abc.abc151_200.abc154;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	/** 10進数 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] n = scanner.next().toCharArray();
			int k = scanner.nextInt(), l = n.length;
			long[][][] dp = new long[l + 1][2][k + 2];
			Arrays.stream(dp).forEach(dpi -> Arrays.stream(dpi).forEach(dpii -> Arrays.fill(dpii, 0L)));
			dp[0][0][0] = 1L;
			IntStream.range(0, l).forEach(i -> {
				int digit = n[i] - '0';
				IntStream.range(0, 2)
						.forEach(less -> IntStream.rangeClosed(0, k)
								.forEach(j -> IntStream.range(0, N).filter(next -> (next <= digit) || (1 == less))
										.forEach(next -> dp[i + 1][(next < digit) ? 1 : less][(0 != next) ? j + 1
												: j] += dp[i][less][j])));
			});
			System.out.println(dp[l][0][k] + dp[l][1][k]);
		}
	}
}
