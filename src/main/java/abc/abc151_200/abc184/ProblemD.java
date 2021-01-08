package abc.abc151_200.abc184;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 硬貨の目標値 */
	private static final int N = 100;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			double[][][] dp = new double[N][N][N];
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> Arrays.fill(dp[i][j], -1.0d)));
			System.out.println(getResult(a, b, c, dp));
		}
	}

	/**
	 * 操作回数の期待値を計算する
	 * 
	 * @param a  金貨の数
	 * @param b  銀貨の数
	 * @param c  銅貨の数
	 * @param dp 計算結果を保存する配列
	 * @return 操作回数の期待値
	 */
	private static double getResult(final int a, final int b, final int c, final double[][][] dp) {
		if ((N == a) || (N == b) || (N == c)) {
			return 0.0d;
		}
		if (dp[a][b][c] >= 0.0d) {
			return dp[a][b][c];
		}
		return dp[a][b][c] = (getResult(a + 1, b, c, dp) + 1.0d) * a / (a + b + c)
				+ (getResult(a, b + 1, c, dp) + 1.0d) * b / (a + b + c)
				+ (getResult(a, b, c + 1, dp) + 1.0d) * c / (a + b + c);
	}

}
