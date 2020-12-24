package abc.abc051_100.abc099;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 最終的の色の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), c = scanner.nextInt();
			int[][] d = new int[c][c];
			// cost[a][b]は(i+j)%3がaのコマを色bに塗り替える場合の違和感の和
			int[][] cost = new int[N][c];
			IntStream.range(0, c).forEach(i -> IntStream.range(0, c).forEach(j -> d[i][j] = scanner.nextInt()));
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> {
				int now = scanner.nextInt() - 1;
				int index = (i + j) % N;
				IntStream.range(0, c).forEach(k -> cost[index][k] += d[now][k]);
			}));
			System.out.println(IntStream.range(0, c)
					.map(i -> IntStream.range(0, c).filter(j -> i != j)
							.map(j -> IntStream.range(0, c).filter(k -> (i != k) && (j != k))
									.map(k -> cost[0][i] + cost[1][j] + cost[2][k]).min().getAsInt())
							.min().getAsInt())
					.min().getAsInt());
		}
	}
}
