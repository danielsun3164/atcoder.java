package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem020 {

	/** 目標カードの枚数 */
	private static final int N = 5;
	/** 目標値 */
	private static final int MAX = 1000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[][] dp = new int[N + 1][MAX + 1];
			IntStream.rangeClosed(0, N).forEach(i -> Arrays.fill(dp[i], 0));
			dp[0][0] = 1;
			IntStream.range(0, n).forEach(
					i -> IntStream.range(0, N).map(j -> N - 1 - j).forEach(j -> IntStream.rangeClosed(0, MAX - a[i])
							.filter(k -> dp[j][k] > 0).forEach(k -> dp[j + 1][k + a[i]] += dp[j][k])));
			System.out.println(dp[N][MAX]);
		}
	}
}
