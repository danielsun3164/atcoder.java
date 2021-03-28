package abc.abc151_200.abc197;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m], b = new int[m], c = new int[m];
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				c[i] = scanner.next().charAt(0) - 'a';
			});
			@SuppressWarnings("unchecked")
			List<Integer>[] neighbors = new List[n * n];
			IntStream.range(0, n * n).forEach(i -> neighbors[i] = new ArrayList<>());
			for (int i = 1; i < m; i++) {
				for (int j = 0; j < i; j++) {
					if (c[i] == c[j]) {
						neighbors[a[i] * n + a[j]].add(b[i] * n + b[j]);
						neighbors[a[j] * n + a[i]].add(b[j] * n + b[i]);
						neighbors[b[i] * n + a[j]].add(a[i] * n + b[j]);
						neighbors[a[j] * n + b[i]].add(b[j] * n + a[i]);
						neighbors[a[i] * n + b[j]].add(b[i] * n + a[j]);
						neighbors[b[j] * n + a[i]].add(a[j] * n + b[i]);
						neighbors[b[i] * n + b[j]].add(a[i] * n + a[j]);
						neighbors[b[j] * n + b[i]].add(a[j] * n + a[i]);
					}
				}
			}
			int[] dist = new int[n * n];
			Arrays.fill(dist, INF);
			dist[n - 1] = 0;
			Queue<Integer> que = new ArrayDeque<>();
			que.add(n - 1);
			while (!que.isEmpty()) {
				int now = que.poll();
				for (int next : neighbors[now]) {
					if (INF == dist[next]) {
						dist[next] = dist[now] + 1;
						que.add(next);
					}
				}
			}
			int answer = Math.min(IntStream.range(0, n).map(i -> dist[i * n + i] << 1).min().getAsInt(),
					IntStream.range(0, m).map(i -> Math.min(dist[a[i] * n + b[i]], dist[b[i] * n + a[i]]) * 2 + 1).min()
							.getAsInt());
			System.out.println((answer >= INF) ? -1 : answer);
		}
	}
}
