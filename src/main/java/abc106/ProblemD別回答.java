package abc106;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード（二次元累積和使用）
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			int[][] p = new int[n + 1][n + 1];
			IntStream.range(0, n + 1).forEach(i -> Arrays.fill(p[i], 0));
			IntStream.range(0, m).forEach(i -> p[scanner.nextInt()][scanner.nextInt()]++);
			IntStream.rangeClosed(1, n).forEach(i -> IntStream.rangeClosed(1, n).forEach(j -> p[i][j] += p[i - 1][j]));
			IntStream.rangeClosed(1, n).forEach(i -> IntStream.rangeClosed(1, n).forEach(j -> p[i][j] += p[i][j - 1]));
			IntStream.range(0, q).forEach(i -> {
				int l = scanner.nextInt(), r = scanner.nextInt();
				System.out.println(p[r][r] + p[l - 1][l - 1] - p[r][l - 1] - p[l - 1][r]);
			});
		}
	}
}
