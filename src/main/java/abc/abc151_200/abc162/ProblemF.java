package abc.abc151_200.abc162;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = n >> 1, p = 2 + (1 & n);
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[][] dp = new long[m + 1][p];
			IntStream.range(0, m).forEach(i -> Arrays.fill(dp[i], 0L));
			IntStream.rangeClosed(1, m)
					.forEach(i -> IntStream.range(0, p).forEach(
							j -> dp[i][j] = IntStream.rangeClosed(0, j).mapToLong(k -> dp[i - 1][k]).max().getAsLong()
									+ a[(i - 1) * 2 + j]));
			System.out.println(IntStream.range(0, p).mapToLong(j -> dp[m][j]).max().getAsLong());
		}
	}
}
