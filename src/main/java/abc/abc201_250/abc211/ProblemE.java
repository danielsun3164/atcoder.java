package abc.abc201_250.abc211;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** x座標とy座標の差分 */
	private static final int[] XS = { -1, 1, 0, 0 };
	private static final int[] YS = { 0, 0, -1, 1 };
	/** 白のマスを表す文字 */
	private static final char WHITE = '.';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			char[][] s = new char[n][];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			System.out.println(dfs(n, k, new HashSet<>(), s, 0L));
		}
	}

	/**
	 * 塗り方の数を計算する
	 *
	 * @param n    マスの横、縦の数
	 * @param k    塗る必要なマスの数
	 * @param memo 処理済みの塗り方を保存するメモ
	 * @param s    マスの状況を表す配列
	 * @param now  現在の塗り方
	 * @return 塗り方の数
	 */
	private static int dfs(int n, int k, Set<Long> memo, char[][] s, long now) {
		memo.add(now);
		if (0 == k) {
			return 1;
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long bit = 1L << (i * n + j);
				if ((WHITE == s[i][j]) && (0L == (now & bit)) && ok(n, now, i, j) && !memo.contains(now | bit)) {
					result += dfs(n, k - 1, memo, s, now | bit);
				}
			}
		}
		return result;
	}

	/**
	 * 指定された座標(x,y)に塗ることが可能かどうかを判定する
	 *
	 * @param n   マスの横、縦の数
	 * @param now 現在の塗り方
	 * @param x   X座標
	 * @param y   Y座標
	 * @return 指定された座標(x,y)に塗ることが可能かどうか
	 */
	private static boolean ok(int n, long now, int x, int y) {
		if (0L == now) {
			return true;
		}
		for (int i = 0; i < XS.length; i++) {
			int nx = x + XS[i], ny = y + YS[i];
			if ((nx >= 0) && (nx < n) && (ny >= 0) && (ny < n) && ((now & (1L << (nx * n + ny))) != 0L)) {
				return true;
			}
		}
		return false;
	}
}
