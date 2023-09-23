package abc.abc201_250.abc217;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc217/editorial/2589 の解説の実装
 */
public class ProblemG別回答1 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[] fact = new long[n + 1], invFact = new long[n + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[n] = powMod(fact[n], MOD - 2);
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			int[] cnt = new int[m];
			Arrays.fill(cnt, n / m);
			IntStream.rangeClosed(n / m * m + 1, n).forEach(i -> cnt[i % m]++);
			long[] dp = new long[n + 1];
			IntStream.rangeClosed(1, n).forEach(k -> {
				dp[k] = 1L;
				IntStream.range(0, m)
						.forEach(i -> dp[k] = (dp[k] * ncr(fact, invFact, k, cnt[i]) % MOD * fact[cnt[i]] % MOD));
			});
			long[] answers = new long[n + 1];
			Arrays.fill(answers, 0L);
			IntStream.rangeClosed(1, n).forEach(i -> {
				IntStream.rangeClosed(1, i).forEach(j -> {
					if (0 == ((i - j) & 1)) {
						answers[i] = (answers[i] + dp[j] * ncr(fact, invFact, i, j) % MOD) % MOD;
					} else {
						answers[i] = (answers[i] - dp[j] * ncr(fact, invFact, i, j) % MOD + MOD) % MOD;
					}
				});
				answers[i] = answers[i] * invFact[i] % MOD;
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n).forEach(i -> sb.append(answers[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
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

	/**
	 * n C r mod MODを計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param n
	 * @param r
	 * @return n C r mod MOD
	 */
	private static long ncr(long[] fact, long[] invFact, int n, int r) {
		return ((n >= r) && (n > 0) && (r > 0)) ? fact[n] * invFact[n - r] % MOD * invFact[r] % MOD : 0L;
	}
}
