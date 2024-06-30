package abc.abc201_250.abc225;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 行列の列数 */
	private static final int N = 7;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[][] b = new int[n][];
			IntStream.range(0, n).forEach(i -> b[i] = IntStream.range(0, m).map(j -> scanner.nextInt()).toArray());
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (((0 == i) && (0 == j) && ((b[i][j] - 1) % N > N - m))
							|| ((0 == j) && (i > 0) && (b[i][j] != b[i - 1][j] + N))
							|| ((j > 0) && (b[i][j] != b[i][j - 1] + 1))) {
						System.out.println("No");
						return;
					}
				}
			}
			System.out.println("Yes");
		}
	}
}
