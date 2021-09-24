package abc.abc151_200.abc151;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			// 階乗と階乗^{-1}の配列
			long[] fact = new long[n + 1], invFact = new long[n + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[n] = powMod(fact[n], MOD - 2);
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			System.out
					.println(
							(IntStream.range(0, n).mapToLong(i -> a[i] * c(i, k - 1, fact, invFact) % MOD).sum() % MOD
									- IntStream.range(0, n)
											.mapToLong(i -> a[i] * c(n - 1 - i, k - 1, fact, invFact) % MOD).sum() % MOD
									+ MOD) % MOD);
		}
	}

	/**
	 * n_C_m を計算する
	 *
	 * @param n
	 * @param m
	 * @param fact    階乗の配列
	 * @param invFact 階乗^{-1}の配列
	 * @return n_C_m
	 */
	private static long c(int n, int m, long[] fact, long[] invFact) {
		return (n < m) ? 0L : (fact[n] * invFact[m] % MOD * invFact[n - m] % MOD);
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
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
