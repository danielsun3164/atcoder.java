package other.typical90;

import java.util.Scanner;

public class Problem020 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
			System.out.println((a < pow(c, b)) ? "Yes" : "No");
		}
	}

	/**
	 * nのmべき乗を計算する
	 *
	 * @param n
	 * @param m
	 * @return nのmべき乗
	 */
	private static long pow(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result *= n;
			}
			n *= n;
			m >>= 1;
		}
		return result;
	}
}
