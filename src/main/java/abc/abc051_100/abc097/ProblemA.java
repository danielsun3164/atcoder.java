package abc.abc051_100.abc097;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
			System.out.println(
					((Math.abs(a - c) <= d) || ((Math.abs(a - b) <= d) && (Math.abs(b - c) <= d))) ? "Yes" : "No");
		}
	}
}
