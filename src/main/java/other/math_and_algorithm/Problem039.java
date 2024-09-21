package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem039 {

	/** 大きくなることを表す文字 */
	private static final String BIG = ">";
	/** 小さくなることを表す文字 */
	private static final String SMALL = "<";
	/** 同じであることを表す文字 */
	private static final String EQUAL = "=";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			long[] d = new long[n + 1];
			Arrays.fill(d, 0L);
			IntStream.range(0, q).forEach(i -> {
				int l = scanner.nextInt() - 1, r = scanner.nextInt(), x = scanner.nextInt();
				d[l] += x;
				d[r] -= x;
			});
			IntStream.range(1, n).forEach(i -> d[i] += d[i - 1]);
			System.out.println(
					IntStream.range(1, n).mapToObj(i -> (d[i - 1] > d[i]) ? BIG : ((d[i - 1] < d[i]) ? SMALL : EQUAL))
							.collect(Collectors.joining()));
		}
	}
}
