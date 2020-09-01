package abc.abc088;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[][] c = new int[N][N];
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> c[i][j] = scanner.nextInt()));
			boolean result = true;
			for (int i = 0; i < N - 1; i++) {
				int diff1 = c[i + 1][0] - c[i][0];
				int diff2 = c[0][i + 1] - c[0][i];
				for (int j = 1; j < N; j++) {
					if ((c[i + 1][j] - c[i][j]) != diff1) {
						result = false;
						break;
					}
					if ((c[j][i + 1] - c[j][i]) != diff2) {
						result = false;
						break;
					}
				}
			}
			System.out.println(result ? "Yes" : "No");
		}
	}
}
