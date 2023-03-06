package other.past201912_open;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/past201912-open/submissions/14619344 を参考に作成
 */
public class ProblemJ {

	/** 隣のマスを計算するための配列 */
	private static final int[] XS = { -1, 1, 0, 0 };
	private static final int[] YS = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[][] a = new int[h][w];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> a[i][j] = scanner.nextInt()));
			System.out.println(IntStream.range(0, h)
					.map(i -> IntStream.range(0, w).map(j -> calc(h, w, a, i, j)).min().getAsInt()).min().getAsInt());
		}
	}

	/**
	 * 開始地点からの計算結果を計算する
	 * 
	 * @param h        横のマス数
	 * @param w        縦のマス数
	 * @param a        マスのデータ
	 * @param currentX 現在の開始地点X座標
	 * @param currentY 現在の開始地点Y座標
	 * @return 開始地点からの計算結果
	 */
	private static int calc(final int h, final int w, final int[][] a, int currentX, int currentY) {
		int[][] dist = new int[h][w];
		IntStream.range(0, h).forEach(i -> Arrays.fill(dist[i], Integer.MAX_VALUE >> 1));
		dist[currentX][currentY] = a[currentX][currentY];
		Queue<Path> queue = new PriorityQueue<>();
		queue.add(new Path(dist[currentX][currentY], currentX, currentY));

		while (!queue.isEmpty()) {
			Path path = queue.poll();
			if (dist[path.x][path.y] == path.cost) {
				for (int i = 0; i < XS.length; i++) {
					int newX = path.x + XS[i], newY = path.y + YS[i];
					if ((newX >= 0) && (newX < h) && (newY >= 0) && (newY < w)) {
						if (dist[newX][newY] > path.cost + a[newX][newY]) {
							dist[newX][newY] = path.cost + a[newX][newY];
							queue.add(new Path(dist[newX][newY], newX, newY));
						}
					}
				}
			}
		}
		return dist[h - 1][0] + dist[h - 1][w - 1] + dist[0][w - 1] - 2 * a[currentX][currentY];
	}

	/**
	 * 一つのパスを表すクラス
	 */
	private static class Path implements Comparable<Path> {
		final int cost;
		final int x;
		final int y;

		Path(int cost, int x, int y) {
			this.cost = cost;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Path o) {
			return this.cost - o.cost;
		}
	}
}
