package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem066 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			System.out
					.println(n * (long) n * n - IntStream.rangeClosed(1, n)
							.mapToLong(a -> IntStream.rangeClosed(Math.max(1, a - (k - 1)), Math.min(n, a + (k - 1)))
									.mapToLong(b -> IntStream
											.rangeClosed(Math.max(1, a - (k - 1)), Math.min(n, a + (k - 1)))
											.filter(c -> Math.abs(b - c) < k).count())
									.sum())
							.sum());
		}
	}
}
