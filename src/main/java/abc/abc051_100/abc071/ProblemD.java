package abc.abc051_100.abc071;

import java.util.Scanner;

public class ProblemD {

	private static final long MOD = 1_000_000_007L;

	/** 現在の縦、横と以前の縦、横による組合せ数の配列 */
	private static final int[][] counts = { { 3, 2, 1 }, { 6, 2, 3 } };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s1 = scanner.next().toCharArray();
			char[] s2 = scanner.next().toCharArray();
			int i = 0, prev = 0;
			long result = 1L;
			while (i < n) {
				if (s1[i] == s2[i]) {
					// 縦の並び
					result = result * counts[0][prev] % MOD;
					prev = 1;
					i++;
				} else {
					// 横の並び
					result = result * counts[1][prev] % MOD;
					prev = 2;
					i += 2;
				}
			}
			System.out.println(result);
		}
	}
}
