package abc.abc048;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			long x = scanner.nextLong();
			System.out.println((0 == a) ? b / x + 1 : b / x - (a - 1) / x);
		}
	}
}
