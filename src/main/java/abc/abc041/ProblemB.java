package abc.abc041;

import java.util.Scanner;

public class ProblemB {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
			System.out.println(a * b % MOD * c % MOD);
		}
	}
}
