package abc078;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			System.out.println((n * 100 + m * 1800) * pow(2, m));
		}
	}

	/**
	 * nのmべき乗を返す
	 * 
	 * @param n
	 * @param m
	 * @return nのmべき乗
	 */
	private static int pow(int n, int m) {
		int result = 1;
		while (m > 0) {
			if (1 == (m & 1)) {
				result *= n;
			}
			n *= n;
			m >>= 1;
		}
		return result;
	}
}
