package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem031 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray(), dp = new long[n],
					max = new long[n];
			Arrays.fill(dp, 0L);
			dp[0] = max[0] = a[0];
			dp[1] = a[1];
			max[1] = Math.max(max[0], dp[1]);
			IntStream.range(2, n).forEach(i -> {
				dp[i] = max[i - 2] + a[i];
				max[i] = Math.max(max[i - 1], dp[i]);
			});
			System.out.println(max[n - 1]);
		}
	}
}
