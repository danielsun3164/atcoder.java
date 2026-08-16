package other.typical90;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem023 {

	/** キングが置ける駒の文字 */
	private static final char WHITE = '.';
	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;
	/** X座標の差分 */
	private static final int[] XS = { 1, 1, 1, 0, 0, -1, -1, -1 };
	/** Y座標の差分 */
	private static final int[] YS = { 1, 0, -1, 1, -1, 1, 0, -1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), n = 1 << 18;
			char[][] c = new char[h][];
			IntStream.range(0, h).forEach(i -> c[i] = scanner.next().toCharArray());
			int[] count = new int[w];
			Arrays.fill(count, 0);
			boolean[][] used = new boolean[h + 1][w];
			IntStream.rangeClosed(0, h).forEach(i -> Arrays.fill(used[i], false));
			int[][] state = new int[w][n], nex0 = new int[w][n], nex1 = new int[w][n];
			IntStream.range(0, w).forEach(i -> {
				Arrays.fill(state[i], 0);
				Arrays.fill(nex0[i], 0);
				Arrays.fill(nex1[i], 0);
			});
			@SuppressWarnings("unchecked")
			Map<Integer, Data>[] maps = new Map[w];
			IntStream.range(0, w).forEach(i -> maps[i] = new HashMap<>());
			IntStream.range(0, w).forEach(i -> dfs(h, w, count, used, state, maps, i, 0, 0));
			IntStream.range(0, w).forEach(i -> IntStream.range(0, count[i]).forEach(j -> {
				int t = state[i][j];
				int t0 = (t >> 1), t1 = t0 + (1 << w);
				nex0[i][j] = (maps[(i + 1) % w].containsKey(t0)) ? maps[(i + 1) % w].get(t0).n : 0;
				if (maps[i].get(t).b) {
					nex1[i][j] = (maps[(i + 1) % w].containsKey(t1)) ? maps[(i + 1) % w].get(t1).n : 0;
				} else {
					nex1[i][j] = -1;
				}
			}));
			// メモリーオーバーフローを回避するため、3行のみの配列を使用する
			long[][][] dp = new long[3][w][n];
			IntStream.range(0, 3).forEach(i -> IntStream.range(0, w).forEach(j -> Arrays.fill(dp[i][j], 0L)));
			dp[0][0][0] = 1L;
			IntStream.range(0, h).forEach(i -> {
				IntStream.range(0, w).forEach(j -> {
					int n1 = (w - 1 == j) ? i + 1 : i, n2 = (w - 1 == j) ? 0 : j + 1;
					IntStream.range(0, count[j]).forEach(k -> {
						if (0L != dp[i % 3][j][k]) {
							dp[n1 % 3][n2][nex0[j][k]] = (dp[n1 % 3][n2][nex0[j][k]] + dp[i % 3][j][k]) % MOD;
							if ((-1 != nex1[j][k]) && (WHITE == c[i][j])) {
								dp[n1 % 3][n2][nex1[j][k]] = (dp[n1 % 3][n2][nex1[j][k]] + dp[i % 3][j][k]) % MOD;
							}
						}
					});
				});
				IntStream.range(0, w).forEach(j -> Arrays.fill(dp[(i + 2) % 3][j], 0L));
			});
			System.out.println(LongStream.range(0, count[0]).reduce(0L, (s, i) -> (s + dp[h % 3][0][(int) i]) % MOD));
		}
	}

	/**
	 * 各マスの状態数を再帰的に計算する
	 *
	 * @param h        縦のマス数
	 * @param w        横のマス数
	 * @param count    各マスの状態数
	 * @param used     各マスが使われているかどうかの配列
	 * @param state    各マスの状況の配列
	 * @param maps     直前w+1コマの状況を保存するマップ
	 * @param position 位置
	 * @param depth    深さ
	 * @param str      直前w+1コマにマスの状況を表す数字
	 */
	private static void dfs(int h, int w, int[] count, boolean[][] used, int[][] state, Map<Integer, Data>[] maps,
			int position, int depth, int str) {
		int sx = position / w, sy = position % w;
		if (w + 1 == depth) {
			int index = count[sy];
			boolean flag = ok(h, w, used, sx, sy);
			state[sy][index] = str;
			maps[sy].put(str, new Data(index, flag));
			count[sy]++;
			return;
		}
		dfs(h, w, count, used, state, maps, position + 1, depth + 1, str);
		if (ok(h, w, used, sx, sy)) {
			used[sx][sy] = true;
			dfs(h, w, count, used, state, maps, position + 1, depth + 1, str + (1 << depth));
			used[sx][sy] = false;
		}
	}

	/**
	 * 指定されたマスにコマが置けるかどうかを計算する
	 *
	 * @param h    縦のマス数
	 * @param w    横のマス数
	 * @param used 各マスが使われているかどうかの配列
	 * @param sx   指定された縦位置
	 * @param sy   指定された横位置
	 * @return 指定されたマスにコマが置けるかどうか
	 */
	private static boolean ok(int h, int w, boolean[][] used, int sx, int sy) {
		for (int i = 0; i < XS.length; i++) {
			int nx = sx + XS[i], ny = sy + YS[i];
			if ((nx >= 0) && (nx <= h) && (ny >= 0) && (ny < w) && used[nx][ny]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * nとbを格納するクラス
	 */
	private static class Data {
		int n;
		boolean b;

		Data(int n, boolean b) {
			this.n = n;
			this.b = b;
		}
	}
}
