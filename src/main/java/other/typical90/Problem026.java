package other.typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem026 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				childrens[a].add(b);
				childrens[b].add(a);
			});
			int[] colors = new int[n], counts = new int[2];
			Arrays.fill(colors, -1);
			Arrays.fill(counts, 0);
			dfs(childrens, colors, counts, 0, 0);
			IntStream.range(0, 2).filter(color -> counts[color] >= n >> 1).limit(1)
					.forEach(color -> System.out
							.println(IntStream.range(0, n).filter(i -> colors[i] == color).limit(n >> 1).map(i -> i + 1)
									.mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()))));
		}
	}

	/**
	 * すべてのノードに色と色の数を記入する
	 *
	 * @param childrens 辺の一覧
	 * @param colors    色を保存する配列
	 * @param counts    各色の個数を保存する配列
	 * @param now       現在の処理対象のノード
	 * @param color     現在の処理対象の色
	 */
	private static void dfs(List<Integer>[] childrens, int[] colors, int[] counts, int now, int color) {
		colors[now] = color;
		counts[color]++;
		for (int next : childrens[now]) {
			if (-1 == colors[next]) {
				dfs(childrens, colors, counts, next, 1 - color);
			}
		}
	}
}
