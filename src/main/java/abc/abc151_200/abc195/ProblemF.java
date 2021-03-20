package abc.abc151_200.abc195;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong();
			int n = (int) (b - a);
			long[] primes = getPrimes(n);
			int m = primes.length;
			long[][] dp = new long[n + 2][1 << m];
			IntStream.range(0, dp.length).forEach(i -> Arrays.fill(dp[i], 0L));
			dp[0][0] = 1L;
			IntStream.rangeClosed(0, n).forEach(i -> {
				long l = a + i;
				int bits = IntStream.range(0, m).map(j -> (0L == (l % primes[j])) ? 1 << j : 0).sum();
				IntStream.range(0, 1 << m).forEach(j -> {
					dp[i + 1][j] += dp[i][j];
					if (0 == (j & bits)) {
						dp[i + 1][j | bits] += dp[i][j];
					}
				});
			});
			System.out.println(Arrays.stream(dp[n + 1]).sum());
		}
	}

	/**
	 * nまでの素数の一覧を計算する
	 *
	 * @param n
	 * @return nまでの素数の一覧
	 */
	private static long[] getPrimes(int n) {
		boolean[] isPrimes = new boolean[Math.max(n + 1, 2)];
		Arrays.fill(isPrimes, true);
		isPrimes[0] = isPrimes[1] = false;
		IntStream.rangeClosed(2, n).forEach(i -> {
			if (isPrimes[i]) {
				for (int j = i + i; j <= n; j += i) {
					isPrimes[j] = false;
				}
			}
		});
		return IntStream.rangeClosed(0, n).filter(i -> isPrimes[i]).mapToLong(i -> i).toArray();
	}
}
