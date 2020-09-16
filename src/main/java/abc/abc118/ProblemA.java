package abc.abc118;

import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((0 == b % a) ? a + b : b - a);
		}
	}
}
