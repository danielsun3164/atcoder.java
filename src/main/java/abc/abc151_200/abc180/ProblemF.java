package abc.abc151_200.abc180;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc180/submissions/17489940 にも参考
 */
public class ProblemF {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), l = scanner.nextInt();
			long[] fact = new long[n + 1], invFact = new long[n + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[n] = powMod(fact[n], MOD - 2);
			IntStream.rangeClosed(1, n).map(i -> n - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			System.out.println((f(n, m, l, fact, invFact) - f(n, m, l - 1, fact, invFact) + MOD) % MOD);
		}
	}

	/**
	 * N 頂点 M 辺のグラフの各連結成分のサイズが最大Lのグラフの数を計算する
	 * 
	 * @param n
	 * @param m
	 * @param l
	 * @param fact
	 * @param invFact
	 * @return N 頂点 M 辺のグラフの各連結成分のサイズが最大Lのグラフの数
	 */
	private static long f(final int n, final int m, final int l, final long[] fact, final long[] invFact) {
		long[][] dp = new long[n + 1][m + 1];
		IntStream.rangeClosed(1, n).forEach(i -> Arrays.fill(dp[i], 0L));
		dp[0][0] = 1L;
		IntStream.rangeClosed(1, n).forEach(i -> IntStream.rangeClosed(0, m).forEach(j -> {
			IntStream.rangeClosed(1, l).forEach(k -> {
				if (1 == k) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
				}
				if ((k >= 2) && (i - k >= 0) && (j - k + 1 >= 0)) {
					dp[i][j] = (dp[i][j] + dp[i - k][j - k + 1] * fact[n - (i - k) - 1] % MOD * invFact[k - 1] % MOD
							* invFact[n - i] % MOD * fact[k] % MOD * invFact[2] % MOD) % MOD;
				}
				if ((2 == k) && (i - k >= 0) && (j - k >= 0)) {
					dp[i][j] = (dp[i][j] + dp[i - k][j - k] * (n - (i - k) - 1) % MOD) % MOD;
				}
				if ((k >= 3) && (i - k >= 0) && (j - k >= 0)) {
					dp[i][j] = (dp[i][j] + dp[i - k][j - k] * fact[n - (i - k) - 1] % MOD * invFact[k - 1] % MOD
							* invFact[n - i] % MOD * fact[k - 1] % MOD * invFact[2] % MOD) % MOD;
				}
			});
		}));
		return dp[n][m];
	}

	/**
	 * x^n mod MOD を計算する
	 * 
	 * @param x
	 * @param n
	 * @return x^n mod MOD
	 */
	private static long powMod(long x, long n) {
		long r = 1L, y = x % MOD;
		while (n > 0L) {
			if (1L == (n & 1L)) {
				r = r * y % MOD;
			}
			y = y * y % MOD;
			n >>= 1;
		}
		return r;
	}
}
