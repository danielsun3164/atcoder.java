package abc.abc151_200.abc156;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	/** mod対象 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] fact = new long[n + 1], invFact = new long[n + 1];
			fact[0] = 1L;
			IntStream.range(0, n).forEach(i -> fact[i + 1] = fact[i] * (i + 1) % MOD);
			invFact[n] = powMod(fact[n], MOD - 2);
			IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			System.out.println(IntStream.rangeClosed(0, Math.min(n - 1, k))
					.mapToLong(i -> cMod(fact, invFact, n, i) * cMod(fact, invFact, n - 1, i) % MOD).sum() % MOD);
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
	 * n_C_m mod MODを計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param n
	 * @param m
	 * @return n_C_m mod MOD
	 */
	private static long cMod(long[] fact, long[] invFact, int n, int m) {
		return fact[n] * invFact[m] % MOD * invFact[n - m] % MOD;
	}
}
