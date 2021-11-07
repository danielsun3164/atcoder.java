package abc.abc001_050.abc007;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * 動的計画法の実装
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong();
			System.out.println(calcResult(b) - calcResult(a - 1));
		}
	}

	/**
	 * @param input 入力数字
	 * @return 1〜inputまでの禁止文字を含む数字の数
	 */
	private static long calcResult(long input) {
		char[] s = String.valueOf(input).toCharArray();
		int n = s.length;
		long[] dp = new long[n + 1];
		dp[0] = 0L;
		// 入力数字に4か9が含まれるかどうか
		boolean ok = true;
		for (int i = 0; i < n; i++) {
			int digit = s[i] - '0';
			dp[i + 1] = dp[i] * 8;
			if (ok) {
				dp[i + 1] += (digit > 4) ? digit - 1 : digit;
			}
			if ((4 == digit) || (9 == digit)) {
				ok = false;
			}
		}
		return input + 1 - dp[n] - (ok ? 1 : 0);
	}
}
