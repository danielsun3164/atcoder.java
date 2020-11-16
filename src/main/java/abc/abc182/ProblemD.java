package abc.abc182;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// sum[i]=a[0]+...a[i-1]、max[i]=max(sum[0],...,sum[i])、sumSum[i]=sum[0]+...+sum[i]
			long[] sum = new long[n + 1], max = new long[n + 1], sumSum = new long[n + 1];
			sum[0] = max[0] = sumSum[0] = 0L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				sum[i] = sum[i - 1] + a[i - 1];
				max[i] = Math.max(max[i - 1], sum[i]);
				sumSum[i] = sumSum[i - 1] + sum[i];
			});
			System.out.println(IntStream.rangeClosed(1, n).mapToLong(i -> sumSum[i - 1] + max[i]).max().getAsLong());
		}
	}
}
