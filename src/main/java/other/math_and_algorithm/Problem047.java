package other.math_and_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem047 {

	/** 白を表す数字 */
	private static final int WHITE = 0;
	/** 青を表す数字 */
	private static final int BLUE = 1;
	/** 青と赤の色の合計値 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			int[] a = new int[m], b = new int[m];
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				edges[a[i]].add(b[i]);
				edges[b[i]].add(a[i]);
			});
			int[] color = new int[n];
			Arrays.fill(color, WHITE);
			IntStream.range(0, n).filter(i -> WHITE == color[i]).forEach(i -> {
				color[i] = BLUE;
				dfs(edges, color, i);
			});
			System.out.println(
					(0L == IntStream.range(0, m).filter(i -> color[a[i]] == color[b[i]]).count()) ? "Yes" : "No");
		}
	}

	/**
	 * 各ノードに色を再帰的に塗る
	 *
	 * @param edges 辺の一覧
	 * @param color 色を表す数字の配列
	 * @param now   現在のノード
	 */
	private static void dfs(List<Integer>[] edges, int[] color, int now) {
		edges[now].stream().filter(i -> WHITE == color[i]).forEach(next -> {
			color[next] = N - color[now];
			dfs(edges, color, next);
		});
	}
}
