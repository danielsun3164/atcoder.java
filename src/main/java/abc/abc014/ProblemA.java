package abc.abc014;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			int reminder = a % b;
			System.out.println((0 == reminder) ? 0 : b - reminder);
		}
	}
}
