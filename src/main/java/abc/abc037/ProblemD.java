package abc.abc037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * メモリー超過のため、https://atcoder.jp/contests/abc037/submissions/4391812 に参考して<br/>
 * Scanner.nextInt()をBufferReader.readLine()に修正
 */
public class ProblemD {

	private static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {
			String[] strings = br.readLine().split(" ");
			int h = Integer.parseInt(strings[0]), w = Integer.parseInt(strings[1]);
			int[][] a = new int[h][w];
			for (int i = 0; i < h; i++) {
				String[] columns = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					a[i][j] = Integer.parseInt(columns[j]);
				}
			}
			int[][] result = new int[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(result[i], -1));
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> dfs(i, j, h, w, a, result)));
			long sum = 0L;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sum = (sum + result[i][j]) % MOD;
				}
			}
			System.out.println(sum);
		}
	}

	/**
	 * (i,j)の項目の移動数を計算
	 * 
	 * @param i
	 * @param j
	 * @param h      全体の高さ
	 * @param w      全体の幅
	 * @param a      数字の配列
	 * @param result 結果の配列
	 */
	private static void dfs(int i, int j, final int h, final int w, final int[][] a, int[][] result) {
		if (-1 == result[i][j]) {
			result[i][j] = 1;
			// 上の項目を確認
			if (i > 0 && (a[i][j] < a[i - 1][j])) {
				dfs(i - 1, j, h, w, a, result);
				result[i][j] = (result[i][j] + result[i - 1][j]) % MOD;
			}
			// 下の項目を確認
			if (i < h - 1 && (a[i][j] < a[i + 1][j])) {
				dfs(i + 1, j, h, w, a, result);
				result[i][j] = (result[i][j] + result[i + 1][j]) % MOD;
			}
			// 左の項目を確認
			if (j > 0 && (a[i][j] < a[i][j - 1])) {
				dfs(i, j - 1, h, w, a, result);
				result[i][j] = (result[i][j] + result[i][j - 1]) % MOD;
			}
			// 右の項目を確認
			if (j < w - 1 && (a[i][j] < a[i][j + 1])) {
				dfs(i, j + 1, h, w, a, result);
				result[i][j] = (result[i][j] + result[i][j + 1]) % MOD;
			}
		}
	}
}
