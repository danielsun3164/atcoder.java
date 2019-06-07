package abc012;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	private static final int BIG_NUMBER = 1_000_000_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[][] dist = new int[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(dist[i], BIG_NUMBER));
			IntStream.range(0, n).forEach(i -> dist[i][i] = 0);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1;
				int b = scanner.nextInt() - 1;
				int t = scanner.nextInt();
				dist[a][b] = dist[b][a] = t;
			});
			IntStream.range(0, n).forEach(k -> IntStream.range(0, n).forEach(i -> IntStream.range(0, n)
					.forEach(j -> dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]))));
			System.out
					.println(IntStream.range(0, n).map(i -> Arrays.stream(dist[i]).max().getAsInt()).min().getAsInt());
		}
	}
}
