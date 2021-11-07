package abc.abc201_250.abc208;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong() % MOD;
			int m = scanner.nextInt(), k = scanner.nextInt(), s = m + k;
			long[] dp = IntStream.rangeClosed(0, s).mapToLong(i -> powMod(i, k)).toArray();
			IntStream.range(0, m)
					.forEach(j -> IntStream.rangeClosed(1, s).forEach(i -> dp[i] = (dp[i - 1] + dp[i]) % MOD));
			long[] invFact = new long[s + 1];
			invFact[s] = powMod(LongStream.rangeClosed(1, s).reduce(1L, (mul, i) -> mul * i % MOD), MOD - 2);
			IntStream.range(0, s).map(i -> s - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			long[] l = new long[s + 1], r = new long[s + 1];
			Arrays.fill(l, 1L);
			Arrays.fill(r, 1L);
			IntStream.range(0, s).forEach(i -> l[i + 1] = l[i] * (n - i) % MOD);
			IntStream.range(0, s).map(i -> s - i).forEach(i -> r[i - 1] = r[i] * (n - i) % MOD);
			System.out.println((IntStream.rangeClosed(0, s)
					.mapToLong(i -> (((1 & s) == (1 & i)) ? 1 : -1)
							* (dp[i] * l[i] % MOD * r[i] % MOD * invFact[i] % MOD * invFact[s - i] % MOD))
					.sum() % MOD + MOD) % MOD);
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
			if (1L == (1L & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
