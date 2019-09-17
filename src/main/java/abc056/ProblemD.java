package abc056;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード<br/>
 * https://atcoder.jp/contests/abc056/submissions/4757789 と https://atcoder.jp/contests/abc056/submissions/3511073 にも参照
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			if (1 == n) {
				System.out.println((k > a[0]) ? 1 : 0);
				return;
			}
			Arrays.sort(a);

			int ng = 0, ok = n + 1;
			while (ok - ng > 1) {
				int mid = (ok + ng) / 2;
				if (isNeeded(mid, n, k, a)) {
					ok = mid;
				} else {
					ng = mid;
				}
			}
			System.out.println(ng);
		}
	}

	/**
	 * @param now
	 * @param n
	 * @param k
	 * @param a
	 * @return now番目のカードが必要かどうか
	 */
	private static boolean isNeeded(int now, final int n, final int k, final int[] a) {
		boolean[][] dp = new boolean[n + 1][k + 1];
		IntStream.range(0, n + 1).forEach(i -> Arrays.fill(dp[i], false));
		dp[0][0] = true;
		IntStream.rangeClosed(1, n).forEach(i -> IntStream.rangeClosed(0, k).forEach(j -> {
			if (i == now) {
				// ぬくカードの場合
				dp[i][j] = dp[i - 1][j];
			} else {
				if (dp[i - 1][j]) {
					dp[i][j] = true;
					if (j + a[i - 1] <= k) {
						dp[i][j + a[i - 1]] = true;
					}
				}
			}
		}));
		for (int i = k - 1; i >= Math.max(k - a[now - 1], 0); i--) {
			if (dp[n][i]) {
				return true;
			}
		}
		return false;
	}
}
