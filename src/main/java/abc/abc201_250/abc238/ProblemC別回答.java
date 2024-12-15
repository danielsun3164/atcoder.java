package abc.abc201_250.abc238;

import java.util.Scanner;

/**
 * https://kazun-kyopro.hatenablog.com/entry/ABC/238/C の実装
 */
public class ProblemC別回答 {

	/** 10 */
	private static final int TEN = 10;
	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int r = digits(n);
			long answer = (n + 1 - powMod(TEN, r - 1) + MOD) % MOD;
			answer = answer * (answer + 1) % MOD * powMod(2, MOD - 2);
			answer = (answer + (powMod(TEN, r - 1) - 1 + MOD) % MOD * (9 * powMod(TEN, r - 1) % MOD + 20) % MOD
					* powMod(22, MOD - 2) % MOD) % MOD;
			System.out.println(answer);
		}
	}

	/**
	 * xの10進数の桁数を返す
	 *
	 * @param x
	 * @return xの10進数の桁数
	 */
	private static int digits(long x) {
		int result = 1;
		long now = 1;
		while (now * TEN <= x) {
			result++;
			now *= TEN;
		}
		return result;
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
}
