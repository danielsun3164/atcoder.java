package abc.abc151_200.abc199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc199/submissions/22011954 にも参考
 */
public class ProblemD {

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
			int[] color = new int[n];
			Arrays.fill(color, 0);
			long answer = 1L;
			for (int i = 0; i < n; i++) {
				List<Integer> ts = new ArrayList<>();
				Queue<Integer> que = new ArrayDeque<>();
				que.add(i);
				ts.add(i);
				while (!que.isEmpty()) {
					int u = que.poll();
					for (int v : edges[u]) {
						if (!ts.contains(v)) {
							que.add(v);
							ts.add(v);
						}
					}
				}
				if (i == ts.stream().mapToInt(Integer::intValue).min().getAsInt()) {
					long now = calc(edges, color, ts, 0);
					if (0L == now) {
						System.out.println(0);
						return;
					}
					answer *= now;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * ノードの一覧と辺の一覧で色の塗り方を計算する
	 *
	 * @param edges 辺の一覧
	 * @param color 各ノードの色の配列
	 * @param ts    ノードの一覧
	 * @param index 現在の処理対象のインデックス
	 * @return 色の塗り方
	 */
	private static long calc(List<Integer>[] edges, int[] color, List<Integer> ts, int index) {
		if (ts.size() == index) {
			return 1L;
		}
		int u = ts.get(index);
		long answer = 0L;
		for (int i = 1; i <= N; i++) {
			boolean canUse = true;
			for (int v : edges[u]) {
				if (i == color[v]) {
					canUse = false;
					break;
				}
			}
			if (canUse) {
				color[u] = i;
				answer += calc(edges, color, ts, index + 1);
			}
		}
		color[u] = 0;
		return answer;
	}
}
