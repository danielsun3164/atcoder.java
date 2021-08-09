package abc.abc201_250.abc206;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://blog.hamayanhamayan.com/entry/2021/06/19/233919 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int l = scanner.nextInt(), r = scanner.nextInt();
			long[] count = new long[r + 1];
			for (int i = r; i >= 2; i--) {
				long c = (r / i) - ((l - 1) / i);
				count[i] = c * c;
				for (int j = i + i; j <= r; j += i) {
					count[i] -= count[j];
				}
			}
			System.out.println(IntStream.rangeClosed(2, r)
					.mapToLong(i -> count[i] - ((l <= i) ? (2 * ((r / i) - ((l - 1) / i))) - 1 : 0)).sum());
		}
	}
}
