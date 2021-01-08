package abc.abc101_150.abc130;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			int[] a = new int[n];
			long[] sum = new long[n + 1];
			sum[0] = 0L;
			IntStream.range(0, n).forEach(i -> sum[i + 1] = sum[i] + (a[i] = scanner.nextInt()));
			long result = 0L;
			for (int i = n; i >= 0; i--) {
				if (sum[i] < k) {
					break;
				}
				int index = Arrays.binarySearch(sum, 0, i, sum[i] - k);
				index = (index < 0) ? ~index - 1 : index;
				result += (index + 1);
			}
			System.out.println(result);
		}
	}
}
