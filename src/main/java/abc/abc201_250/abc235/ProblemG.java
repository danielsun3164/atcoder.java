package abc.abc201_250.abc235;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc235/editorial/3252 の実装
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 階乗と逆階乗の配列 */
	private static long[] fact, invFact;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			init(n);
			long answer = 0L, ai = 1L, bi = 1L, ci = 1L, sign = (0 == (1 & n)) ? 1 : -1;
			for (int i = 0; i <= n; i++) {
				long current = binom(n, i) * ai % MOD * bi % MOD * ci % MOD;
				answer = (answer + current * sign % MOD + MOD) % MOD;
				ai = (ai + ai - binom(i, a) + MOD) % MOD;
				bi = (bi + bi - binom(i, b) + MOD) % MOD;
				ci = (ci + ci - binom(i, c) + MOD) % MOD;
				sign = -sign;
			}
			System.out.println(answer % MOD);
		}
	}

	/**
	 * 階乗と逆階乗配列の初期化
	 *
	 * @param n 配列の長さ
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
	 * n_C_rを計算する
	 *
	 * @param n
	 * @param r
	 * @return n_C_r
	 */
	private static long binom(int n, int r) {
		return ((n < r) || (n < 0) || (r < 0)) ? 0L : fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
	}
}
