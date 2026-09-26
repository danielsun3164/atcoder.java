package abc.abc201_250.abc242;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	private static final int N = 10;
	/** X_iの最小値 */
	private static final int MIN = 1;
	/** X_iの最大値 */
	private static final int MAX = 9;
	/** MOD対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[][] count = new long[n][N];
			IntStream.range(1, N).forEach(i -> count[0][i] = 1L);
			IntStream.range(1, n)
					.forEach(
							i -> IntStream.range(1, N)
									.forEach(j -> count[i][j] = IntStream
											.rangeClosed(Math.max(MIN, j - 1), Math.min(MAX, j + 1))
											.mapToLong(l -> count[i - 1][l]).sum() % MOD));
			System.out.println(IntStream.range(1, N).mapToLong(i -> count[n - 1][i]).sum() % MOD);
		}
	}
}
