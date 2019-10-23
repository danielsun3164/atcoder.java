package abc065;

import java.util.Scanner;

public class ProblemC {

	/** MOD */
	private static long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			if (Math.abs(n - m) > 1) {
				System.out.println(0);
			} else {
				System.out.println(fractorialMod(n) * fractorialMod(m) % MOD * ((n == m) ? 2L : 1L) % MOD);
			}
		}
	}

	/**
	 * @param n 入力数字
	 * @return 入力数字の階乗 mod MOD
	 */
	private static long fractorialMod(int n) {
		long result = 1L;
		for (int i = 2; i <= n; i++) {
			result = result * i % MOD;
		}
		return result;
	}
}
