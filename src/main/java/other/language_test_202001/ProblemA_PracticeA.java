package other.language_test_202001;

import java.util.Scanner;

public class ProblemA_PracticeA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			String s = scanner.next();
			System.out.println((a + b + c) + " " + s);
		}
	}
}
