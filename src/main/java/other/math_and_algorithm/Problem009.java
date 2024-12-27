package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem009 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), s = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] dp = new int[s + 1];
			Arrays.fill(dp, 0);
			dp[0] = 1;
			IntStream.range(0, n).forEach(i -> IntStream.rangeClosed(0, s - a[i]).map(j -> s - a[i] - j)
					.filter(j -> dp[j] > 0).forEach(j -> dp[j + a[i]] += dp[j]));
			System.out.println((dp[s] > 0) ? "Yes" : "No");
		}
	}
}
