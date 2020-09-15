package abc.abc015;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc015/submissions/5427382 を参考に作成
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt(), n = scanner.nextInt(), k = scanner.nextInt();
			int[] widths = new int[n], importances = new int[n];
			IntStream.range(0, n).forEach(i -> {
				widths[i] = scanner.nextInt();
				importances[i] = scanner.nextInt();
			});
			int[][][] dp = new int[n + 1][k + 1][w + 1];
			IntStream.range(0, n)
					.forEach(i -> IntStream.rangeClosed(1, k).forEach(j -> IntStream.rangeClosed(1, w).forEach(l -> {
						dp[i + 1][j][l] = dp[i][j][l];
						if (l >= widths[i]) {
							dp[i + 1][j][l] = Math.max(dp[i][j][l], dp[i][j - 1][l - widths[i]] + importances[i]);
						}
					})));
			System.out.println(dp[n][k][w]);
		}
	}
}
