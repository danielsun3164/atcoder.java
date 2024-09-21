package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem077 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			Arrays.sort(x);
			Arrays.sort(y);
			System.out.println(IntStream.range(0, n).mapToLong(i -> x[i] * (i * 2 - (n - 1))).sum()
					+ IntStream.range(0, n).mapToLong(i -> y[i] * (i * 2 - (n - 1))).sum());
		}
	}
}
