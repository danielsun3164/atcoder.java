package abc.abc201_250.abc230;

import java.util.Scanner;

public class ProblemA {

	/** 欠番になる数 */
	private static final int N = 42;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println("AGC" + String.format("%03d", (n < N) ? n : n + 1));
		}
	}
}
