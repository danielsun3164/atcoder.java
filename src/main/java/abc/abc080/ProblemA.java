package abc.abc080;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(Math.min(n * a, b));
		}
	}
}
