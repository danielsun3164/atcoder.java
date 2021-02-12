package other.joisc2007;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD_Building {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// dp[i][j]はi番目のビルを処理して、最後のビルがj番目のビルの場合の最大値
			int[][] dp = new int[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(dp[i], 1));
			IntStream.range(1, n).forEach(i -> {
				dp[i][i] = dp[i - 1][i];
				IntStream.range(0, i).forEach(j -> {
					dp[i][j] = dp[i - 1][j];
					dp[i][i] = Math.max(dp[i][i], (a[i] > a[j]) ? dp[i - 1][j] + 1 : 0);
				});
			});
			System.out.println(Arrays.stream(dp[n - 1]).max().getAsInt());
		}
	}
}
