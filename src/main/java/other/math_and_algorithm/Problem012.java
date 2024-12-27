package other.math_and_algorithm;

import java.util.Scanner;

public class Problem012 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			for (long i = 2; i * i <= n; i++) {
				if (0 == n % i) {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
		}
	}
}
