package abc.abc101_150.abc147;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** modの対象数字 */
	private static final long MOD = 1_000_000_007L;
	/** 最大2進数の桁数 */
	private static final int N = 61;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			int[][] count = new int[N][2];
			IntStream.range(0, N).forEach(i -> Arrays.fill(count[i], 0));
			IntStream.range(0, n)
					.forEach(i -> IntStream.range(0, N).forEach(j -> count[j][(int) (1L & (a[i] >> j))]++));
			long[] pow2 = new long[N];
			pow2[0] = 1L;
			IntStream.range(1, N).forEach(i -> pow2[i] = (pow2[i - 1] * 2L) % MOD);
			System.out.println(
					IntStream.range(0, N).mapToLong(i -> (((count[i][0] * (long) count[i][1]) % MOD) * pow2[i]) % MOD)
							.reduce(0L, (sum, c) -> (sum + c) % MOD));
		}
	}
}
