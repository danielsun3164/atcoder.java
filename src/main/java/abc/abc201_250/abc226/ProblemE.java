package abc.abc201_250.abc226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc226/editorial/2889 の実装
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			long answer = 1L;
			boolean[] used = new boolean[n];
			Arrays.fill(used, false);
			for (int i = 0; i < n; i++) {
				if (!used[i]) {
					Data data = new Data();
					dfs(i, edges, used, data);
					if (data.edges == (data.nodes << 1)) {
						answer = answer * 2L % MOD;
					} else {
						answer = 0L;
						break;
					}
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * 現在のノードを再帰的に計算する
	 *
	 * @param now   現在のノード
	 * @param edges 辺の一覧
	 * @param used  ノードが計算したかどうかの配列
	 * @param data  ノード数と辺の数を格納するクラス
	 */
	private static void dfs(int now, List<Integer>[] edges, boolean[] used, Data data) {
		used[now] = true;
		data.nodes++;
		data.edges += edges[now].size();
		for (int next : edges[now]) {
			if (!used[next]) {
				dfs(next, edges, used, data);
			}
		}
	}

	/**
	 * nodes,edgesを格納するクラス
	 */
	private static class Data {
		int nodes, edges;

		Data() {
			nodes = edges = 0;
		}
	}
}
