package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem073 {

	/** aを表す文字 */
	private static final char A = 'a';
	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = IntStream.range(0, n).map(i -> scanner.next().charAt(0) - A).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			long[][] dp = new long[n][3];
			dfs(c, edges, dp, 0, 0);
			System.out.println(dp[0][2]);
		}
	}

	/**
	 * dpを再帰的に計算する
	 *
	 * @param c     各ノードの文字の一覧（0：'a'、1：'b'）
	 * @param edges 辺の一覧の配列
	 * @param dp    各ノードのケース数
	 * @param prev  直前計算するノード
	 * @param now   現在計算するノード
	 */
	private static void dfs(int[] c, List<Integer>[] edges, long[][] dp, int prev, int now) {
		long[] value = new long[2];
		Arrays.fill(value, 1L);
		for (int next : edges[now]) {
			if (next != prev) {
				dfs(c, edges, dp, now, next);
				value[0] = value[0] * (dp[next][c[now]] + dp[next][2]) % MOD;
				value[1] = value[1] * (dp[next][0] + dp[next][1] + 2L * dp[next][2]) % MOD;
			}
		}
		dp[now][c[now]] = value[0];
		dp[now][2] = (value[1] - value[0] + MOD) % MOD;
	}
}
