package abc.abc101_150.abc107;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), i = scanner.nextInt();
			System.out.println(n + 1 - i);
		}
	}
}
