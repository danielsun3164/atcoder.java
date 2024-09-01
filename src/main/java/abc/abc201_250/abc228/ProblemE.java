package abc.abc201_250.abc228;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc228/editorial/2932 の実装
 */
public class ProblemE {

	/** MOD対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), k = scanner.nextLong(), m = scanner.nextLong();
			System.out.println((0L == m % MOD) ? 0L : powMod(m % MOD, powMod(k % (MOD - 1), n, MOD - 1), MOD));
		}
	}

	/**
	 * n^k mod mを計算する
	 *
	 * @param n
	 * @param k
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long k, long m) {
		long result = 1L;
		while (k > 0) {
			if (1L == (1L & k)) {
				result = result * n % m;
			}
			n = n * n % m;
			k >>= 1;
		}
		return result;
	}
}
