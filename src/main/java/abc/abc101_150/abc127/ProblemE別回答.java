package abc.abc101_150.abc127;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * 解説に書かれた合計式を展開した計算方法
 */
public class ProblemE別回答 {

	private static final long MOD = 1_000_000_007;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			// 1からnまでのi*(n-i)は (n^3-n)/6
			long xSum = (powMod(n, 3) - n + MOD) % MOD * powMod(6, MOD - 2) % MOD * m % MOD * m % MOD;
			long ySum = (powMod(m, 3) - m + MOD) % MOD * powMod(6, MOD - 2) % MOD * n % MOD * n % MOD;
			System.out.println((xSum + ySum) % MOD * combinationMod(n * m - 2, k - 2) % MOD);
		}
	}

	/**
	 * n_C_m mod MOD を計算する
	 * 
	 * @param n
	 * @param m
	 * @return n_C_m mod MOD
	 */
	private static long combinationMod(long n, int m) {
		long min = Math.min(m, n - m), max = Math.max(m, n - m);
		long factorialMin = LongStream.rangeClosed(1, min).reduce(1L, (result, next) -> result * next % MOD);
		long factorialMax = LongStream.rangeClosed(min + 1, max).reduce(factorialMin,
				(result, next) -> result * next % MOD);
		long factorialN = LongStream.rangeClosed(max + 1, n).reduce(factorialMax,
				(result, next) -> result * next % MOD);
		return factorialN * powMod(factorialMin, MOD - 2) % MOD * powMod(factorialMax, MOD - 2) % MOD;
	}

	/**
	 * n^m mod MOD を計算する
	 * 
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
