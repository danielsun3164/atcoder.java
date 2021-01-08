package abc.abc151_200.abc187;

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
			System.out
					.println(
							IntStream.range(0, n - 1)
									.map(i -> (int) IntStream.range(i + 1, n)
											.filter(j -> Math.abs(y[j] - y[i]) <= Math.abs(x[j] - x[i])).count())
									.sum());
		}
	}
}
