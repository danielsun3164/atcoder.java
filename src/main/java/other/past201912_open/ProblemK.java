package other.past201912_open;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 行きがけ順での実装
 * 
 * https://atcoder.jp/contests/past201912-open/submissions/14683801 を参考に作成
 */
public class ProblemK {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] subordinates = new List[n];
			IntStream.range(0, n).forEach(i -> subordinates[i] = new ArrayList<>());
			int root = 0;
			for (int i = 0; i < n; i++) {
				int p = scanner.nextInt() - 1;
				if (p != -2) {
					subordinates[p].add(i);
				} else {
					root = i;
				}
			}
			Range[] ranges = IntStream.range(0, n).mapToObj(i -> new Range()).toArray(Range[]::new);
			dfs(subordinates, ranges, root, 0);
			int q = scanner.nextInt();
			IntStream.range(0, q).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				System.out.println(
						((ranges[b].start < ranges[a].start) && (ranges[a].end < ranges[b].end)) ? "Yes" : "No");
			});
		}
	}

	/**
	 * 現在の人の保存範囲を計算
	 * 
	 * @param subordinates 部下の一覧
	 * @param ranges       範囲の一覧
	 * @param now          現在の人
	 * @param index        現在のインデックス
	 */
	private static int dfs(final List<Integer>[] subordinates, final Range[] ranges, int now, int index) {
		ranges[now].start = index++;
		for (Integer i : subordinates[now]) {
			index = dfs(subordinates, ranges, i, index);
		}
		ranges[now].end = index++;
		return index;
	}

	/**
	 * 範囲を保存するクラス
	 */
	private static class Range {
		int start;
		int end;

		Range() {
			super();
		}
	}
}
