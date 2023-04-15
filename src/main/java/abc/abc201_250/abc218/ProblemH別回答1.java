package abc.abc201_250.abc218;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc218/editorial/2602 解法2 分割統治法の実装<br/>
 * https://atcoder.jp/contests/abc218/submissions/25789813 にも参考
 */
public class ProblemH別回答1 {

	/** 最大値 */
	private static final long INF = 1 << 60;
	/** 配列のサイズ */
	private static final int N = 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), r = scanner.nextInt();
			int nr = Math.min(r, n - r);
			long[] a = new long[n - 1], b = new long[n];
			Arrays.fill(b, 0L);
			IntStream.range(0, n - 1).forEach(i -> {
				a[i] = scanner.nextLong();
				b[i] += a[i];
				b[i + 1] += a[i];
			});
			long[][][][] data = new long[n][][][];
			for (int i = 0; i < n; i++) {
				data[i] = init(b[i]);
			}
			while (data.length > 1) {
				for (int i = 1; i < data.length; i += 2) {
					data[i - 1] = merge(data[i - 1], data[i]);
				}
				data = reduce(data);
			}
			System.out.println(Arrays.stream(data[0])
					.mapToLong(dpi -> Arrays.stream(dpi).mapToLong(dpij -> dpij[nr]).max().getAsLong()).max()
					.getAsLong());
		}
	}

	/**
	 * 配列の初期化
	 *
	 * @param value 値
	 * @return 初期化された配列
	 */
	private static long[][][] init(long value) {
		long[][][] dp = new long[N][N][N];
		IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> Arrays.fill(dp[i][j], -INF)));
		dp[0][0][0] = 0;
		dp[1][1][1] = value;
		return dp;
	}

	/**
	 * 配列を合併する
	 *
	 * @param dpL
	 * @param dpR
	 * @return 合併結果
	 */
	private static long[][][] merge(long[][][] dpL, long[][][] dpR) {
		int n1 = dpL[0][0].length, n2 = dpR[0][0].length;
		long[][][] dp = new long[N][N][n1 + n2 - 1];
		IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> Arrays.fill(dp[i][j], -INF)));
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				for (int c = 0; c < N; c++) {
					if ((1 == b) && (1 == c)) {
						continue;
					}
					for (int d = 0; d < N; d++) {
						long[] tmp = maxplusConvolveConcave(dpL[a][b], dpR[c][d]);
						for (int i = 0; i < n1 + n2 - 1; i++) {
							dp[a][d][i] = Math.max(dp[a][d][i], tmp[i]);
						}
					}
				}
			}
		}
		return dp;
	}

	/**
	 * dataを[0,2,4...]のみ残した配列にする
	 *
	 * @param data 配列
	 * @return dataを[0,2,4...]のみ残した配列
	 */
	private static long[][][][] reduce(long[][][][] data) {
		long[][][][] result = new long[(data.length + 1) >> 1][][][];
		IntStream.range(0, (data.length + 1) >> 1).forEach(i -> result[i] = data[i << 1]);
		return result;
	}

	/**
	 * aとbの Maxplus Convolve Concave を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの Maxplus Convolve Concave
	 */
	private static long[] maxplusConvolveConcave(long[] a, long[] b) {
		int la = a.length, lb = b.length;
		long[] result = new long[la + lb - 1];
		Arrays.fill(result, -INF);
		int i = 0, j = 0;
		while (i + j < result.length) {
			result[i + j] = ((-INF == a[i]) || (-INF == b[j])) ? -INF : a[i] + b[j];
			if (la - 1 == i) {
				j++;
			} else if (lb - 1 == j) {
				i++;
			} else if ((-INF == a[i]) || ((-INF != b[j]) && (a[i + 1] + b[j] > a[i] + b[j + 1]))) {
				i++;
			} else {
				j++;
			}
		}
		return result;
	}
}
