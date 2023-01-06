package other.typical90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem082 {

	/** 10 */
	private static final long TEN = 10L;

	/** MOD対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long l = scanner.nextLong(), r = scanner.nextLong();
			List<Long> numbers = new ArrayList<>();
			long now = 1L;
			for (int i = 0; i < 18; i++) {
				numbers.add(now - 1);
				now *= TEN;
			}
			for (int i = -1; i <= 1; i++) {
				numbers.add(now + i);
			}
			long prev = 0L, answer = 0L;
			for (long n : numbers) {
				if ((l <= n) && (n <= r)) {
					answer = (answer + calc(Math.max(l, prev + 1), n)) % MOD;
				} else if ((prev < r) && (r < n)) {
					answer = (answer + calc(Math.max(l, prev + 1), r)) % MOD;
				}
				prev = n;
				if (n > r) {
					break;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * 最小値から最大値まで黒板に書く場合の文字数を計算する
	 *
	 * @param l 最小値
	 * @param r 最大値
	 * @return 最小値から最大値まで黒板に書く場合の文字数
	 */
	private static long calc(long l, long r) {
		long digit = digit(r);
		if (digit(l) != digit) {
			throw new IllegalArgumentException();
		}
		l %= MOD;
		r %= MOD;
		return (r + l) * ((r - l + MOD + 1) % MOD) % MOD * powMod(2L, MOD - 2) * digit % MOD;
	}

	/**
	 * 入力数字の桁数を計算する
	 *
	 * @param l 入力数字
	 * @return 入力数字の桁数
	 */
	private static long digit(long l) {
		long result = 0L;
		while (l > 0) {
			result++;
			l /= TEN;
		}
		return result;
	}

	/**
	 * n ^ m mod MOD を計算する
	 *
	 * @param n
	 * @param m
	 * @return n ^ m mod MOD
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
}
