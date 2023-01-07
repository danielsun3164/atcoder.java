package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem031 {

	/** 白石の数の最大値 */
	private static final int N = 50;
	/** 青石の数の最大値 (1+...+50+50) */
	private static final int M = 1325;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] w = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[][] grundy = new int[N + 1][M + N + 2];
			boolean[] mex = new boolean[M + N + 2];
			IntStream.rangeClosed(0, N).forEach(i -> Arrays.fill(grundy[i], 0));
			IntStream.rangeClosed(0, N).forEach(i -> IntStream.rangeClosed(0, M).forEach(j -> {
				Arrays.fill(mex, false);
				if (i >= 1) {
					mex[grundy[i - 1][j + i]] = true;
				}
				if (j >= 2) {
					IntStream.rangeClosed(1, j / 2).forEach(k -> mex[grundy[i][j - k]] = true);
				}
				grundy[i][j] = IntStream.range(0, M + N + 2).filter(k -> !mex[k]).findFirst().getAsInt();
			}));
			System.out.println(
					(0 == IntStream.range(0, n).reduce(0, (xor, i) -> xor ^ grundy[w[i]][b[i]])) ? "Second" : "First");
		}
	}
}
