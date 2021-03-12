package abc.abc101_150.abc142;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((n / 2 + (n & 1)) * 1.0d / n);
		}
	}
}
