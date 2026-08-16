package abc.abc201_250.abc239;

import java.util.Scanner;

public class ProblemB {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextLong();
			boolean minus = x < 0;
			x = Math.abs(x);
			System.out.println((minus ? "-" : "") + (minus ? (x + TEN - 1) / TEN : x / TEN));
		}
	}
}
