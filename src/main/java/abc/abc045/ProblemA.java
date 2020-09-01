package abc.abc045;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int h = scanner.nextInt();
			System.out.println((a + b) * h / 2);
		}
	}
}
