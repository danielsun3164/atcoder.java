package other.math_and_algorithm;

import java.util.Scanner;

public class Problem079 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println(n * (n - 1) / 2);
		}
	}
}
