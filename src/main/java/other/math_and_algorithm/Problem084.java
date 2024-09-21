package other.math_and_algorithm;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class Problem084 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
			if (c - a - b < 0L) {
				System.out.println("No");
				return;
			}
			System.out.println(((c - a - b) * (c - a - b) > 4 * a * b) ? "Yes" : "No");
		}
	}
}
