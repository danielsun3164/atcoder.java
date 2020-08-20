package abc100;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	/** ケースごとの数値の種類 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long[] x = new long[n], y = new long[n], z = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
				z[i] = scanner.nextLong();
			});
			System.out.println(IntStream.range(0, 1 << N)
					.mapToLong(i -> IntStream.range(0, n)
							.mapToLong(j -> (((i & 1) > 0) ? -1 : 1) * x[j] + ((((i >> 1) & 1) > 0) ? -1 : 1) * y[j]
									+ ((((i >> 2) & 1) > 0) ? -1 : 1) * z[j])
							.sorted().skip(n - m).sum())
					.max().getAsLong());
		}
	}
}
