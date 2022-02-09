package abc.abc151_200.abc158;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), a = scanner.nextLong(), b = scanner.nextLong();
			System.out.println(n / (a + b) * a + Math.min(n % (a + b), a));
		}
	}
}
