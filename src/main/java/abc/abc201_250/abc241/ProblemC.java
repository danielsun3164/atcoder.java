package abc.abc201_250.abc241;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 6 */
	private static final int N = 6;
	/** 黒いマス */
	private static final char BLACK = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[][] s = new char[n][];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			// sum1は四角い範囲の合計
			int[][] sum1 = new int[n + 1][n + 1];
			Arrays.fill(sum1[0], 0);
			IntStream.rangeClosed(1, n).forEach(i -> sum1[i][0] = 0);
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> sum1[i + 1][j + 1] = sum1[i + 1][j]
					+ sum1[i][j + 1] - sum1[i][j] + ((BLACK == s[i][j]) ? 1 : 0)));
			// 横と縦の最大値を計算する
			int max = IntStream.rangeClosed(1, n)
					.map(i -> IntStream.rangeClosed(N, n)
							.map(j -> Math.max(sum1[i][j] - sum1[i - 1][j] - sum1[i][j - N] + sum1[i - 1][j - N],
									sum1[j][i] - sum1[j][i - 1] - sum1[j - N][i] + sum1[j - N][i - 1]))
							.max().getAsInt())
					.max().getAsInt();
			// 斜め+1,+1と+1,-1を計算する
			int[][] sum2 = new int[n + 1][n + 1], sum3 = new int[n + 1][n + 1];
			Arrays.fill(sum2[0], 0);
			Arrays.fill(sum3[0], 0);
			IntStream.rangeClosed(1, n).forEach(i -> sum2[i][0] = sum3[i][n] = 0);
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> {
				sum2[i + 1][j + 1] = sum2[i][j] + ((BLACK == s[i][j]) ? 1 : 0);
				sum3[i + 1][j] = sum3[i][j + 1] + ((BLACK == s[i][j]) ? 1 : 0);
			}));
			// 斜めの最大値を計算する
			max = Math.max(max,
					IntStream.rangeClosed(N, n).map(i -> IntStream.rangeClosed(N, n)
							.map(j -> Math.max(sum2[i][j] - sum2[i - N][j - N], sum3[i][j - N] - sum3[i - N][j])).max()
							.getAsInt()).max().getAsInt());
			System.out.println((max >= N - 2) ? "Yes" : "No");
		}
	}
}
