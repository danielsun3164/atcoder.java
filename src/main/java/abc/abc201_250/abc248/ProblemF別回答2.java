package abc.abc201_250.abc248;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://blog.hamayanhamayan.com/entry/2022/04/16/234841 の実装
 */
public class ProblemF別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), p = scanner.nextInt();
			long[][][] dp = new long[n + 1][n + 2][2];
			dp[1][0][1] = dp[1][1][0] = 1;
			IntStream.range(1, n).forEach(i -> IntStream.range(0, n).forEach(del -> {
				// 2 del -> 上だけを残す
				dp[i + 1][del + 2][0] = (dp[i + 1][del + 2][0] + dp[i][del][1]) % p;
				dp[i + 1][del + 2][0] = (dp[i + 1][del + 2][0] + dp[i][del][1]) % p;

				// 1 del -> 上と縦を残す
				dp[i + 1][del + 1][1] = (dp[i + 1][del + 1][1] + dp[i][del][1]) % p;
				dp[i + 1][del + 1][1] = (dp[i + 1][del + 1][1] + dp[i][del][1]) % p;

				// 1 del -> 上下を残す
				dp[i + 1][del + 1][1] = (dp[i + 1][del + 1][1] + dp[i][del][1]) % p;
				dp[i + 1][del + 1][0] = (dp[i + 1][del + 1][0] + dp[i][del][0]) % p;

				// 0 del -> 全部残す
				dp[i + 1][del][1] = (dp[i + 1][del][1] + dp[i][del][0]) % p;
				dp[i + 1][del][1] = (dp[i + 1][del][1] + dp[i][del][1]) % p;
			}));
			System.out.println(
					IntStream.range(1, n).mapToObj(i -> String.valueOf(dp[n][i][1])).collect(Collectors.joining(" ")));
		}
	}
}
