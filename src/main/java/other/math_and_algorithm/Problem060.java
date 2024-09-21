package other.math_and_algorithm;

import java.util.Scanner;

public class Problem060 {

	/** 4 */
	private static final int N = 4;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println((0L == n % N) ? "Second" : "First");
		}
	}
}
