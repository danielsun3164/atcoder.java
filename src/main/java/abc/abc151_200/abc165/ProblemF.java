package abc.abc151_200.abc165;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] edgesList = new List[n];
			IntStream.range(0, n).forEach(i -> edgesList[i] = new ArrayList<>());
			IntStream.range(1, n).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edgesList[u].add(v);
				edgesList[v].add(u);
			});
			Integer[] dp = new Integer[n];
			int[] answer = new int[n];
			answer[0] = 0;
			Arrays.fill(dp, INF);
			dfs(n, a, edgesList, dp, answer, 0, 0);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 結果を再帰的に計算する
	 *
	 * @param n         頂点の数
	 * @param a         整数の配列
	 * @param edgesList 辺の一覧の配列
	 * @param dp        長さがiである増加部分列における最終要素の最小値の配列
	 * @param answer    結果の配列
	 * @param now       現在処理中の頂点
	 * @param prev      直前に処理した頂点
	 */
	private static void dfs(int n, int[] a, List<Integer>[] edgesList, Integer[] dp, int[] answer, int now, int prev) {
		// dpに入れる値をupper_boundで検索する
		int index = ~Arrays.binarySearch(dp, a[now], (x, y) -> (x.compareTo(y) >= 0) ? 1 : -1);
		// dpの値を保存する
		int oldDp = dp[index];
		dp[index] = a[now];
		answer[now] = Math.max(answer[prev], index + 1);
		for (int next : edgesList[now]) {
			if (next != prev) {
				dfs(n, a, edgesList, dp, answer, next, now);
			}
		}
		// dpの値を復元する
		dp[index] = oldDp;
	}
}
