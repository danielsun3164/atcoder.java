package other.exawizards2019;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/exawizards2019/submissions/5130684 にも参照
 */
public class ProblemD {

	private static final long MOD = 1_000_000_007L;;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			long[][] dp = new long[2][x + 1];
			IntStream.rangeClosed(0, x).forEach(i -> dp[0][i] = i);
			IntStream.rangeClosed(1, n).forEach(i -> IntStream.rangeClosed(0, x).forEach(
					j -> dp[i & 1][j] = (dp[(i - 1) & 1][j] * (i - 1) % MOD + dp[(i - 1) & 1][j % a[i - 1]]) % MOD));
			System.out.println(dp[n & 1][x]);
		}
	}
}
