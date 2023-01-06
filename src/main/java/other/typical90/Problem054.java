package other.typical90;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem054 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] pathLists = new List[n + m];
			IntStream.range(0, n + m).forEach(i -> pathLists[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int k = scanner.nextInt();
				IntStream.range(0, k).forEach(j -> {
					int r = scanner.nextInt() - 1;
					pathLists[n + i].add(r);
					pathLists[r].add(n + i);
				});
			});
			int[] dist = new int[n + m];
			Arrays.fill(dist, INF);
			dist[0] = 0;
			Queue<Node> que = new ArrayDeque<>();
			que.add(new Node(0, 0));
			while (!que.isEmpty()) {
				Node now = que.poll();
				if (now.c == dist[now.i]) {
					for (int next : pathLists[now.i]) {
						if (dist[next] > dist[now.i] + 1) {
							dist[next] = dist[now.i] + 1;
							que.add(new Node(next, dist[next]));
						}
					}
				}
			}
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n)
					.forEach(i -> sb.append((INF == dist[i]) ? -1 : dist[i] >> 1).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * iとcを格納するクラス
	 */
	private static class Node {
		int i, c;

		Node(int i, int c) {
			super();
			this.i = i;
			this.c = c;
		}
	}
}
