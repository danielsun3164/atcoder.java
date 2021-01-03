package other.exawizards2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/exawizards2019/submissions/10245730 にも参考
 */
public class ProblemF {

	/** 東を表す文字 */
	private static final char EAST = 'E';
	/** 南を表す文字 */
	private static final char SORTH = 'S';
	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;
	/** 方向を表す配列 */
	private static final int[] DIRS = new int[] { -1, 1 };
	private static List<Node> R1 = new ArrayList<>(), R2 = new ArrayList<>();
	private static List<Node> C1 = new ArrayList<>(), C2 = new ArrayList<>();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			int[] rows = new int[n + 2], columns = new int[m + 2];
			rows[0] = rows[n + 1] = columns[0] = columns[m + 1] = -1;
			IntStream.rangeClosed(1, n).forEach(i -> rows[i] = (EAST == s[i - 1]) ? 1 : 0);
			IntStream.rangeClosed(1, m).forEach(i -> columns[i] = (SORTH == t[i - 1]) ? 1 : 0);
			int[][] x = new int[n + 2][2], y = new int[m + 2][2];
			IntStream.rangeClosed(1, n).forEach(i -> x[i][0] = (rows[i] != rows[i - 1]) ? i - 1 : x[i - 1][0]);
			IntStream.rangeClosed(1, n).map(i -> n + 1 - i)
					.forEach(i -> x[i][1] = (rows[i] != rows[i + 1]) ? i + 1 : x[i + 1][1]);
			IntStream.rangeClosed(1, m).forEach(i -> y[i][0] = (columns[i] != columns[i - 1]) ? i - 1 : y[i - 1][0]);
			IntStream.rangeClosed(1, m).map(i -> m + 1 - i)
					.forEach(i -> y[i][1] = (columns[i] != columns[i + 1]) ? i + 1 : y[i + 1][1]);
			IntStream.range(0, q).forEach(i -> {
				int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
				R1.clear();
				R2.clear();
				C1.clear();
				C2.clear();
				dfs1R(2, a, b, 0, n, m, rows, columns, x, y);
				dfs1C(2, a, b, 0, n, m, rows, columns, x, y);
				dfs2R(2, c, d, 0, n, m, rows, columns, x, y);
				dfs2C(2, c, d, 0, n, m, rows, columns, x, y);
				int answer = Math.min(R1.stream().mapToInt(ri -> C2.stream().mapToInt(ci -> {
					int dy = (ci.y - ri.y) * DIRS[rows[ri.x]], dx = (ci.x - ri.x) * DIRS[columns[ci.y]];
					return ((dy >= 0) && (dx >= 0)) ? dy + dx + ri.d + ci.d : INF;
				}).min().orElse(INF)).min().orElse(INF), C1.stream().mapToInt(ci -> R2.stream().mapToInt(ri -> {
					int dy = (ri.y - ci.y) * DIRS[rows[ci.x]], dx = (ri.x - ci.x) * DIRS[columns[ri.y]];
					return ((dy >= 0) && (dx >= 0)) ? dy + dx + ci.d + ri.d : INF;
				}).min().orElse(INF)).min().orElse(INF));
				System.out.println((INF == answer) ? -1 : answer);
			});
		}
	}

	private static void dfs1R(int k, int a, int b, int d, int n, int m, final int[] rows, final int[] columns,
			final int[][] x, final int[][] y) {
		if ((a >= 1) && (a <= n) && (b >= 1) && (b <= m)) {
			R1.add(new Node(a, b, d));
			if (k >= 1) {
				dfs1C(k - 1, a, b, d, n, m, rows, columns, x, y);
				dfs1C(k - 1, a, y[b][rows[a]], d + Math.abs(y[b][rows[a]] - b), n, m, rows, columns, x, y);
			}
		}
	}

	private static void dfs1C(int k, int a, int b, int d, final int n, final int m, final int[] rows,
			final int[] columns, final int[][] x, final int[][] y) {
		if ((a >= 1) && (a <= n) && (b >= 1) && (b <= m)) {
			C1.add(new Node(a, b, d));
			if (k >= 1) {
				dfs1R(k - 1, a, b, d, n, m, rows, columns, x, y);
				dfs1R(k - 1, x[a][columns[b]], b, d + Math.abs(x[a][columns[b]] - a), n, m, rows, columns, x, y);
			}
		}
	}

	private static void dfs2R(int k, int a, int b, int d, int n, int m, final int[] rows, final int[] columns,
			final int[][] x, final int[][] y) {
		if ((a >= 1) && (a <= n) && (b >= 1) && (b <= m)) {
			R2.add(new Node(a, b, d));
			if (k >= 1) {
				dfs2C(k - 1, a, b, d, n, m, rows, columns, x, y);
				dfs2C(k - 1, a, y[b][1 - rows[a]], d + Math.abs(y[b][1 - rows[a]] - b), n, m, rows, columns, x, y);
			}
		}
	}

	private static void dfs2C(int k, int a, int b, int d, final int n, final int m, final int[] rows,
			final int[] columns, final int[][] x, final int[][] y) {
		if ((a >= 1) && (a <= n) && (b >= 1) && (b <= m)) {
			C2.add(new Node(a, b, d));
			if (k >= 1) {
				dfs2R(k - 1, a, b, d, n, m, rows, columns, x, y);
				dfs2R(k - 1, x[a][1 - columns[b]], b, d + Math.abs(x[a][1 - columns[b]] - a), n, m, rows, columns, x,
						y);
			}
		}
	}

	/**
	 * x,yを表すクラス
	 */
	private static class Node {
		int x, y, d;

		Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
