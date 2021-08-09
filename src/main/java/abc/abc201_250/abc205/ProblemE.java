package abc.abc201_250.abc205;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** modの対象 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			if (n > (m + k)) {
				System.out.println(0);
				return;
			}
			long[] fact = new long[n + m + 1], invFact = new long[n + m + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n + m).forEach(i -> fact[i] = (fact[i - 1] * i) % MOD);
			invFact[n + m] = powMod(fact[n + m], MOD - 2);
			IntStream.range(0, n + m).map(i -> (n + m) - 1 - i)
					.forEach(i -> invFact[i] = (invFact[i + 1] * (i + 1)) % MOD);
			System.out.println(((c(fact, invFact, n + m, m) - c(fact, invFact, n + m, m + k + 1)) + MOD) % MOD);
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
	 * n_C_m mod MOD を計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param n
	 * @param m
	 * @return n_C_m mod MOD
	 */
	private static long c(long[] fact, long[] invFact, int n, int m) {
		if (m > n) {
			return 0L;
		} else {
			return (((fact[n] * invFact[m]) % MOD) * invFact[n - m]) % MOD;
		}
	}
}
