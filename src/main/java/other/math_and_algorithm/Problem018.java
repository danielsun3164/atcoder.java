package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem018 {

	/** 500 */
	private static final int N = 500;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] count = new long[N + 1];
			Arrays.fill(count, 0L);
			IntStream.range(0, n).forEach(i -> count[scanner.nextInt()]++);
			System.out.println(IntStream.range(1, N / 2).mapToLong(i -> count[i] * count[N - i]).sum());
		}
	}
}
