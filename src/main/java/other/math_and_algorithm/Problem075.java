package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem075 {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;
	/** 階乗の配列 */
	private static long[] fact;
	/** 逆階乗の配列 */
	private static long[] invFact;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			init(n);
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			System.out.println(IntStream.range(0, n).mapToLong(i -> a[i] * combination(n - 1, i) % MOD).sum() % MOD);
		}
	}

	/**
	 * 階乗と逆階乗の配列を計算する
	 *
	 * @param n 配列の要素数
	 */
	private static void init(int n) {
		fact = new long[n + 1];
		fact[0] = 1L;
		IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i % MOD);
		invFact = new long[n + 1];
		invFact[n] = powMod(fact[n], MOD - 2);
		IntStream.range(0, n).map(i -> n - 1 - i).forEach(i -> invFact[i] = invFact[i + 1] * (i + 1) % MOD);
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
	 * n_C_r mod MOD を計算する
	 *
	 * @param n
	 * @param r
	 * @return n_C_r mod MOD
	 */
	private static long combination(int n, int r) {
		return (r > n) ? 0L : fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
	}
}
