package abc.abc201_250.abc225;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc225/editorial/2833 の実装
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			String[] s = IntStream.range(0, n).mapToObj(i -> scanner.next()).sorted((x, y) -> (x + y).compareTo(y + x))
					.toArray(String[]::new);
			String[][] dp = new String[n + 1][k + 1];
			IntStream.range(0, n + 1).forEach(i -> Arrays.fill(dp[i], "{"));
			dp[n][0] = "";
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> IntStream.rangeClosed(0, k).forEach(j -> {
				dp[i][j] = min(dp[i][j], dp[i + 1][j]);
				if (j > 0) {
					dp[i][j] = min(dp[i][j], s[i] + dp[i + 1][j - 1]);
				}
			}));
			System.out.println(dp[0][k]);
		}
	}

	/**
	 * aとbの最小値を返す
	 *
	 * @param a 文字列
	 * @param b 文字列
	 * @return aとbの最小値
	 */
	private static String min(String a, String b) {
		return (a.compareTo(b) < 0) ? a : b;
	}
}
