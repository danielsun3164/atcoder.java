package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem098 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			long a = scanner.nextLong(), b = scanner.nextLong();
			System.out.println((1 == (1 & IntStream.range(0, n).filter(i -> {
				long xa = x[i] - a, ya = y[i] - b, xb = x[(i + 1) % n] - a, yb = y[(i + 1) % n] - b;
				if (ya > yb) {
					long temp = xa;
					xa = xb;
					xb = temp;
					temp = ya;
					ya = yb;
					yb = temp;
				}
				return (ya <= 0L) && (0L < yb) && (xa * yb - xb * ya < 0L);
			}).count())) ? "INSIDE" : "OUTSIDE");
		}
	}
}
