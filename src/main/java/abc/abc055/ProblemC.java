package abc.abc055;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), m = scanner.nextLong();
			System.out.println((m > 2 * n) ? (m - 2 * n) / 4 + n : m / 2);
		}
	}
}
