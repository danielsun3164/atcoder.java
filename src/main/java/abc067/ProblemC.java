package abc067;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			// sum[i]=a[0]+...+a[i]
			long[] sum = new long[n];
			sum[0] = a[0];
			IntStream.range(1, n).forEach(i -> sum[i] = sum[i - 1] + a[i]);
			System.out.println(
					IntStream.range(0, n - 1).mapToLong(i -> Math.abs(sum[n - 1] - 2 * sum[i])).min().getAsLong());
		}
	}
}
