package abc.abc101_150.abc113;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), k = scanner.nextInt() - 1;
			long[][] dp = new long[h + 1][w];
			dp[0][0] = 1L;
			long[] factorial = new long[w], revFactorial = new long[w];
			factorial[0] = 1L;
			IntStream.range(1, w).forEach(i -> factorial[i] = factorial[i - 1] * i % MOD);
			revFactorial[w - 1] = modPow(factorial[w - 1], MOD - 2);
			IntStream.range(0, w - 1).map(i -> w - 2 - i)
					.forEach(i -> revFactorial[i] = revFactorial[i + 1] * (i + 1) % MOD);
			IntStream.rangeClosed(1, h).forEach(i -> IntStream.range(0, w).forEach(j -> {
				dp[i][j] += dp[i - 1][j] * calc(j, factorial, revFactorial) % MOD
						* calc(w - 1 - j, factorial, revFactorial) % MOD;
				dp[i][j] %= MOD;
				if (j > 0) {
					dp[i][j] += dp[i - 1][j - 1] * calc(j - 1, factorial, revFactorial) % MOD
							* calc(w - 1 - j, factorial, revFactorial) % MOD;
					dp[i][j] %= MOD;
				}
				if (j < w - 1) {
					dp[i][j] += dp[i - 1][j + 1] * calc(j, factorial, revFactorial) % MOD
							* calc(w - 2 - j, factorial, revFactorial) % MOD;
					dp[i][j] %= MOD;
				}
			}));
			System.out.println(dp[h][k]);
		}
	}

	/**
	 * ( n_C_0 + (n-1)_C_1 + ... + (n-n/2)_C_(n/2) ) mod MODを計算する
	 * 
	 * @param n
	 * @param factorial    階乗の配列
	 * @param revFactorial 逆階乗の配列
	 * @return ( n_C_0 + (n-1)_C_1 + ... + (n-n/2)_C_(n/2) ) mod MOD
	 */
	private static long calc(int n, long[] factorial, long[] revFactorial) {
		long result = 0L;
		for (int i = 0; i <= n / 2; i++) {
			result += factorial[n - i] * revFactorial[i] % MOD * revFactorial[n - 2 * i] % MOD;
			result %= MOD;
		}
		return result;
	}

	/**
	 * n^m mod MODを計算する
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
