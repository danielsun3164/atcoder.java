package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem046 {

	/** 46 */
	private static final int N = 46;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] a = new int[3][N];
			IntStream.range(0, 3).forEach(i -> Arrays.fill(a[i], 0));
			IntStream.range(0, 3).forEach(i -> IntStream.range(0, n).forEach(j -> a[i][scanner.nextInt() % N]++));
			System.out
					.println(IntStream.range(0, N)
							.mapToLong(i -> IntStream.range(0, N)
									.mapToLong(j -> a[0][i] * ((long) a[1][j]) * a[2][(N * 2 - i - j) % N]).sum())
							.sum());
		}
	}
}
