package abc.abc172;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			long[] a = new long[n + 1], b = new long[m + 1];
			a[0] = b[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = a[i - 1] + scanner.nextLong());
			IntStream.rangeClosed(1, m).forEach(i -> b[i] = b[i - 1] + scanner.nextLong());
			int answer = 0;
			for (int i = 0; i <= n; i++) {
				if (a[i] > k) {
					break;
				}
				int index = Arrays.binarySearch(b, k - a[i]);
				if (index < 0) {
					index = -index - 2;
				}
				answer = Math.max(answer, i + index);
			}
			System.out.println(answer);
		}
	}
}
