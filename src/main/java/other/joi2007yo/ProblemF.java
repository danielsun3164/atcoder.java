package other.joi2007yo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), n = scanner.nextInt();
			int[][] dp = new int[a][b];
			IntStream.range(0, a).forEach(i -> Arrays.fill(dp[i], -1));
			IntStream.range(0, n).forEach(i -> dp[scanner.nextInt() - 1][scanner.nextInt() - 1] = 0);
			dp[0][0] = 1;
			IntStream.range(0, a).forEach(i -> IntStream.range(0, b).filter(j -> dp[i][j] < 0)
					.forEach(j -> dp[i][j] = ((i > 0) ? dp[i - 1][j] : 0) + ((j > 0) ? dp[i][j - 1] : 0)));
			System.out.println(dp[a - 1][b - 1]);
		}
	}
}
