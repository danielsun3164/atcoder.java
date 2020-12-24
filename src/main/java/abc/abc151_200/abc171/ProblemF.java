package abc.abc151_200.abc171;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			int n = scanner.next().length();
			int m = k + n;
			// 階乗を保存する配列
			long[] factorial = new long[m + 1];
			factorial[0] = 1;
			IntStream.rangeClosed(1, m).forEach(i -> factorial[i] = factorial[i - 1] * i % MOD);
			// 階乗^-1を保存する配列
			long[] revFactorial = new long[m + 1];
			revFactorial[m] = modPow(factorial[m], MOD - 2);
			IntStream.rangeClosed(1, m).map(i -> m - i)
					.forEach(i -> revFactorial[i] = revFactorial[i + 1] * (i + 1) % MOD);
			long answer = 0L;
			for (int i = n; i <= m; i++) {
				// i-1 C n-1
				long result = factorial[i - 1] * revFactorial[n - 1] % MOD * revFactorial[i - n] % MOD;
				// 25^(k-(m-i)) x 26^(m-i)
				result = result * modPow(25, k - (m - i)) % MOD * modPow(26, m - i) % MOD;
				answer = (answer + result) % MOD;
			}
			System.out.println(answer);
		}
	}

	/**
	 * n^m mod MOD を計算する
	 * 
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long modPow(long n, long m) {
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
