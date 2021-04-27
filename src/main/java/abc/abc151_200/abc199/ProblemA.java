package abc.abc151_200.abc199;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			System.out.println((((a * a) + (b * b)) < (c * c)) ? "Yes" : "No");
		}
	}
}
