package abc.abc201_250.abc214;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc214/submissions/25003972 にも参考
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = n << 1;
			long[] fact = new long[m + 1], invFact = new long[m + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, m).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
			invFact[m] = powMod(fact[m], MOD - 2);
			IntStream.range(0, m).map(i -> m - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int[] q = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int[] invP = new int[n];
			IntStream.range(0, n).forEach(i -> invP[p[i]] = i);
			boolean[] done = new boolean[n];
			Arrays.fill(done, false);
			long[] coeff = new long[1];
			coeff[0] = 1L;
			for (int src = 0; src < n; src++) {
				if (!done[src]) {
					int count = 0;
					for (int u = src; !done[u]; u = invP[q[u]]) {
						done[u] = true;
						count++;
					}
					if (1 == count) {
						long[] next = new long[coeff.length + 1];
						Arrays.fill(next, 0L);
						for (int i = 0; i < coeff.length; i++) {
							next[i] = (next[i] + coeff[i]) % MOD;
							next[i + 1] = (next[i + 1] + coeff[i]) % MOD;
						}
						coeff = next;
					} else {
						long[] dp = new long[count + 1];
						Arrays.fill(dp, 0L);
						dp[count] = 2L;
						for (int first = 0; first < count; first++) {
							for (int other = 0; other < count - first; other++) {
								int index = count - other - 1;
								dp[index] = (dp[index] + c(fact, invFact, count - first + other, 2 * other + 1)
										+ c(fact, invFact, count - first + other - 1, 2 * other) * first % MOD) % MOD;
							}
						}
						long[] next = new long[coeff.length + dp.length - 1];
						Arrays.fill(next, 0L);
						for (int i = 0; i < coeff.length; i++) {
							for (int j = 0; j < dp.length; j++) {
								next[i + j] = (next[i + j] + coeff[i] * dp[j] % MOD) % MOD;
							}
						}
						coeff = next;
					}
				}
			}
			long answer = 0L;
			for (int i = 0; i <= n; i++) {
				long add = fact[n - i] * coeff[i] % MOD;
				answer = (answer + ((0 == (1 & i)) ? add : -add) + MOD) % MOD;
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
	 * n C m mod MODを計算する
	 *
	 * @param fact    階乗の配列
	 * @param invFact 逆階乗の配列
	 * @param n
	 * @param m
	 * @return n C m mod MOD
	 */
	private static long c(long[] fact, long[] invFact, int n, int m) {
		return fact[n] * invFact[m] % MOD * invFact[n - m] % MOD;
	}
}
