package abc.abc051_100.abc086;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((1 == (1 & (a * b))) ? "Odd" : "Even");
		}
	}
}
