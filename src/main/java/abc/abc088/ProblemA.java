package abc.abc088;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt();
			System.out.println((a >= (n % 500)) ? "Yes" : "No");
		}
	}
}
