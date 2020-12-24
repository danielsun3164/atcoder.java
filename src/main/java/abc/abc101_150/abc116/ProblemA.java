package abc.abc101_150.abc116;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int ab = scanner.nextInt(), bc = scanner.nextInt();
			@SuppressWarnings("unused")
			int ac = scanner.nextInt();
			System.out.println(ab * bc / 2);
		}
	}
}
