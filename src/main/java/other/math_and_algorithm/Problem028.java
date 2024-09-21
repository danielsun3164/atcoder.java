package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem028 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] h = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray(), dp = new int[n];
			dp[0] = 0;
			dp[1] = Math.abs(h[1] - h[0]);
			IntStream.range(2, n).forEach(i -> dp[i] = Math.min(dp[i - 1] + Math.abs(h[i] - h[i - 1]),
					dp[i - 2] + Math.abs(h[i] - h[i - 2])));
			System.out.println(dp[n - 1]);
		}
	}
}
