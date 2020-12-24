package abc.abc051_100.abc082;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc082/submissions/7855589を参考にも作成
 */
public class ProblemD {

	/** 方向変換するときの文字 */
	private static final char TRANSFER = 'T';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int x = scanner.nextInt(), y = scanner.nextInt();
			int[][] step = new int[2][s.length / 2 + 1];
			IntStream.range(0, 2).forEach(i -> Arrays.fill(step[i], 0));
			// X軸ステップとY軸ステップ数の数
			int[] number = new int[2];
			number[0] = 0;
			number[1] = 1;
			int current = 0, count = 0;
			for (char c : s) {
				if (TRANSFER == c) {
					step[current][number[current]] = count;
					number[current]++;
					count = 0;
					current = 1 - current;
				} else {
					count++;
				}
			}
			if (count > 0) {
				step[current][number[current]] = count;
				number[current]++;
			}
			int n = s.length;
			boolean[][][] dp = new boolean[2][Math.max(number[0], number[1])][2 * n + 1];
			dp[0][0][n + step[0][0]] = dp[1][0][n] = true;
			IntStream.range(0, 2)
					.forEach(i -> IntStream.range(1, number[i])
							.forEach(j -> IntStream.range(0, 2 * n + 1)
									.forEach(k -> dp[i][j][k] = ((k - step[i][j] >= 0) && dp[i][j - 1][k - step[i][j]])
											|| ((k + step[i][j] <= 2 * n) && dp[i][j - 1][k + step[i][j]]))));
			System.out.println((dp[0][number[0] - 1][n + x] && dp[1][number[1] - 1][n + y]) ? "Yes" : "No");
		}
	}
}
