package abc.abc201_250.abc242;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc242/editorial/3597 の実装<br/>
 * https://atcoder.jp/contests/abc242/submissions/30186571 にも参考
 */
public class ProblemEx別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), nm = Math.max(n, m);
			int[] l = new int[m], r = new int[m];
			IntStream.range(0, m).forEach(i -> {
				l[i] = scanner.nextInt() - 1;
				r[i] = scanner.nextInt();
			});
			int[][] count = new int[n + 1][n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(count[i], 0));
			IntStream.range(0, n).forEach(i -> IntStream.rangeClosed(i, n)
					.forEach(j -> count[i][j] += IntStream.range(0, m).filter(k -> l[k] >= i && r[k] <= j).count()));
			long[][][] dp = new long[nm + 2][nm + 2][2];
			IntStream.range(0, nm + 2).forEach(i -> IntStream.range(0, nm + 2).forEach(j -> Arrays.fill(dp[i][j], 0L)));
			dp[0][0][0] = 1L;
			IntStream.rangeClosed(0, n + 1)
					.forEach(i -> IntStream.range(0, i)
							.forEach(la -> IntStream.rangeClosed(0, m)
									.forEach(k -> IntStream.range(0, 2).filter(f -> dp[la][k][f] != 0L)
											.forEach(f -> dp[i][k + count[la][i - 1]][f
													^ 1] = (dp[i][k + count[la][i - 1]][f ^ 1] + dp[la][k][f])
															% MOD))));
			System.out.println(IntStream.range(0, m).mapToLong(k -> IntStream.range(0, 2).mapToLong(
					f -> (MOD + ((f > 0) ? -1 : 1) * dp[n + 1][k][f] * m % MOD * powMod(m - k, MOD - 2) % MOD) % MOD)
					.sum() % MOD).sum() % MOD);
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
