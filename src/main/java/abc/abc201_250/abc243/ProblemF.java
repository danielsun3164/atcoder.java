package abc.abc201_250.abc243;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc243/editorial/3508 の実装<br/>
 * https://atcoder.jp/contests/abc243/submissions/30016689 にも参考
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 階乗、逆階乗の配列 */
	private static long[] fact, invFact;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			initFact(k);
			long[] w = new long[n];
			long wSum = IntStream.range(0, n).mapToLong(i -> w[i] = scanner.nextLong()).sum();
			long invWSum = powMod(wSum, MOD - 2);
			long[] p = IntStream.range(0, n).mapToLong(i -> w[i] * invWSum % MOD).toArray();
			long[][][] dp = new long[n + 1][m + 2][k + 1];
			IntStream.rangeClosed(0, n).forEach(i -> IntStream.range(0, m + 2).forEach(j -> Arrays.fill(dp[i][j], 0L)));
			dp[0][0][0] = 1L;
			IntStream.range(0, n).forEach(x -> IntStream.rangeClosed(0, m)
					.forEach(y -> IntStream.rangeClosed(0, k).forEach(z -> IntStream.rangeClosed(0, k - z).forEach(
							c -> dp[x + 1][y + ((c != 0) ? 1 : 0)][z + c] = (dp[x + 1][y + ((c != 0) ? 1 : 0)][z + c]
									+ dp[x][y][z] * invFact[c] % MOD * powMod(p[x], c) % MOD) % MOD))));
			System.out.println(dp[n][m][k] * fact[k] % MOD);
		}
	}

	/**
	 * 階乗、逆階乗の配列の初期化
	 *
	 * @param n 配列の最大サイズ
	 */
	private static void initFact(int n) {
		fact = new long[n + 1];
		fact[0] = 1L;
		IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
		invFact = new long[n + 1];
		invFact[n] = powMod(fact[n], MOD - 2);
		IntStream.iterate(n - 1, i -> i >= 0, i -> i - 1).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
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
