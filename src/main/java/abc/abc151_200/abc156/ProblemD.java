package abc.abc151_200.abc156;

import java.util.Scanner;

public class ProblemD {

	/** mod対象 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((powMod(2, n) + 3 * MOD - cMod(n, a) - cMod(n, b) - 1L) % MOD);
		}
	}

	/**
	 * n^m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0L) {
			if (1L == (1L & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}

	/**
	 * n_C_m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n_C_m mod MOD
	 */
	private static long cMod(int n, int m) {
		long result = 1L, result2 = 1L;
		for (int i = 0; i < m; i++) {
			result = result * (n - i) % MOD;
			result2 = result2 * (i + 1) % MOD;
		}
		return result * powMod(result2, MOD - 2) % MOD;
	}
}
