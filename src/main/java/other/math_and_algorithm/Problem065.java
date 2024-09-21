package other.math_and_algorithm;

import java.util.Scanner;

public class Problem065 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long h = scanner.nextLong(), w = scanner.nextLong();
			System.out.println(((1 == w) || (1 == h)) ? 1 : (h * w + 1) >> 1);
		}
	}
}
