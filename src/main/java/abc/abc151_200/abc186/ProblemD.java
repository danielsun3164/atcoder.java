package abc.abc151_200.abc186;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).boxed().sorted((x, y) -> Integer.compare(y, x))
					.mapToInt(i -> i).toArray();
			long[] sum = new long[n];
			sum[0] = a[0];
			IntStream.range(1, n).forEach(i -> sum[i] = sum[i - 1] + a[i]);
			System.out.println(
					IntStream.range(0, n - 1).mapToLong(i -> a[i] * (long) (n - i - 1) - (sum[n - 1] - sum[i])).sum());
		}
	}
}
