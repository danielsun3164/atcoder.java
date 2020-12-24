package abc.abc101_150.abc132;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc132/submissions/6444001 にも参考
 */
public class ProblemF {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			Set<Integer> set = new HashSet<>();
			set.add(0);
			for (int i = 1; i * i <= n; i++) {
				set.add(i);
				set.add(n / i);
			}
			int[] factors = set.stream().sorted().mapToInt(i -> i).toArray();
			int f = set.size();
			long[][] dp = new long[k][f];
			IntStream.range(0, k).forEach(i -> dp[i][0] = 0L);
			IntStream.range(1, f).forEach(i -> dp[0][i] = factors[i]);
			IntStream.range(1, k).forEach(i -> IntStream.range(1, f).forEach(
					j -> dp[i][j] = (dp[i][j - 1] + dp[i - 1][f - j] * (factors[j] - factors[j - 1]) % MOD) % MOD));
			System.out.println(dp[k - 1][f - 1]);
		}
	}
}
