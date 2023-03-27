package abc.abc201_250.abc217;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc217/editorial/2584 の実装
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), n2 = n << 1;
			boolean[][] ok = new boolean[n2][n2];
			IntStream.range(0, n2).forEach(i -> Arrays.fill(ok[i], false));
			long[] fact = new long[n2 + 1], invFact = new long[n2 + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n2).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[n2] = powMod(fact[n2], MOD - 2);
			IntStream.range(0, n2).map(i -> n2 - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				ok[a][b] = ok[b][a] = true;
			});
			long[][] dp = new long[n2 + 1][n + 1];
			IntStream.rangeClosed(0, n2).forEach(i -> dp[i][0] = 1L);
			IntStream.rangeClosed(1, n).forEach(j -> IntStream.range(0, 2 * (n - j) + 1).forEach(i -> {
				dp[i][j] = 0L;
				IntStream.range(0, j).filter(k -> ok[i][i + 2 * k + 1])
						.forEach(k -> dp[i][j] = (dp[i][j] + dp[i + 1][k] * dp[i + 2 * k + 2][j - k - 1] % MOD * fact[j]
								% MOD * invFact[j - k - 1] % MOD * invFact[k + 1] % MOD) % MOD);
			}));
			System.out.println(dp[0][n]);
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
		while (m > 0) {
			if (1 == (1 & m)) {
				result = (result * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return result;
	}
}
