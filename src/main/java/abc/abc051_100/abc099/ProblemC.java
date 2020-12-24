package abc.abc051_100.abc099;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 引き出しのできる数字 */
	private static final int[] NUMBERS = new int[] { 1, 6, 9 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// dp[i]は金額iを引き出すのに必要な最小回数
			int[] dp = new int[n + 1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			IntStream.rangeClosed(1, n).forEach(i -> {
				for (int number : NUMBERS) {
					int current = number;
					while (i >= current) {
						dp[i] = Math.min(dp[i], dp[i - current] + 1);
						if (number > 1) {
							current *= number;
						} else {
							break;
						}
					}
				}
			});
			System.out.println(dp[n]);
		}
	}
}
