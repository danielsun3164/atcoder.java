package abc.abc151_200.abc152;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc152/submissions/19509387 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Edge>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(new Edge(a, b, i));
				edges[b].add(new Edge(b, a, i));
			});
			int m = scanner.nextInt();
			long[] masks = new long[m];
			IntStream.range(0, m).forEach(i -> {
				int from = scanner.nextInt() - 1, to = scanner.nextInt() - 1;
				long[] result = new long[] { 0L };
				dfs(from, -1, -1, to, result, edges);
				masks[i] = result[0];
			});
			System.out.println(IntStream.range(0, 1 << m).mapToLong(i -> {
				long mask = IntStream.range(0, m).filter(j -> (i & (1 << j)) != 0).asLongStream().reduce(0L,
						(s, j) -> s | masks[(int) j]);
				return (((Integer.bitCount(i) & 1) == 0) ? 1L : -1L) * (1L << (n - 1 - Long.bitCount(mask)));
			}).sum());
		}
	}

	/**
	 * 開始ノードから目的ノードまでの辺の一覧のbit表現を計算する
	 *
	 * @param now    現在のノード
	 * @param index  辺の番号
	 * @param prev   直前のノード
	 * @param target 目的ノード
	 * @param result 結果（開始ノードから目的ノードまでの辺の一覧のbit表現）
	 * @param edges  辺の一覧
	 * @return 目的までたどることができるかどうか
	 */
	private static boolean dfs(int now, int index, int prev, int target, long[] result, List<Edge>[] edges) {
		result[0] ^= (-1 != prev) ? (1L << index) : 0L;
		if (now == target) {
			return true;
		}
		for (Edge edge : edges[now]) {
			if ((edge.to != prev) && (dfs(edge.to, edge.index, now, target, result, edges))) {
				return true;
			}
		}
		result[0] ^= (-1 != prev) ? (1L << index) : 0L;
		return false;
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge {
		@SuppressWarnings("unused")
		int from, to, index;

		Edge(int from, int to, int index) {
			this.from = from;
			this.to = to;
			this.index = index;
		}
	}
}
