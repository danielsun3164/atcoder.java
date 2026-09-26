package abc.abc201_250.abc242;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc242/editorial/3523 の実装<br/>
 * https://atcoder.jp/contests/abc242/submissions/29860598 にも参考
 */
public class ProblemEx {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 階乗、逆階乗の配列 */
	private static long[] fact, invFact;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			initFact(Math.max(n, m) + 1);
			Data[] datas = IntStream.range(0, m).mapToObj(_ -> new Data(scanner.nextInt(), scanner.nextInt()))
					.sorted((a, b) -> (a.l == b.l) ? Integer.compare(a.r, b.r) : Integer.compare(a.l, b.l))
					.toArray(Data[]::new);
			long[][][] dp = new long[m + 1][n + 1][m + 1];
			IntStream.rangeClosed(0, m)
					.forEach(i -> IntStream.rangeClosed(0, n).forEach(j -> Arrays.fill(dp[i][j], 0L)));
			dp[0][0][0] = 1L;
			IntStream.range(0, m).forEach(i -> IntStream.iterate(n, j -> j >= 0, j -> j - 1)
					.forEach(j -> IntStream.rangeClosed(0, m).forEach(k -> {
						if (j < datas[i].l - 1) {
							dp[i + 1][j][k] = dp[i][j][k];
						} else if (j <= datas[i].r) {
							dp[i + 1][j][k] = dp[i][j][k];
							if (k > 0) {
								dp[i + 1][datas[i].r][k] = (dp[i + 1][datas[i].r][k] + dp[i][j][k - 1]) % MOD;
							}
						} else {
							if (k > 0) {
								dp[i + 1][j][k] = (dp[i][j][k] + dp[i][j][k - 1]) % MOD;
							} else {
								dp[i + 1][j][k] = dp[i][j][k];
							}
						}
					})));
			System.out
					.println(IntStream
							.rangeClosed(0, m).mapToLong(i -> (MOD + binom(m, i) - dp[m][n][i]) % MOD
									* powMod(binom(m, i), MOD - 2) % MOD * m % MOD * powMod(m - i, MOD - 2) % MOD)
							.sum() % MOD);
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
	 * n_C_k mod MODを計算する
	 *
	 * @param n
	 * @param k
	 * @return n_C_k mod MOD
	 */
	private static long binom(int n, int k) {
		return (n < 0 || k < 0 || n < k) ? 0L : fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
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

	/**
	 * l,rを格納するクラス
	 */
	private static class Data {
		int l, r;

		Data(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}
}
