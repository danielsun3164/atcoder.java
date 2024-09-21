package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem019 {

	/** 色の種類 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] count = new long[N + 1];
			Arrays.fill(count, 0L);
			IntStream.range(0, n).forEach(i -> count[scanner.nextInt()]++);
			System.out.println(IntStream.rangeClosed(1, N).mapToLong(i -> count[i] * (count[i] - 1) / 2L).sum());
		}
	}
}
