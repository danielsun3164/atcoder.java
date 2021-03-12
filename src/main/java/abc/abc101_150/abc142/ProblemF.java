package abc.abc101_150.abc142;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc142/submissions/14474432 にも参考
 */
public class ProblemF {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> edges[scanner.nextInt() - 1].add(scanner.nextInt() - 1));
			List<Integer> answer = null;
			for (int i = 0; i < n; i++) {
				int[] dist = new int[n];
				Arrays.fill(dist, INF);
				Queue<Integer> que = new ArrayDeque<>();
				que.add(i);
				dist[i] = 0;
				int result = INF, tail = -1;
				int[] parent = new int[n];
				parent[i] = -1;
				while (!que.isEmpty()) {
					int v = que.poll();
					for (int u : edges[v]) {
						if (i == u) {
							result = Math.min(result, dist[v] + 1);
							tail = v;
						} else if (INF == dist[u]) {
							parent[u] = v;
							dist[u] = dist[v] + 1;
							que.add(u);
						}
					}
				}
				if ((tail != -1) && ((null == answer) || (answer.size() > dist[tail] + 1))) {
					answer = new ArrayList<>();
					while (tail != -1) {
						answer.add(tail);
						tail = parent[tail];
					}
				}
			}
			if (null == answer) {
				System.out.println(-1);
			} else {
				System.out.println(answer.size());
				answer.stream().mapToInt(i -> i + 1).forEach(System.out::println);
			}
		}
	}
}
