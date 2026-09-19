package abc.abc201_250.abc241;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3472 の解法2の実装
 */
public class ProblemE別回答1 {

	/**  */
	private static final int N = 40;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			long[][] dp = new long[N][n];
			IntStream.range(0, n).forEach(i -> dp[0][i] = scanner.nextLong());
			IntStream.range(0, N - 1).forEach(i -> IntStream.range(0, n)
					.forEach(j -> dp[i + 1][j] = dp[i][j] + dp[i][(int) ((j + dp[i][j]) % n)]));
			long answer = 0L;
			for (int i = 0; i < N; i++) {
				if (0 != (k & (1L << i))) {
					answer += dp[i][(int) (answer % n)];
				}
			}
			System.out.println(answer);
		}
	}
}
