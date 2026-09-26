package abc.abc201_250.abc242;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc242/editorial/3522 の1.動的計画法の実装<br/>
 * https://atcoder.jp/contests/abc242/submissions/29858265 にも参考
 */
public class ProblemF {

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
	 * n × m の各領域について、ちょうど x 個を選択する場合の数を計算し、 動的計画法の結果を dp に格納する。
	 *
	 * <p>
	 * dp[n][m] は、n × m の領域全体を対象とした場合の組合せ数から、 より小さい領域について既に計算された結果を差し引くことで求める。
	 * </p>
	 *
	 * @param x  選択する要素の個数
	 * @param dp 計算結果を格納する二次元配列
	 */
	private static void init(int x, long[][] dp) {
		int n = dp.length, m = dp[0].length;
		IntStream.range(1, n).forEach(ni -> IntStream.range(1, m).forEach(mi -> {
			dp[ni][mi] = binom(ni * mi, x);
			IntStream.rangeClosed(1, ni)
					.forEach(i -> IntStream.rangeClosed(1, mi).filter(j -> !(i == ni && j == mi)).forEach(
							j -> dp[ni][mi] = (dp[ni][mi] + MOD - binom(ni, i) * binom(mi, j) % MOD * dp[i][j] % MOD)
									% MOD));
		}));
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
