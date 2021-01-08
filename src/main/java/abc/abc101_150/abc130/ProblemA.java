package abc.abc101_150.abc130;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), a = scanner.nextInt();
			System.out.println((x < a) ? 0 : 10);
		}
	}
}
