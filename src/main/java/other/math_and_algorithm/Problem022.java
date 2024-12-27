package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem022 {

	/** 目標値 */
	private static final int N = 100_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] count = new long[N + 1];
			IntStream.range(0, n).forEach(i -> count[scanner.nextInt()]++);
			System.out.println(IntStream.range(0, N >> 1).mapToLong(i -> count[i] * count[N - i]).sum()
					+ count[N >> 1] * (count[N >> 1] - 1) / 2L);
		}
	}
}
