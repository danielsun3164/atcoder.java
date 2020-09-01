package abc.abc060;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			boolean result = false;
			for (int i = a; i < lcm(a, b); i += a) {
				if (c == i % b) {
					result = true;
					break;
				}
			}
			System.out.println(result ? "YES" : "NO");
		}
	}

	/**
	 * @param a
	 * @param b
	 * @return aとbの最小公倍数
	 */
	private static int lcm(int a, int b) {
		int temp;
		long c = a;
		c *= b;
		while ((temp = a % b) != 0) {
			a = b;
			b = temp;
		}
		return (int) (c / b);
	}
}
