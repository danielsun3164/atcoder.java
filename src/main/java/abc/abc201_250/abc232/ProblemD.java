package abc.abc201_250.abc232;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 壁のマスを表す文字 */
	private static final char WALL = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] c = new char[h][];
			IntStream.range(0, h).forEach(i -> c[i] = scanner.next().toCharArray());
			int[][] dp = new int[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(dp[i], 0));
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).filter(j -> WALL != c[i][j]).forEach(j -> {
				if ((0 == i) && (0 == j)) {
					dp[i][j] = 1;
				}
				if ((i > 0) && (dp[i - 1][j] > 0)) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
				}
				if ((j > 0) && (dp[i][j - 1] > 0)) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
				}
			}));
			System.out.println(Arrays.stream(dp).mapToInt(dpi -> Arrays.stream(dpi).max().getAsInt()).max().getAsInt());
		}
	}
}
