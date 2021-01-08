package abc.abc101_150.abc112;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			if (1 == n) {
				System.out.println("Hello World");
			} else {
				int a = scanner.nextInt(), b = scanner.nextInt();
				System.out.println(a + b);
			}
		}
	}
}
