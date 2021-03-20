package abc.abc101_150.abc139;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((b - 1 + a - 2) / (a - 1));
		}
	}
}
