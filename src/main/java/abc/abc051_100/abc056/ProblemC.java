package abc.abc051_100.abc056;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextLong();
			System.out.println((int) Math.ceil((Math.sqrt(8 * x + 1) - 1.0) / 2.0));
		}
	}
}
