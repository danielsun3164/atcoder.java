package abc.abc201_250.abc209;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				edges[b].add(a);
			});
			int[] dist = new int[n];
			Arrays.fill(dist, INF);
			dist[0] = 0;
			Queue<Integer> que = new ArrayDeque<>();
			que.add(0);
			while (!que.isEmpty()) {
				int now = que.poll();
				for (int next : edges[now]) {
					if (INF == dist[next]) {
						dist[next] = dist[now] + 1;
						que.add(next);
					}
				}
			}
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int c = scanner.nextInt() - 1, d = scanner.nextInt() - 1;
				if (1 == (1 & Math.abs(dist[c] - dist[d]))) {
					sb.append("Road");
				} else {
					sb.append("Town");
				}
				sb.append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
