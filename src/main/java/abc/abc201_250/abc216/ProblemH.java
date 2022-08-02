package abc.abc201_250.abc216;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc216/editorial/2561 の解説の実装
 */
public class ProblemH {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt(), n = scanner.nextInt(), p = 1 << k;
			int[] x = IntStream.range(0, k).map(i -> scanner.nextInt() + 1).toArray();
			int xMax = Arrays.stream(x).max().getAsInt() + n + 1;
			long[] fact = new long[xMax], invFact = new long[xMax];
			fact[0] = 1L;
			IntStream.range(1, xMax).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[xMax - 1] = powMod(fact[xMax - 1], MOD - 2);
			IntStream.range(1, xMax).map(i -> xMax - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			long[][] dp = new long[xMax][p];
			IntStream.range(0, xMax).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			IntStream.range(1, xMax).forEach(i -> IntStream.range(0, p).forEach(j -> {
				IntStream.range(0, k).forEach(l -> {
					if (0 == (j & (1 << l))) {
						int mem = (p - 1 - ((1 << l) - 1)) & j;
						if (1 == (Integer.bitCount(mem) & 1)) {
							dp[i][j + (1 << l)] = (dp[i][j + (1 << l)]
									- dp[i - 1][j] * binom(fact, invFact, n, i - x[l]) % MOD + MOD) % MOD;
						} else {
							dp[i][j + (1 << l)] = (dp[i][j + (1 << l)]
									+ dp[i - 1][j] * binom(fact, invFact, n, i - x[l]) % MOD) % MOD;
						}
					}
				});
				dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
			}));
			System.out.println(dp[xMax - 1][p - 1] * powMod(powMod(2, k * n), MOD - 2) % MOD);
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
	 * n_C_r mod MODを計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param n
	 * @param r
	 * @return n_C_r mod MOD
	 */
	private static long binom(long[] fact, long[] invFact, int n, int r) {
		if ((n < 0) || (r < 0) || (n < r)) {
			return 0L;
		}
		return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
	}
}
