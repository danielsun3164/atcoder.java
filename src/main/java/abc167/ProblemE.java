package abc167;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	private static final long MOD = 998_244_353;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			// n-1_C_i mod MOD の結果を格納する配列
			long[] c = new long[n];
			c[n - 1] = c[0] = 1;
			IntStream.rangeClosed(1, (n - 1) / 2)
					.forEach(i -> c[n - 1 - i] = c[i] = c[i - 1] * (n - i) % MOD * modpow(i, MOD - 2) % MOD);
			// (m-1)^i mod MOD の結果を格納する配列
			long[] mp = new long[n];
			mp[0] = 1;
			IntStream.range(1, n).forEach(i -> mp[i] = mp[i - 1] * (m - 1) % MOD);
			long result = 0L;
			for (int i = 0; i <= k; i++) {
				result = (result + m * c[i] % MOD * mp[n - 1 - i] % MOD) % MOD;
			}
			System.out.println(result);
		}
	}

	/**
	 * nのmべき乗 mod MOD を計算する
	 * 
	 * @param n
	 * @param m
	 * @return nのmべき乗 mod MOD
	 */
	private static long modpow(long n, long m) {
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
