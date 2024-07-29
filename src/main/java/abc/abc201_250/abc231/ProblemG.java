package abc.abc201_250.abc231;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc231/editorial/3096 の実装<br/>
 * https://atcoder.jp/contests/abc231/submissions/27849116 にも参考
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[][] dp = new long[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			IntStream.range(0, n).forEach(i -> {
				long a = scanner.nextLong();
				IntStream.rangeClosed(0, i).forEach(j -> {
					dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j] * a % MOD) % MOD;
					dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
				});
			});
			System.out.println(IntStream.rangeClosed(0, n).filter(i -> k - n + i >= 0)
					.mapToLong(i -> LongStream.range(0, n - i).map(j -> k - j).reduce(1L, (s, j) -> s * j % MOD)
							* dp[n][i] % MOD * powMod(powMod(n, n - i), MOD - 2) % MOD)
					.sum() % MOD);
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
