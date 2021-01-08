package abc.abc151_200.abc185;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long l = scanner.nextLong();
			System.out.println(fc(l - 1, 11));
		}
	}

	/**
	 * n_C_m を計算する
	 * 
	 * @param n
	 * @param m
	 * @return n_C_m
	 */
	private static long fc(long n, long m) {
		long result = 1L;
		for (int i = 0; i < m; i++) {
			result *= n - i;
			result /= i + 1;
		}
		return result;
	}
}
