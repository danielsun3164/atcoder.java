package other.typical90;

import java.util.Scanner;

public class Problem069 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), k = scanner.nextLong();
			if (1L == n) {
				System.out.println(k);
			} else {
				System.out.println(k * (k - 1) % MOD * powMod(k - 2, n - 2) % MOD);
			}
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
}
