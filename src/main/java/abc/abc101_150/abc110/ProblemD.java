package abc.abc101_150.abc110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			if ((1 == m) || (1 == n)) {
				System.out.println(1);
				return;
			}
			List<Integer> factorCounts = calcFactorCounts(m);
			int max = factorCounts.stream().mapToInt(Integer::intValue).max().getAsInt();
			long[] factorial = new long[max + n], revFactorial = new long[max + n];
			factorial[0] = 1L;
			IntStream.range(1, max + n).forEach(i -> factorial[i] = factorial[i - 1] * i % MOD);
			revFactorial[max + n - 1] = powMod(factorial[max + n - 1], MOD - 2);
			IntStream.range(0, max + n - 1).map(i -> max + n - 2 - i)
					.forEach(i -> revFactorial[i] = revFactorial[i + 1] * (i + 1) % MOD);
			long result = 1L;
			for (int b : factorCounts) {
				result = result * factorial[b + n - 1] % MOD * revFactorial[n - 1] % MOD * revFactorial[b] % MOD;
			}
			System.out.println(result);
		}
	}

	/**
	 * mの因数の数を計算する
	 *
	 * @param m
	 * @return mの因数の数の一覧
	 */
	private static List<Integer> calcFactorCounts(int m) {
		List<Integer> result = new ArrayList<>();
		int sqrt = (int) Math.sqrt(m);
		for (int i = 2; (i <= sqrt) && (m > 1); i++) {
			if (0 == (m % i)) {
				int count = 0;
				while (0 == (m % i)) {
					m /= i;
					count++;
				}
				result.add(count);
			}
		}
		if (m > 1) {
			result.add(1);
		}
		return result;
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
			if (1 == (m & 1)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
