package other.language_test_202001;

import java.util.Scanner;

public class ProblemB_ABC086A {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((1 == (1 & (a * b))) ? "Odd" : "Even");
		}
	}
}
