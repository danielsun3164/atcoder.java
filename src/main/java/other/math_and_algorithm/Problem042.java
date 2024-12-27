package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem042 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n + 1];
			Arrays.fill(a, 1L);
			IntStream.rangeClosed(2, n).forEach(i -> {
				for (int j = i; j <= n; j += i) {
					a[j]++;
				}
			});
			System.out.println(IntStream.rangeClosed(1, n).mapToLong(i -> a[i] * i).sum());
		}
	}
}
