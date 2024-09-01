package abc.abc201_250.abc224;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			System.out.println(IntStream.range(0, n).map(i -> IntStream.range(i + 1, n).map(j -> {
				long dx1 = x[j] - x[i], dy1 = y[j] - y[i];
				return (int) IntStream.range(j + 1, n).filter(k -> {
					long dx2 = x[k] - x[i], dy2 = y[k] - y[i];
					return dx1 * dy2 != dx2 * dy1;
				}).count();
			}).sum()).sum());
		}
	}
}
