package abc.abc151_200.abc168;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc168/submissions/13383351 に参照して作成
 */
public class ProblemF {

	private static final int[] XS1 = { 1, -1 };
	private static final int[] YS1 = { 0, 0 };
	private static final int[] DXS1 = { -1, 0 };
	private static final int[] XS2 = { 0, 0 };
	private static final int[] YS2 = { 1, -1 };
	private static final int[] DYS2 = { -1, 0 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Map<Integer, Integer> mapX = new TreeMap<>(), mapY = new TreeMap<>();
			mapX.put(0, null);
			mapY.put(0, null);
			int[] a = new int[n], b = new int[n], c = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
				c[i] = scanner.nextInt();
				mapX.put(a[i], null);
				mapX.put(b[i], null);
				mapY.put(c[i], null);
			});
			int[] d = new int[m], e = new int[m], f = new int[m];
			IntStream.range(0, m).forEach(i -> {
				d[i] = scanner.nextInt();
				e[i] = scanner.nextInt();
				f[i] = scanner.nextInt();
				mapX.put(d[i], null);
				mapY.put(e[i], null);
				mapY.put(f[i], null);
			});

			int x = mapX.size();
			int[] toX = new int[x];
			int count = 0;
			for (Integer integer : mapX.keySet()) {
				mapX.put(integer, count);
				toX[count] = integer;
				count++;
			}
			int y = mapY.size();
			int[] toY = new int[y];
			count = 0;
			for (Integer integer : mapY.keySet()) {
				mapY.put(integer, count);
				toY[count] = integer;
				count++;
			}

			boolean[][] ngY = new boolean[x + 1][y + 1];
			IntStream.range(0, x + 1).forEach(i -> Arrays.fill(ngY[i], false));
			IntStream.range(0, n).forEach(i -> IntStream.rangeClosed(mapX.get(a[i]) + 1, mapX.get(b[i]))
					.forEach(j -> ngY[j][mapY.get(c[i])] = true));
			boolean[][] ngX = new boolean[x + 1][y + 1];
			IntStream.range(0, x + 1).forEach(i -> Arrays.fill(ngX[i], false));
			IntStream.range(0, m).forEach(i -> IntStream.rangeClosed(mapY.get(e[i]) + 1, mapY.get(f[i]))
					.forEach(j -> ngX[mapX.get(d[i])][j] = true));

			boolean[][] visitable = new boolean[x + 1][y + 1];
			IntStream.range(0, x + 1).forEach(i -> Arrays.fill(visitable[i], false));
			// 原点をチェック
			int fx = mapX.get(0), fy = mapY.get(0);
			if ((0 == fx) || (x - 1 == fx) || (0 == fy) || (y - 1 == fy)) {
				System.out.println("INF");
				return;
			}
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(fx * 10000 + fy);
			visitable[fx][fy] = true;
			while (!queue.isEmpty()) {
				int current = queue.poll();
				int cx = current / 10000, cy = current % 10000;
				for (int i = 0; i < XS1.length; i++) {
					int nx = cx + XS1[i], ny = cy + YS1[i];
					if ((!ngX[nx + DXS1[i]][ny]) && (!visitable[nx][ny])) {
						if ((0 == nx) || (x == nx)) {
							System.out.println("INF");
							return;
						}
						queue.add(nx * 10000 + ny);
						visitable[nx][ny] = true;
					}
				}
				for (int i = 0; i < XS2.length; i++) {
					int nx = cx + XS2[i], ny = cy + YS2[i];
					if ((!ngY[nx][ny + DYS2[i]]) && (!visitable[nx][ny])) {
						if ((0 == ny) || (y == ny)) {
							System.out.println("INF");
							return;
						}
						queue.add(nx * 10000 + ny);
						visitable[nx][ny] = true;
					}
				}
			}
			System.out
					.println(IntStream.range(1, x)
							.mapToLong(i -> IntStream.range(1, y).filter(j -> visitable[i][j])
									.mapToLong(j -> ((long) toX[i] - toX[i - 1]) * ((long) toY[j] - toY[j - 1])).sum())
							.sum());
		}
	}
}
