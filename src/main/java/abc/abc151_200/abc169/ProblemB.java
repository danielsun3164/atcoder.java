package abc.abc151_200.abc169;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 10^18 */
	private static final BigInteger BIG = BigInteger.valueOf(1_000_000_000_000_000_000L);

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n];
			if (IntStream.range(0, n).mapToLong(i -> a[i] = scanner.nextLong()).filter(i -> i == 0L).count() > 0) {
				System.out.println(0);
				return;
			}
			BigInteger result = BigInteger.ONE;
			for (int i = 0; i < n; i++) {
				result = result.multiply(BigInteger.valueOf(a[i]));
				if (result.compareTo(BIG) > 0) {
					System.out.println(-1);
					return;
				}
			}
			System.out.println(result);
		}
	}
}
