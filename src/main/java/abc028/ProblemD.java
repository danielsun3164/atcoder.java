package abc028;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			System.out.println(((double) (n - k) / n * (k - 1) / n * 6.0d + ((n - 1) * 3.0d / n + 1.0d / n) / n) / n);
		}
	}
}
