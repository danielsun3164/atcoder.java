package abc.abc086;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc086/submissions/2279952 にも参照
 * 
 * JDK11.0.6ではWAになるため、JDK1.8.0で提出すること
 */
public class ProblemD {

	/** 白の定数 */
	private static final String WHITE = "W";

	/** 四角の差分を計算用 */
	private static final int[] X_DIFFS = { 0, 0, 1, 1, 1, 1, 2, 2 };
	private static final int[] Y_DIFFS = { 0, 1, 0, 1, 1, 2, 1, 2 };
	private static final int[] COUNT_DIFFS = { 1, -1, -1, 1, 1, -1, -1, 1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int w = 4 * k + 1, k2 = 2 * k;
			int[][] count = new int[w][w];
			IntStream.range(0, w).forEach(i -> Arrays.fill(count[i], 0));
			IntStream.range(0, n).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt();
				if (WHITE.equals(scanner.next())) {
					// 黒へ変換
					y += k;
				}
				x %= k2;
				y %= k2;
				// 二次元imos 重みの加算
				for (int j = 0; j < X_DIFFS.length; j++) {
					count[x + X_DIFFS[j] * k][y + Y_DIFFS[j] * k] += COUNT_DIFFS[j];
				}
			});
			// 横方向への累積和
			IntStream.range(0, w).forEach(i -> IntStream.range(1, w).forEach(j -> count[i][j] += count[i][j - 1]));
			// 縦方向への累積和
			IntStream.range(1, w).forEach(i -> IntStream.range(0, w).forEach(j -> count[i][j] += count[i - 1][j]));
			// 2k x 2k 範囲を超えたcountを2k x 2k範囲に加算
			IntStream.range(0, w).forEach(i -> IntStream.range(0, w).filter(j -> (i >= k2) || (j >= k2))
					.forEach(j -> count[i % k2][j % k2] += count[i][j]));
			// 2k x 2k 範囲の最大値を出力
			System.out.println(IntStream.range(0, k2)
					.map(i -> IntStream.range(0, k2).map(j -> count[i][j]).max().getAsInt()).max().getAsInt());
		}
	}
}
