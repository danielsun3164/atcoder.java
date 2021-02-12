package other.joisc2007;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC_Mall {

	/** 最大値 2^27=134217728 > 1000x1000x100 */
	private static final int INF = 1 << 27;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int m = scanner.nextInt(), n = scanner.nextInt();
			int a = scanner.nextInt(), b = scanner.nextInt();
			// MLE対策のため、intと定義
			int[][] sum = new int[n + 1][m + 1];
			IntStream.range(0, n + 1).forEach(i -> sum[i][0] = 0);
			Arrays.fill(sum[0], 0);
			IntStream.range(0, n).forEach(i -> IntStream.range(0, m).forEach(j -> {
				int c = scanner.nextInt();
				sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + ((c >= 0) ? c : INF);
			}));
			System.out.println(IntStream.rangeClosed(0, n - b)
					.map(i -> IntStream.rangeClosed(0, m - a)
							.map(j -> sum[i + b][j + a] - sum[i + b][j] - (sum[i][j + a] - sum[i][j]))
							// オーバーフロー対策
							.filter(res -> res > 0).min().orElse(INF))
					.min().getAsInt());
		}
	}
}
