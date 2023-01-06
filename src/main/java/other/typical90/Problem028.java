package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem028 {

	/** xとyの最大値 */
	private static final int N = 1000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] dp = new int[N + 1][N + 1];
			IntStream.rangeClosed(0, N).forEach(i -> Arrays.fill(dp[i], 0));
			IntStream.range(0, n).forEach(i -> {
				int lx = scanner.nextInt(), ly = scanner.nextInt(), rx = scanner.nextInt(), ry = scanner.nextInt();
				dp[lx][ly]++;
				dp[lx][ry]--;
				dp[rx][ly]--;
				dp[rx][ry]++;
			});
			IntStream.rangeClosed(0, N)
					.forEach(x -> IntStream.rangeClosed(1, N).forEach(y -> dp[x][y] += dp[x][y - 1]));
			IntStream.rangeClosed(1, N)
					.forEach(x -> IntStream.rangeClosed(0, N).forEach(y -> dp[x][y] += dp[x - 1][y]));
			int[] counts = new int[n + 1];
			Arrays.fill(counts, 0);
			IntStream.rangeClosed(0, N).forEach(x -> IntStream.rangeClosed(0, N).forEach(y -> counts[dp[x][y]]++));
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(1, n).forEach(i -> sb.append(counts[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
