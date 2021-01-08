package abc.abc051_100.abc075;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			long answer = Long.MAX_VALUE;
			int[] sortedX = x.clone();
			int[] sortedY = y.clone();
			Arrays.sort(sortedX);
			Arrays.sort(sortedY);
			for (int xi = 0; xi < n; xi++) {
				for (int xj = xi + 1; xj < n; xj++) {
					for (int yi = 0; yi < n; yi++) {
						for (int yj = yi + 1; yj < n; yj++) {
							int count = 0;
							for (int i = 0; i < n; i++) {
								if ((sortedX[xi] <= x[i]) && (x[i] <= sortedX[xj]) && (sortedY[yi] <= y[i])
										&& (y[i] <= sortedY[yj])) {
									count++;
								}
							}
							if (count >= k) {
								answer = Math.min(answer,
										1L * (sortedX[xj] - sortedX[xi]) * (sortedY[yj] - sortedY[yi]));
							}
						}
					}
				}
			}
			System.out.println(answer);
		}
	}
}
