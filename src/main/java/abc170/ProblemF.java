package abc170;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc170/submissions/14453474 を参考に作成
 */
public class ProblemF {

	/** 計算するための最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** X,Y座標の差分一覧 */
	private static final int[] DXS = { 1, -1, 0, 0 };
	private static final int[] DYS = { 0, 0, 1, -1 };
	/** 通過可能の文字 */
	private static final char OK = '.';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), k = scanner.nextInt();
			int x1 = scanner.nextInt() - 1, y1 = scanner.nextInt() - 1;
			int x2 = scanner.nextInt() - 1, y2 = scanner.nextInt() - 1;
			boolean[][] c = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> {
				char[] ci = scanner.next().toCharArray();
				IntStream.range(0, w).forEach(j -> c[i][j] = (ci[j] == OK));
			});
			int[][] dist = new int[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(dist[i], INF));
			boolean[][] visited = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(visited[i], false));
			int steps = -1;
			Queue<Data> queue = new ArrayDeque<>();
			queue.add(new Data(x1, y1, 0));
			dist[x1][y1] = 0;
			visited[x1][y1] = true;
			while (!queue.isEmpty()) {
				Data data = queue.poll();
				if ((x2 == data.x) && (y2 == data.y)) {
					steps = data.depth;
					break;
				}
				IntStream.range(0, DXS.length).forEach(i -> {
					for (int j = 1; j <= k; j++) {
						int nX = data.x + DXS[i] * j;
						int nY = data.y + DYS[i] * j;
						int nDepth = data.depth + 1;

						if (!((nX >= 0) && (nX < h) && (nY >= 0) && (nY < w))) {
							break;
						}
						if ((!c[nX][nY]) || (dist[nX][nY] < nDepth)) {
							break;
						}
						if (!visited[nX][nY]) {
							queue.add(new Data(nX, nY, nDepth));
							dist[nX][nY] = nDepth;
							visited[nX][nY] = true;
						}
					}
				});
			}
			System.out.println(steps);
		}
	}

	/**
	 * x,yと深さを格納するクラス
	 */
	private static class Data {
		int x;
		int y;
		int depth;

		public Data(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}
