package other.atc002;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), m = scanner.nextLong(), p = scanner.nextLong();
			System.out.println(powMod(n, p, m));
		}
	}

	/**
	 * n^p mod m を計算する
	 *
	 * @param n
	 * @param p
	 * @param m
	 * @return n^p mod m
	 */
	private static long powMod(long n, long p, long m) {
		long result = 1L;
		n %= m;
		while (p > 0L) {
			if (1L == (1L & p)) {
				result = result * n % m;
			}
			n = n * n % m;
			p >>= 1;
		}
		return result;
	}

}
