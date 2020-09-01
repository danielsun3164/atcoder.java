package abc.abc044;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			System.out.println((n > k) ? k * x + (n - k) * y : n * x);
		}
	}
}
