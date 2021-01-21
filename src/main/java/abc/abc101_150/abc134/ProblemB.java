package abc.abc101_150.abc134;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt();
			int r = 2 * d + 1;
			System.out.println((n + r - 1) / r);
		}
	}
}
