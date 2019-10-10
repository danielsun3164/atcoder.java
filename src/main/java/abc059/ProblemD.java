package abc059;

import java.util.Scanner;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextLong();
			long y = scanner.nextLong();
			System.out.println((Math.abs(x - y) <= 1) ? "Brown" : "Alice");
		}
	}
}
