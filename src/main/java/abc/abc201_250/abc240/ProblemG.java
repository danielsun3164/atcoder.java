package abc.abc201_250.abc240;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc240/editorial/3423 の実装
 */
public class ProblemG {

	/** modの対象 */
	private static final long MOD = 998_244_353L;
	/** 階乗の配列 */
	private static long[] factorial;
	/** 1/階乗の配列 */
	private static long[] invFactorial;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
			factorial = new long[n + 1];
			invFactorial = new long[n + 1];
			factorial[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> factorial[i] = factorial[i - 1] * i % MOD);
			invFactorial[n] = powMod(factorial[n], MOD - 2);
			IntStream.rangeClosed(0, n - 1).map(i -> n - 1 - i)
					.forEach(i -> invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD);
			long answer = 0L;
			for (int k = Math.abs(z); k <= n; k++) {
				answer += combination(n, k) * f1(k, z) % MOD * f1(n - k, x + y) % MOD * f1(n - k, x - y) % MOD;
				answer %= MOD;
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
		return factorial[n] * invFactorial[k] % MOD * invFactorial[n - k] % MOD;
	}

	/**
	 * f1(n,x)を計算する
	 *
	 * @param n
	 * @param x
	 * @return f(n,x)
	 */
	private static long f1(int n, int x) {
		x = Math.abs(x);
		return ((n >= x) && ((1 & n) == (1 & x))) ? combination(n, (n + x) >> 1) : 0L;
	}
}
