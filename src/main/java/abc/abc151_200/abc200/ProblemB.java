package abc.abc151_200.abc200;

import java.util.Scanner;

public class ProblemB {

	/** 200の定数 */
	private static final int N = 200;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), k = scanner.nextLong();
			while (k > 0) {
				if (0L == (n % N)) {
					n /= N;
				} else {
					n = (n * 1000) + N;
				}
				k--;
			}
			System.out.println(n);
		}
	}
}
