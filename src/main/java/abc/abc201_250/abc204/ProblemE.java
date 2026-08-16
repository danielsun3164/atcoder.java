package abc.abc201_250.abc204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] pathLists = new List[n];
			IntStream.range(0, n).forEach(i -> pathLists[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				long c = scanner.nextLong(), d = scanner.nextLong();
				if (a != b) {
					pathLists[a].add(new Path(b, c, d));
					pathLists[b].add(new Path(a, c, d));
				}
			});
			long[] dist = new long[n];
			Arrays.fill(dist, INF);
			dist[0] = 0L;
			Queue<Path> que = new PriorityQueue<>((a, b) -> Long.compare(a.c, b.c));
			que.add(new Path(0, 0L, 0L));
			while (!que.isEmpty()) {
				Path now = que.poll();
				for (Path next : pathLists[now.to]) {
					long w = Math.max(0L, Math.round(Math.sqrt(next.d)) - 1 - dist[now.to]);
					long nDist = dist[now.to] + next.c + w + (next.d / (dist[now.to] + w + 1L));
					if (dist[next.to] > nDist) {
						dist[next.to] = nDist;
						que.add(new Path(next.to, dist[now.to], 0L));
					}
				}
			}
			System.out.println((INF == dist[n - 1]) ? -1 : dist[n - 1]);
		}
	}

	/**
	 * パスを表すクラス
	 */
	private static class Path {
		int to;
		long c, d;

		Path(int to, long c, long d) {
			this.to = to;
			this.c = c;
			this.d = d;
		}
	}
}
