package abc.abc151_200.abc178;

import java.util.Scanner;

public class ProblemC {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(((modPow(10, n) - modPow(9, n) * 2 % MOD + modPow(8, n)) % MOD + MOD) % MOD);
		}
	}

	/**
	 * n^m mod MOD を計算する
	 * 
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long modPow(long n, long m) {
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
