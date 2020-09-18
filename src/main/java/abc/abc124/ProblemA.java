package abc.abc124;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((a > b) ? a + Math.max(a - 1, b) : b + Math.max(a, b - 1));
		}
	}
}
