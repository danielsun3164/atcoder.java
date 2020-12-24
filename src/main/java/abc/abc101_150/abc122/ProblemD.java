package abc.abc101_150.abc122;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc122/submissions/4696453 にも参考
 */
public class ProblemD {

	/** 文字の種類数 */
	private static final int N = 4;

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[][][][] memo = new long[N + 1][N + 1][N + 1][n];
			IntStream.rangeClosed(0, N).forEach(i -> IntStream.rangeClosed(0, N)
					.forEach(j -> IntStream.rangeClosed(0, N).forEach(k -> Arrays.fill(memo[i][j][k], -1))));
			System.out.println(dp(n, N, N, N, 0, memo));
		}
	}

	/**
	 * 処理結果を再帰的に計算する
	 * 
	 * @param n     総文字数
	 * @param x1    三つ前の文字（0:A、1:C、2:G、3:T、4:その他）
	 * @param x2    二つ前の文字（0:A、1:C、2:G、3:T、4:その他）
	 * @param x3    一つ前の文字（0:A、1:C、2:G、3:T、4:その他）
	 * @param index 現在処理している文字の場所
	 * @param memo  処理結果を保存する配列
	 * @return 処理結果
	 */
	private static long dp(int n, int x1, int x2, int x3, int index, long[][][][] memo) {
		if (n == index) {
			return 1L;
		}
		if (memo[x1][x2][x3][index] >= 0) {
			return memo[x1][x2][x3][index];
		}
		long answer = 0L;
		for (int next = 0; next < N; next++) {
			if (ok(x1, x2, x3, next) && ok(x1, x2, next, x3) && ok(x1, x3, x2, next) && ok(x2, x1, x3, next)) {
				answer = (answer + dp(n, x2, x3, next, index + 1, memo)) % MOD;
			}
		}
		return memo[x1][x2][x3][index] = answer;
	}

	/**
	 * x1x2x3x4で組合せた文字列に「AGC」が含まれないかをチェックする
	 * 
	 * @param x1 一つ目の文字（0:A、1:C、2:G、3:T、4:その他）
	 * @param x2 二つ目の文字（0:A、1:C、2:G、3:T、4:その他）
	 * @param x3 三つ目の文字（0:A、1:C、2:G、3:T、4:その他）
	 * @param x4 四つ目の文字（0:A、1:C、2:G、3:T、4:その他）
	 * @return x1x2x3x4で組合せた文字列に「AGC」が含まれない場合true
	 */
	private static boolean ok(int x1, int x2, int x3, int x4) {
		return !((0 == x1) && (2 == x2) && (1 == x3)) && !((0 == x2) && (2 == x3) && (1 == x4));
	}
}
