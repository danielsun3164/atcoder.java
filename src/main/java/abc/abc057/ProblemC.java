package abc.abc057;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int sqrt = (int) Math.sqrt(n);
			for (int i = sqrt; i >= 1; i--) {
				if ((n % i) == 0) {
					System.out.println(f(i, n / i));
					return;
				}
			}
		}
	}

	/**
	 * @param a
	 * @param b
	 * @return aとbの10進数の最大桁数
	 */
	private static int f(long a, long b) {
		return Math.max(String.valueOf(a).length(), String.valueOf(b).length());
	}
}
