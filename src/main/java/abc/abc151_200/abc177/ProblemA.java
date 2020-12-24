package abc.abc151_200.abc177;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int d = scanner.nextInt(), t = scanner.nextInt(), s = scanner.nextInt();
			System.out.println((d <= t * s) ? "Yes" : "No");
		}
	}
}
