package abc.abc201_250.abc248;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * O(K) 冪級数を用いた回答<br/>
 * https://atcoder.jp/contests/abc248/submissions/30902462 にも参考
 */
public class ProblemC別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			long[] fact = new long[k + 1], invFact = new long[k + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, k).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[k] = powMod(fact[k], MOD - 2);
			IntStream.range(0, k).map(i -> k - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			System.out.println(IntStream.range(0, (k - n + m) / m).mapToLong(
					i -> c(fact, invFact, n, i) * c(fact, invFact, k - i * m, n) % MOD * ((0 == (1 & i)) ? 1 : -1))
					.reduce(0L, (s, l) -> (l > 0L) ? (s + l) % MOD : (s + MOD + l) % MOD));
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
		while (m > 0L) {
			if (1L == (1L & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}

	/**
	 * n_C_m mod MOD を計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param n
	 * @param m
	 * @return n_C_m mod MOD
	 */
	private static long c(long[] fact, long[] invFact, int n, int m) {
		return ((n < m) || (n < 0) || (m < 0)) ? 0L : fact[n] * invFact[m] % MOD * invFact[n - m] % MOD;
	}
}
