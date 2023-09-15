package abc.abc201_250.abc219;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc219/submissions/33503430 にも参考
 */
public class ProblemE {

	/** 行列の数 */
	private static final int N = 4;
	/** マスの組み合わせ数 */
	private static final int M = 1 << (N * N);
	/** X座標の差分 */
	private static final int[] XS = { 1, -1, 0, 0 };
	/** Y座標の差分 */
	private static final int[] YS = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[][] a = new int[N + 1][N + 1], cover = new int[N + 2][N + 2];
			IntStream.rangeClosed(1, N)
					.forEach(i -> IntStream.rangeClosed(1, N).forEach(j -> a[i][j] = scanner.nextInt()));
			IntStream.range(0, N + 2).forEach(i -> Arrays.fill(cover[i], 0));
			boolean[][] used = new boolean[N + 2][N + 2];
			int answer = 0;
			for (int b = 1; b < M; b++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						cover[i][j] = (0 != (b & (1 << ((i - 1) * N + (j - 1))))) ? 1 : 0;
					}
				}
				boolean flag = true;
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if ((1 == a[i][j]) && (0 == cover[i][j])) {
							flag = false;
						}
					}
				}
				IntStream.range(0, N + 2).forEach(i -> Arrays.fill(used[i], false));
				dfs(0, 0, 0, cover, used);
				label: for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (1 == cover[i][j]) {
							dfs(i, j, 1, cover, used);
							break label;
						}
					}
				}
				for (int i = 0; i <= N + 1; i++) {
					for (int j = 0; j <= N + 1; j++) {
						flag &= used[i][j];
					}
				}
				if (flag) {
					answer++;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * used[x][y] を再帰的に計算する
	 *
	 * @param x     X座標
	 * @param y     Y座標
	 * @param c     値
	 * @param cover
	 * @param used
	 */
	private static void dfs(int x, int y, int c, int[][] cover, boolean[][] used) {
		used[x][y] = true;
		for (int i = 0; i < N; i++) {
			int nx = x + XS[i], ny = y + YS[i];
			if ((nx < 0) || (nx > N + 1) || (ny < 0) || (ny > N + 1)) {
				continue;
			}
			if (used[nx][ny] || (c != cover[nx][ny])) {
				continue;
			}
			dfs(nx, ny, c, cover, used);
		}
	}
}
