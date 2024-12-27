package other.math_and_algorithm;

import java.util.Scanner;

public class Problem063 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((0 == (1 & n)) ? "Yes" : "No");
		}
	}
}
