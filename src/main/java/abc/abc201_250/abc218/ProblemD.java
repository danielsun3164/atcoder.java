package abc.abc201_250.abc218;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemD {

	/** intのbit数 */
	private static final int N = Integer.SIZE;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			Set<Long> set = new HashSet<>();
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
				set.add(x[i] << N | y[i]);
			});
			System.out
					.println(IntStream.range(0, n)
							.mapToLong(i -> IntStream
									.range(i + 1, n).filter(j -> (x[i] != x[j]) && (y[i] != y[j])
											&& set.contains(x[i] << N | y[j]) && set.contains(x[j] << N | y[i]))
									.count())
							.sum() >> 1);
		}
	}
}
