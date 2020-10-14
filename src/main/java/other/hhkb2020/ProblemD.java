package other.hhkb2020;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			IntStream.range(0, t).forEach(i -> {
				long n = scanner.nextLong(), a = scanner.nextLong(), b = scanner.nextLong();
				long c = (n - a + 1) * (n - b + 1) % MOD;
				long result = c * c % MOD;
				long d = (n >= a + b) ? (n - a - b + 2) * (n - a - b + 1) % MOD : 0;
				result = (result - (c - d) * (c - d) % MOD) % MOD;
				System.out.println((result + MOD) % MOD);
			});
		}
	}
}
