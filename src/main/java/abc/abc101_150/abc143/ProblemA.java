package abc.abc101_150.abc143;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			int diff = a - b * 2;
			System.out.println((diff > 0) ? diff : 0);
		}
	}
}
