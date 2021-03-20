package abc.abc101_150.abc139;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			// n(n-1)/2
			System.out.println(n * (n - 1) / 2L);
		}
	}
}
