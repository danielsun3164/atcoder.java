package abc.abc201_250.abc233;

import java.util.Scanner;

public class ProblemA {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			System.out.println((x >= y) ? 0 : (y - x + TEN - 1) / TEN);
		}
	}
}
