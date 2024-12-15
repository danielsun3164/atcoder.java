package abc.abc201_250.abc238;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			if (n < Long.SIZE - 1) {
				System.out.println(((1L << n) > n * n) ? "Yes" : "No");
			} else {
				System.out.println("Yes");
			}
		}
	}
}
