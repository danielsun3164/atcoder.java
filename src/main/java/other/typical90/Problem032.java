package other.typical90;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Problem032 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] a = new int[n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> a[i][j] = scanner.nextInt()));
			int m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Set<Integer>[] ngSets = new Set[n];
			IntStream.range(0, n).forEach(i -> ngSets[i] = new HashSet<>());
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
				ngSets[x].add(y);
				ngSets[y].add(x);
			});
			int answer = dfs(n, a, ngSets, new ArrayList<>(), 0);
			System.out.println((INF == answer) ? -1 : answer);
		}
	}

	/**
	 * 各区間を各選手で走った場合の最小時間を計算する
	 *
	 * @param n      区間数
	 * @param a      各選手の各区間の時間
	 * @param ngSets 仲が悪い選手の一覧
	 * @param order  出場順のリスト
	 * @param index  現在計算している区間の番号
	 * @return 各区間を各選手で走った場合の最小時間
	 */
	private static int dfs(int n, int[][] a, Set<Integer>[] ngSets, List<Integer> order, int index) {
		if (n == index) {
			return IntStream.range(0, n).map(i -> a[order.get(i)][i]).sum();
		}
		int result = INF;
		for (int i = 0; i < n; i++) {
			if (((0 == index) || !ngSets[order.get(index - 1)].contains(i)) && !order.contains(i)) {
				order.add(i);
				result = Math.min(result, dfs(n, a, ngSets, order, index + 1));
				order.remove(index);
			}
		}
		return result;
	}
}
