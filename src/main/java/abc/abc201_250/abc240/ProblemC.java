package abc.abc201_250.abc240;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			boolean[][] dp = new boolean[2][x + 1];
			Arrays.fill(dp[0], false);
			dp[0][0] = true;
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(dp[(i + 1) & 1], false);
				IntStream.range(0, x).filter(j -> dp[i & 1][j]).forEach(j -> {
					if (j + a[i] <= x) {
						dp[(i + 1) & 1][j + a[i]] = true;
					}
					if (j + b[i] <= x) {
						dp[(i + 1) & 1][j + b[i]] = true;
					}
				});
			});
			System.out.println(dp[n & 1][x] ? "Yes" : "No");
		}
	}
}
