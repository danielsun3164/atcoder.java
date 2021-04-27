package abc.abc151_200.abc199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc199/submissions/22053625 にも参考
 */
public class ProblemD別回答 {

	/** 色の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] index = new int[n], v = new int[n];
			Arrays.fill(index, -1);
			Arrays.fill(v, -1);
			long answer = 1L;
			for (int i = 0; i < n; i++) {
				if (-1 == index[i]) {
					index[i] = 0;
					v[i] = 0;
					answer *= dfs(edges, i, index, v) * 3L;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * 現在のノード以下の色の数を計算する
	 *
	 * @param edges 辺の一覧
	 * @param now   現在処理中のノード
	 * @param index ノードの階層一覧
	 * @param v     ノードの色一覧
	 * @return 現在のノード以下の色の数
	 */
	private static long dfs(List<Integer>[] edges, int now, int[] index, int[] v) {
		for (int to : edges[now]) {
			if (v[to] == v[now]) {
				return 0L;
			}
		}
		long result = 1L;
		for (int to : edges[now]) {
			if (-1 == index[to]) {
				index[to] = index[now] + 1;
			}
			if (index[to] == (index[now] + 1)) {
				long tmp = 0L;
				v[to] = (v[now] + 1) % N;
				tmp += dfs(edges, to, index, v);
				v[to] = (v[now] + 2) % N;
				tmp += dfs(edges, to, index, v);
				v[to] = -1;
				result *= tmp;
				if (0L == tmp) {
					break;
				}
			}
		}
		return result;
	}
}
