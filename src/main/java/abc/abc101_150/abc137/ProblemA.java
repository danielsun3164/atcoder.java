package abc.abc101_150.abc137;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(Math.max(Math.max(a + b, a - b), a * b));
		}
	}
}
