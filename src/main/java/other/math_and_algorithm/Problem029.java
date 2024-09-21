package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem029 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] dp = new long[n + 1];
			dp[0] = dp[1] = 1L;
			IntStream.rangeClosed(2, n).forEach(i -> dp[i] = dp[i - 1] + dp[i - 2]);
			System.out.println(dp[n]);
		}
	}
}
