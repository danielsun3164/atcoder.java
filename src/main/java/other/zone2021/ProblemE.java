package other.zone2021;

import java.util.Arrays;
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
			int r = scanner.nextInt(), c = scanner.nextInt();
			int[][] a = new int[r][c - 1], b = new int[r - 1][c];
			IntStream.range(0, r).forEach(i -> IntStream.range(0, c - 1).forEach(j -> a[i][j] = scanner.nextInt()));
			IntStream.range(0, r - 1).forEach(i -> IntStream.range(0, c).forEach(j -> b[i][j] = scanner.nextInt()));
			Queue<Path> que = new PriorityQueue<>((p, q) -> Long.compare(p.cost, q.cost));
			que.add(new Path(0, 0, 0, 0));
			long[][][] dist = new long[2][r][c];
			IntStream.range(0, 2).forEach(i -> IntStream.range(0, r).forEach(j -> Arrays.fill(dist[i][j], INF)));
			dist[0][0][0] = 0L;
			while (!que.isEmpty()) {
				Path now = que.poll();
				int f = now.f, i = now.i, j = now.j;
				if (now.cost == dist[f][i][j]) {
					if (0 == f) {
						if (j < (c - 1)) {
							check(que, dist, f, i, j + 1, dist[f][i][j] + a[i][j]);
						}
						if (j > 0) {
							check(que, dist, f, i, j - 1, dist[f][i][j] + a[i][j - 1]);
						}
						if (i < (r - 1)) {
							check(que, dist, f, i + 1, j, dist[f][i][j] + b[i][j]);
						}
						check(que, dist, 1, i, j, dist[f][i][j] + 1);
					} else {
						check(que, dist, 0, i, j, dist[f][i][j]);
						if (i > 0) {
							check(que, dist, f, i - 1, j, dist[f][i][j] + 1);
						}
					}
				}
			}
			System.out.println(dist[0][r - 1][c - 1]);
		}
	}

	/**
	 * 次のノードをキューに追加する
	 *
	 * @param que
	 * @param dist
	 * @param f
	 * @param i
	 * @param j
	 * @param nextDist
	 */
	private static void check(Queue<Path> que, long[][][] dist, int f, int i, int j, long nextDist) {
		if (dist[f][i][j] > nextDist) {
			dist[f][i][j] = nextDist;
			que.add(new Path(f, i, j, nextDist));
		}
	}

	/**
	 * y,zを格納するクラス
	 */
	private static class Path {
		int f, i, j;
		long cost;

		Path(int f, int i, int j, long cost) {
			this.f = f;
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
	}
}
