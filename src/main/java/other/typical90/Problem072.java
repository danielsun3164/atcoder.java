package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem072 {

	/** 平野のマスを表す文字 */
	private static final char HEIYA = '.';
	/** X座標の差分一覧 */
	private static final int[] XS = { 1, -1, 0, 0 };
	/** Y座標の差分一覧 */
	private static final int[] YS = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			boolean[][] c = new boolean[h][w], used = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> {
				char[] s = scanner.next().toCharArray();
				IntStream.range(0, w).forEach(j -> c[i][j] = (HEIYA == s[j]));
			});
			IntStream.range(0, h).forEach(i -> Arrays.fill(used[i], false));
			int[] memo = new int[1 << (h * w)];
			Arrays.fill(memo, Integer.MAX_VALUE);
			int answer = IntStream.range(0, h).map(i -> IntStream.range(0, w).filter(j -> c[i][j])
					.map(j -> dfs(h, w, c, i, j, i, j, used)).max().orElse(0)).max().getAsInt();
			System.out.println((answer <= 2) ? -1 : answer);
		}
	}

	/**
	 * 現在地点から開始地点まで戻るため通るマスの数の最大値を計算する
	 *
	 * @param h    行数
	 * @param w    列数
	 * @param c    マスが平野かどうかの配列
	 * @param sx   開始地点X座標
	 * @param sy   開始地点Y座標
	 * @param px   現在地点X座標
	 * @param py   現在地点Y座標
	 * @param used マスが通ったかどうかの配列
	 * @return 現在地点から開始地点まで戻るため通るマスの数の最大値
	 */
	private static int dfs(int h, int w, boolean[][] c, int sx, int sy, int px, int py, boolean[][] used) {
		if ((sx == px) && (sy == py) && used[px][py]) {
			return 0;
		}
		used[px][py] = true;
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < XS.length; i++) {
			int nx = px + XS[i], ny = py + YS[i];
			if ((nx < 0) || (nx >= h) || (ny < 0) || (ny >= w) || !c[nx][ny]) {
				continue;
			}
			if (((sx != nx) || (sy != ny)) && used[nx][ny]) {
				continue;
			}
			result = Math.max(result, dfs(h, w, c, sx, sy, nx, ny, used) + 1);
		}
		used[px][py] = false;
		return result;
	}
}
