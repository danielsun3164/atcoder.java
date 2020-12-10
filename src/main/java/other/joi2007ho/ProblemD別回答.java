package other.joi2007ho;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説の解法4を実装したソースコード
 */
public class ProblemD別回答 {

	/** result用のインデックス */
	private static int index = 0;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			// 各試合の勝ったチームと負けたチーム
			int[] w = new int[m], l = new int[m];
			// 各チームの勝ったチームの数
			int[] lCount = new int[n];
			IntStream.range(0, m).forEach(i -> {
				w[i] = scanner.nextInt() - 1;
				l[i] = scanner.nextInt() - 1;
				lCount[l[i]]++;
			});
			int[][] dp = new int[n][];
			IntStream.range(0, n).forEach(i -> dp[i] = new int[lCount[i]]);
			IntStream.range(0, m).forEach(i -> dp[l[i]][--lCount[l[i]]] = w[i]);
			IntStream.range(0, n).forEach(i -> Arrays.sort(dp[i]));
			boolean[] used = new boolean[n];
			Arrays.fill(used, false);
			int[] result = new int[n];
			index = 0;
			IntStream.range(0, n).forEach(i -> func(i, m, dp, used, result));
			if (m < n - 1) {
				System.out.println(1);
			} else {
				for (int i = 0; i < n - 1; i++) {
					if (Arrays.binarySearch(dp[result[i + 1]], result[i]) < 0) {
						System.out.println(1);
						return;
					}
				}
				System.out.println(0);
			}
		}
	}

	/**
	 * 計算結果を再帰的に計算する
	 * 
	 * @param now    現在処理しているチーム
	 * @param m      試合結果の数
	 * @param w      勝ったチームの配列
	 * @param l      負けたチームの配列
	 * @param used   出力されたかどうかを保存する配列
	 * @param result 計算結果
	 */
	private static void func(int now, int m, final int[][] dp, final boolean[] used, final int[] result) {
		if (!used[now]) {
			Arrays.stream(dp[now]).filter(wi -> !used[wi]).forEach(wi -> func(wi, m, dp, used, result));
			result[index++] = now;
			System.out.println(now + 1);
			used[now] = true;
		}
	}
}
