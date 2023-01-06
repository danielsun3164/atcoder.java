package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem018 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt(), l = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			// 中心点
			double by = 0.0d, bz = l / 2.0d, r = l / 2.0d;
			int q = scanner.nextInt();
			IntStream.range(0, q).forEach(i -> {
				int e = scanner.nextInt();
				double angle = (e * 2.0 * Math.PI) / t;
				double ny = by - (r * Math.sin(angle)), nz = bz - (r * Math.cos(angle));
				System.out.println(Math.toDegrees(Math.atan2(nz, Math.hypot(ny - y, x))));
			});
		}
	}
}
