package abc058;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			System.out.println((a - b == b - c) ? "YES" : "NO");
		}
	}
}
