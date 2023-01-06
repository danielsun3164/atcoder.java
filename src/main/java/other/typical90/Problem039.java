package other.typical90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem039 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] dp = new int[n];
			dfs(edges, dp, 0, 0);
			System.out.println(IntStream.range(0, n).mapToLong(i -> dp[i] * (long) (n - dp[i])).sum());
		}
	}

	/**
	 * 子供の頂点数の配列を計算する
	 *
	 * @param edges 辺の一覧
	 * @param dp    子供の頂点数の配列
	 * @param now   現在の頂点
	 * @param prev  直前の頂点
	 */
	private static void dfs(List<Integer>[] edges, int[] dp, int now, int prev) {
		dp[now] = 1;
		edges[now].stream().filter(next -> next != prev).forEach(next -> {
			dfs(edges, dp, next, now);
			dp[now] += dp[next];
		});
	}
}
