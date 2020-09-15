package abc.abc052;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通り実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long a = scanner.nextLong(), b = scanner.nextLong();
			int[] x = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(IntStream.range(1, n).mapToLong(i -> Math.min((x[i] - x[i - 1]) * a, b)).sum());
		}
	}
}
