package abc.abc201_250.abc234;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			System.out.println(IntStream
					.range(0, n).mapToDouble(i -> IntStream.range(i + 1, n)
							.mapToDouble(j -> Math.hypot(x[i] - x[j], y[i] - y[j])).max().orElse(0.0d))
					.max().getAsDouble());
		}
	}
}
