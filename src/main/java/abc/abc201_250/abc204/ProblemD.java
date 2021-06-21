package abc.abc201_250.abc204;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] t = new int[n];
			int tSum = IntStream.range(0, n).map(i -> t[i] = scanner.nextInt()).sum();
			boolean[][] dp = new boolean[n + 1][tSum + 1];
			IntStream.rangeClosed(0, n).forEach(i -> Arrays.fill(dp[i], false));
			dp[0][0] = true;
			IntStream.range(0, n).forEach(i -> IntStream.rangeClosed(0, tSum).filter(j -> dp[i][j])
					.forEach(j -> dp[i + 1][j] = dp[i + 1][j + t[i]] = true));
			System.out.println(IntStream.rangeClosed(0, tSum).filter(j -> dp[n][j]).map(j -> Math.max(j, tSum - j))
					.min().getAsInt());
		}
	}
}
