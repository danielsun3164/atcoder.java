package abc.abc201_250.abc240;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://kanpurin.hatenablog.com/entry/2022/02/25/110702 の実装<br/>
 * https://atcoder.jp/contests/abc240/submissions/29554925 にも参考
 */
public class ProblemG別回答 {

	/** modの対象 */
	private static final long MOD = 998_244_353L;
	/** 階乗の配列 */
	private static long[] factorial;
	/** 1/階乗の配列 */
	private static long[] invFactorial;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = Math.abs(scanner.nextInt()), y = Math.abs(scanner.nextInt()),
					z = Math.abs(scanner.nextInt());
			factorial = new long[n + 1];
			invFactorial = new long[n + 1];
			factorial[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> factorial[i] = factorial[i - 1] * i % MOD);
			invFactorial[n] = powMod(factorial[n], MOD - 2);
			IntStream.rangeClosed(0, n - 1).map(i -> n - 1 - i)
					.forEach(i -> invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD);
			long answer = 0L;
			for (int k = 0; k <= n; k++) {
				if ((0 == (1 & (k + x - y))) && (0 == (1 & (k - x - y))) && (0 == (1 & (n - k + z)))) {
					answer = (answer + combination(n, k) * combination(k, (k + x - y) >> 1) % MOD
							* combination(k, (k - x - y) >> 1) % MOD * combination(n - k, (n - k + z) >> 1) % MOD)
							% MOD;
				}
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
	 * n_C_k を計算する
	 *
	 * @param n
	 * @param k
	 * @return n_C_k
	 */
	private static long combination(int n, int k) {
		return ((k >= 0) && (k <= n)) ? factorial[n] * invFactorial[k] % MOD * invFactorial[n - k] % MOD : 0L;
	}
}
