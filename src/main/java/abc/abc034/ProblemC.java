package abc.abc034;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			System.out.println(factorialMod(w + h - 2) * powMod(factorialMod(h - 1), MOD - 2) % MOD
					* powMod(factorialMod(w - 1), MOD - 2) % MOD);
		}
	}

	/**
	 * @param n
	 * @return nの階乗mod MOD
	 */
	private static long factorialMod(long n) {
		long result = 1L;
		for (int i = 2; i <= n; i++) {
			result = result * i % MOD;
		}
		return result;
	}

	/**
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (m & 1)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
