package abc.abc201_250.abc242;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc242/editorial/3522 の2.包除原理の実装<br/>
 * https://atcoder.jp/contests/abc242/submissions/29858376 にも参考
 */
public class ProblemF別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 階乗、逆階乗の配列 */
	private static long[] fact, invFact;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), b = scanner.nextInt(), w = scanner.nextInt();
			initFact(n * m);
			long[][] dp1 = new long[n + 1][m + 1], dp2 = new long[n + 1][m + 1];
			init(b, dp1);
			init(w, dp2);

			System.out.println(IntStream.rangeClosed(1, n)
					.mapToLong(i -> IntStream.rangeClosed(1, n - i).mapToLong(j -> IntStream.rangeClosed(1, m)
							.mapToLong(k -> IntStream.rangeClosed(1, m - k)
									.mapToLong(l -> binom(n, i) * binom(n - i, j) % MOD * binom(m, k) % MOD
											* binom(m - k, l) % MOD * dp1[i][k] % MOD * dp2[j][l] % MOD)
									.sum() % MOD)
							.sum() % MOD).sum() % MOD)
					.sum() % MOD);
		}
	}

	/**
	 * n × m の領域について、x 個を選択する場合の数を包除原理によって計算し、dp に格納する。
	 *
	 * @param x  選択する要素の個数
	 * @param dp 計算結果を格納する二次元配列
	 */
	private static void init(int x, long[][] dp) {
		int n = dp.length, m = dp[0].length;
		IntStream.range(1, n).forEach(ni -> IntStream.range(1, m)
				.forEach(mi -> IntStream.rangeClosed(0, ni).forEach(i -> IntStream.rangeClosed(0, mi).forEach(j -> {
					long v = (1 == (1 & (i + j))) ? -1L : 1L;
					dp[ni][mi] = (dp[ni][mi] + MOD
							+ v * binom(ni, i) * binom(mi, j) % MOD * binom((ni - i) * (mi - j), x) % MOD) % MOD;
				}))));
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
}
