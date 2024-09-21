package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem070 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			long[] sortedX = Arrays.stream(x).sorted().distinct().toArray(),
					sortedY = Arrays.stream(y).sorted().distinct().toArray();
			int sx = sortedX.length, sy = sortedY.length;
			System.out.println(IntStream.range(0, sx)
					.mapToLong(xi -> IntStream.range(xi + 1, sx)
							.mapToLong(xj -> IntStream.range(0, sy).mapToLong(yi -> IntStream.range(yi + 1, sy)
									.filter(yj -> IntStream.range(0, n)
											.filter(i -> (x[i] >= sortedX[xi]) && (x[i] <= sortedX[xj])
													&& (y[i] >= sortedY[yi]) && (y[i] <= sortedY[yj]))
											.count() >= k)
									.mapToLong(yj -> (sortedX[xj] - sortedX[xi]) * (sortedY[yj] - sortedY[yi])).min()
									.orElse(INF)).min().orElse(INF))
							.min().orElse(INF))
					.min().getAsLong());
		}
	}
}
