package abc.abc101_150.abc145;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** modの計算対象 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			if (0 == ((x + y) % 3)) {
				// n + 2m = X, 2n + m = Y という連立方程式を解く
				int sum = (x + y) / 3;
				int n = (sum - (Math.max(x, y) - Math.min(x, y))) >> 1;
				if (n < 0) {
					System.out.println(0);
					return;
				}
				// 階乗と階乗^-1の配列
				long[] fact = new long[sum + 1], invFact = new long[sum + 1];
				fact[0] = 1L;
				IntStream.rangeClosed(1, sum).forEach(i -> fact[i] = (fact[i - 1] * i) % MOD);
				invFact[sum] = powMod(fact[sum], MOD - 2);
				IntStream.range(0, sum).map(i -> sum - 1 - i)
						.forEach(i -> invFact[i] = (invFact[i + 1] * (i + 1)) % MOD);
				// sum_C_n を計算する
				System.out.println((((fact[sum] * invFact[n]) % MOD) * invFact[sum - n]) % MOD);
			} else {
				System.out.println(0);
			}
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
			if ((1 & m) > 0) {
				result = (result * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return result;
	}
}
