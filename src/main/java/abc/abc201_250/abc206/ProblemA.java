package abc.abc201_250.abc206;

import java.util.Scanner;

public class ProblemA {

	/** 定価 */
	private static final int N = 206;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int p = (n * 108) / 100;
			System.out.println((N == p) ? "so-so" : ((p > N) ? ":(" : "Yay!"));
		}
	}
}
