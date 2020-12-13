package abc.abc185;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			int[][] dp = new int[n + 1][m + 1];
			IntStream.rangeClosed(0, n).forEach(i -> dp[i][0] = i);
			IntStream.rangeClosed(0, m).forEach(i -> dp[0][i] = i);
			IntStream.range(0, n)
					.forEach(i -> IntStream.range(0, m).forEach(j -> dp[i + 1][j + 1] = min(dp[i][j + 1] + 1,
							dp[i + 1][j] + 1, dp[i][j] + ((a[i] == b[j]) ? 0 : 1))));
			System.out.println(dp[n][m]);
		}
	}

	/**
	 * intの配列の最小値を計算する
	 * 
	 * @param d intの配列
	 * @return intの配列の最小値
	 */
	private static int min(int... d) {
		return Arrays.stream(d).min().getAsInt();
	}
}
