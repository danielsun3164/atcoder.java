package abc.abc101_150.abc148;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc148/submissions/11686160 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				childrens[a].add(b);
				childrens[b].add(a);
			});
			int[][] depths = new int[2][n];
			dfs(u, -1, childrens, depths[0], 0);
			dfs(v, -1, childrens, depths[1], 0);
			System.out.println(IntStream.range(0, n).filter(i -> depths[0][i] < depths[1][i]).map(i -> depths[1][i] - 1)
					.max().orElse(0));
		}
	}

	/**
	 * 深さを設定する
	 *
	 * @param now       現在設定するノード
	 * @param from      遷移元ノード
	 * @param childrens 子供の一覧
	 * @param depths    深さを保存する配列
	 * @param depth     現在の深さ
	 */
	private static void dfs(int now, int from, List<Integer>[] childrens, int[] depths, int depth) {
		depths[now] = depth;
		for (int next : childrens[now]) {
			if (from != next) {
				dfs(next, now, childrens, depths, depth + 1);
			}
		}
	}
}
