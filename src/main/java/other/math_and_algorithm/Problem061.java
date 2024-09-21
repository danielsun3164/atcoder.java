package other.math_and_algorithm;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class Problem061 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println((1 == Long.bitCount(n + 1)) ? "Second" : "First");
		}
	}
}
