package abc.abc151_200.abc197;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc197/submissions/21335066 に参考に作成、解説より実行時間が短い
 */
public class ProblemF別回答 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Queue<int[]> bfs = new ArrayDeque<>();
			int[][] dist = new int[n][n];
			@SuppressWarnings("unchecked")
			List<int[]>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(dist[i], INF);
				edges[i] = new ArrayList<>();
				dist[i][i] = 0;
				bfs.add(new int[] { i, i });
			});
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1, c = scanner.next().charAt(0) - 'a';
				edges[a].add(new int[] { b, c });
				if (a != b) {
					edges[b].add(new int[] { a, c });
					dist[a][b] = dist[b][a] = 1;
					bfs.add(new int[] { a, b });
					bfs.add(new int[] { b, a });
				}
			});
			while (!bfs.isEmpty()) {
				int[] state = bfs.poll();
				for (int[] prev : edges[state[0]]) {
					for (int[] next : edges[state[1]]) {
						int start = prev[0], end = next[0];
						if ((INF == dist[start][end]) && (prev[1] == next[1])) {
							dist[start][end] = dist[state[0]][state[1]] + 2;
							bfs.add(new int[] { start, end });
						}
					}
				}
			}
			System.out.println((INF == dist[0][n - 1]) ? -1 : dist[0][n - 1]);
		}
	}
}
