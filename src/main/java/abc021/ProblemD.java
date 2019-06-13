package abc021;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	private static final long P = 1_000_000_007L;

	/** N! mod P の配列 */
	private static long[] factorial;
	/** N! mod P 逆元の配列を計算 */
	private static long[] factinv;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int max = Math.max(n, k);
			// N! mod P の配列を計算
			factorial = new long[2 * max + 1];
			factorial[0] = 1;
			IntStream.rangeClosed(1, 2 * max).forEach(i -> factorial[i] = factorial[i - 1] * i % P);
			// N! mod P 逆元の配列を計算
			factinv = new long[2 * max + 1];
			factinv[0] = 1;
			factinv[2 * max] = pow(factorial[2 * max], P - 2);
			for (int i = 2 * max - 1; i >= 1; i--) {
				factinv[i] = factinv[i + 1] * (i + 1) % P;
			}
			System.out.println(H(n, k));
		}
	}

	/**
	 * @param n
	 * @param k
	 * @return n_C_k mod P を計算する
	 */
	private static long C(int n, int k) {
		return factorial[n] * factinv[k] % P * factinv[n - k] % P;
	}

	/**
	 * @param n
	 * @param k
	 * @return n_H_k mod P を計算する
	 */
	private static long H(int n, int k) {
		return C(n + k - 1, n - 1);
	}

	/**
	 * @param n
	 * @param k
	 * @return n^k mod P
	 */
	private static long pow(long n, long k) {
		long result = (1 == (k & 1)) ? n : 1;
		k >>= 1;
		// nのk乗を計算
		long temp = n;
		while (k > 0) {
			temp = temp * temp % P;
			if (1 == (k & 1)) {
				result = result * temp % P;
			}
			k >>= 1;
		}
		return result;
	}
}
