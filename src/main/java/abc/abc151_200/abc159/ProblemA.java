package abc.abc151_200.abc159;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			System.out.println(c(n, 2) + c(m, 2));
		}
	}

	/**
	 * n C m を計算する
	 *
	 * @param n
	 * @param m
	 * @return n C m
	 */
	private static int c(int n, int m) {
		if (m <= n) {
			int answer = 1;
			for (int i = 1; i <= m; i++) {
				answer *= n + 1 - i;
				answer /= i;
			}
			return answer;
		}
		return 0;
	}
}
