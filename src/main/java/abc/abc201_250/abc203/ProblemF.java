package abc.abc201_250.abc203;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** 高橋が操作する最大回数 */
	private static final int N = 31;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			// f[i]はA_j <= A_i/2の最大のj
			int[] f = new int[n + 1];
			int count = 0;
			for (int i = 1; i <= n; i++) {
				while (a[count] <= (a[i - 1] / 2)) {
					count++;
				}
				f[i] = count;
			}
			int[][] dp = new int[n + 1][N + 1];
			Arrays.fill(dp[0], 0);
			IntStream.rangeClosed(1, n).forEach(i -> dp[i][0] = i);
			IntStream.rangeClosed(1, n).forEach(i -> IntStream.rangeClosed(1, N)
					.forEach(j -> dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[f[i]][j - 1])));
			int min = IntStream.rangeClosed(0, N).filter(i -> dp[n][i] <= k).findFirst().getAsInt();
			System.out.println(min + " " + dp[n][min]);
		}
	}
}
