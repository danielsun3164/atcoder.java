package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem015 {

	/** modの対象 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] fact = new long[n + 1], invFact = new long[n + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fact[i] = (fact[i - 1] * i) % MOD);
			invFact[n] = powMod(fact[n], MOD - 2);
			IntStream.rangeClosed(1, n).map(i -> n - i).forEach(i -> invFact[i] = (invFact[i + 1] * (i + 1)) % MOD);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n)
					.forEach(k -> sb
							.append(IntStream.rangeClosed(1, ((n + k) - 1) / k)
									.mapToLong(a -> ncr(fact, invFact, n - ((k - 1) * (a - 1)), a)).sum() % MOD)
							.append(System.lineSeparator()));
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
	 * n_C_r mod MODを計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 階乗の逆元の配列
	 * @param n
	 * @param r
	 * @return n_C_r mod MOD
	 */
	private static long ncr(long[] fact, long[] invFact, int n, int r) {
		return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
	}
}
