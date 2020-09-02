package abc.abc112;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			if (0 == (m % n)) {
				System.out.println(m / n);
			} else {
				System.out.println(getResult(n, m));
			}
		}
	}

	/**
	 * m/n より小さい最大のmの約数を計算する
	 * 
	 * @param n
	 * @param m
	 * @return m/n より小さい最大のmの約数
	 */
	private static int getResult(int n, int m) {
		for (int i = m / n; i >= 1; i--) {
			if (0 == (m % i)) {
				return i;
			}
		}
		return 1;
	}
}
