package abc.abc201_250.abc239;

import java.util.Scanner;

public class ProblemA {

	/** 12800000 */
	private static final int N = 12_800_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double h = scanner.nextDouble();
			System.out.println(Math.sqrt(h * (N + h)));
		}
	}
}
