package abc.abc151_200.abc162;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long answer = powMod(k, n);
			// count[i]はgcdの結果がiになる組み合わせ数 mod MOD
			long[] count = new long[k + 1];
			Arrays.fill(count, 0L);
			for (int i = k; i >= 2; i--) {
				count[i] = powMod(k / i, n);
				for (int j = i + i; j <= k; j += i) {
					count[i] = (count[i] + MOD - count[j]) % MOD;
				}
				answer = (answer + count[i] * (i - 1)) % MOD;
			}
			System.out.println(answer);
		}
	}

	/**
	 * n^m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, int m) {
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
