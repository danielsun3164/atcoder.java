package other.math_and_algorithm;

import java.util.Scanner;

public class Problem006 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((n << 1) + 3);
		}
	}
}
