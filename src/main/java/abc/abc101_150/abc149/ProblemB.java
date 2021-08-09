package abc.abc101_150.abc149;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), k = scanner.nextLong();
			System.out.println((a >= k) ? (a - k) + " " + b : "0 " + Math.max(0, b - (k - a)));
		}
	}
}
