package abc.abc151_200.abc189;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** ANDを表す文字列 */
	private static final String AND = "AND";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String[] s = IntStream.range(0, n).mapToObj(i -> scanner.next()).toArray(String[]::new);
			// dp[i][0]はi番目の計算後、結果がfalseとなるようなものの個数
			// dp[i][1]はi番目の計算後、結果がtrueとなるようなものの個数
			long[][] dp = new long[n + 1][2];
			dp[0][0] = dp[0][1] = 1L;
			IntStream.range(0, n).forEach(i -> {
				if (AND.equals(s[i])) {
					dp[i + 1][0] = dp[i][0] * 2L + dp[i][1];
					dp[i + 1][1] = dp[i][1];
				} else {
					dp[i + 1][0] = dp[i][0];
					dp[i + 1][1] = dp[i][0] + dp[i][1] * 2L;
				}
			});
			System.out.println(dp[n][1]);
		}
	}
}
