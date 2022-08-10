package abc.abc151_200.abc154;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r1 = scanner.nextInt(), c1 = scanner.nextInt(), r2 = scanner.nextInt(), c2 = scanner.nextInt();
			int max = r2 + c2;
			long[] fact = new long[max + 1], invFact = new long[max + 1];
			fact[0] = 1L;
			IntStream.range(0, max).forEach(i -> fact[i + 1] = fact[i] * (i + 1) % MOD);
			invFact[max] = powMod(fact[max], MOD - 2);
			IntStream.range(0, max).map(i -> max - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			System.out.println((g(r2, c2, fact, invFact) + g(r1 - 1, c1 - 1, fact, invFact)
					- g(r1 - 1, c2, fact, invFact) + MOD - g(r2, c1 - 1, fact, invFact) + MOD) % MOD);
		}
	}

	/**
	 * a ^ b mod MODを計算する
	 *
	 * @param a
	 * @param b
	 * @return a ^ b mod MOD
	 */
	private static long powMod(long a, long b) {
		long result = 1L;
		while (b > 0) {
			if (1L == (1L & b)) {
				result = result * a % MOD;
			}
			a = a * a % MOD;
			b >>= 1;
		}
		return result;
	}

	/**
	 * (0,0)から(r,c)の範囲のすべての(i,j)のf(i,j)の合計値を計算する
	 *
	 * @param r
	 * @param c
	 * @param fact    階乗の配列
	 * @param invFact 逆の階乗の配列
	 * @return (0,0)から(r,c)の範囲のすべての(i,j)のf(i,j)の合計値
	 */
	private static long g(int r, int c, long[] fact, long[] invFact) {
		int max = r + c;
		long[] dp = new long[max + 1];
		dp[0] = 1L;
		int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
		for (int rc = 0; rc < max; rc++) {
			dp[rc + 1] = dp[rc] * 2L % MOD;
			if (r1 < r) {
				r1++;
			} else {
				dp[rc + 1] = (dp[rc + 1] - fact[r1 + c1] * invFact[r1] % MOD * invFact[c1] % MOD + MOD) % MOD;
				c1++;
			}
			if (c2 < c) {
				c2++;
			} else {
				dp[rc + 1] = (dp[rc + 1] - fact[r2 + c2] * invFact[r2] % MOD * invFact[c2] % MOD + MOD) % MOD;
				r2++;
			}
		}
		return Arrays.stream(dp).sum() % MOD;
	}
}
