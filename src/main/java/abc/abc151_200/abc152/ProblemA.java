package abc.abc151_200.abc152;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			System.out.println((n == m) ? "Yes" : "No");
		}
	}
}
