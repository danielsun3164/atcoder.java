package abc.abc120;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), k = scanner.nextInt();
			for (int i = Math.min(a, b); i >= 1; i--) {
				if ((0 == (a % i)) && (0 == (b % i))) {
					if (0 == --k) {
						System.out.println(i);
						break;
					}
				}
			}
		}
	}
}
