package abc.abc101_150.abc142;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong();
			System.out.println(getResult(gcd(a, b)));
		}
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
	}

	/**
	 * x * x <= n になるような最大のxを計算する
	 *
	 * @param n
	 * @return x * x <= n になるような最大のx
	 */
	private static int sqrt(long n) {
		long left = 0L, right = Integer.MAX_VALUE;
		while (right - left > 1L) {
			long med = (left + right) / 2L;
			if (med * med <= n) {
				left = med;
			} else {
				right = med;
			}
		}
		return (int) left;
	}

	/**
	 * cの素数の約数の個数を計算する
	 *
	 * @param c
	 * @return cの素数の約数の個数
	 */
	private static int getResult(long c) {
		int n = sqrt(c);
		boolean[] primes = getPrimes(n);
		int answer = 1;
		for (int i = 2; i <= n; i++) {
			if (primes[i] && (0 == (c % i))) {
				answer++;
				while (0 == (c % i)) {
					c /= i;
				}
			}
		}
		return (c > 1) ? answer + 1 : answer;
	}

	/**
	 * n以下の数字が素数かどうかの配列を計算する
	 *
	 * @param n
	 * @return n以下の数字が素数かどうかの配列
	 */
	private static boolean[] getPrimes(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				for (int j = i + i; j <= n; j += i) {
					primes[j] = false;
				}
			}
		}
		return primes;
	}
}
