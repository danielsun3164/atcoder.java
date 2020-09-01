package abc.abc025;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc025/submissions/5283243 を参考に作成
 */
public class ProblemD {

	/** 1,000,000,007 */
	private static final int MOD = 1_000_000_007;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// 1〜25の数字の置き場所
			int[] y = new int[26];
			Arrays.fill(y, -1);
			IntStream.range(0, 25).forEach(i -> {
				int x = scanner.nextInt();
				if (x != 0) {
					y[x] = i;
				}
			});
			int u = 1 << 25;
			int[] dp = new int[u];
			Arrays.fill(dp, 0);
			dp[0] = 1;
			IntStream.range(0, u - 1).forEach(i -> {
				if (dp[i] != 0) {
					int n = Integer.bitCount(i) + 1;
					if (y[n] >= 0) {
						if (isOk(i, y[n])) {
							int k = i | (1 << y[n]);
							dp[k] = getMod(dp[k] + dp[i]);
						}
					} else {
						IntStream.range(0, 25).forEach(j -> {
							if (isOk(i, j)) {
								int k = i | (1 << j);
								dp[k] = getMod(dp[k] + dp[i]);
							}
						});
					}
				}
			});
			System.out.println(dp[u - 1]);
		}
	}

	/**
	 * @param i
	 * @param j
	 * @return iの第jビットが0であり、状態iから新たに数をjマス目においても矛盾しないか
	 */
	private static boolean isOk(int i, int j) {
		boolean x = (j % 5 == 0 || j % 5 == 4 || ((i >> (j - 1)) & 1) == ((i >> (j + 1)) & 1));
		boolean y = (j / 5 == 0 || j / 5 == 4 || ((i >> (j - 5)) & 1) == ((i >> (j + 5)) & 1));
		return ((i >> j) & 1) == 0 && x && y;
	}

	/**
	 * @param n
	 * @return l%MOD、lが負の数のとき、正の数へ変換
	 */
	private static int getMod(int n) {
		if (n < 0) {
			return MOD + n % MOD;
		} else {
			return n % MOD;
		}
	}
}
