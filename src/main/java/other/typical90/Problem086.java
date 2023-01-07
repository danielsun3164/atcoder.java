package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem086 {

	/** Aの2進数の桁数 */
	private static final int N = 60;
	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] x = new int[q], y = new int[q], z = new int[q];
			long[] w = new long[q], w2 = new long[q];
			IntStream.range(0, q).forEach(i -> {
				x[i] = scanner.nextInt() - 1;
				y[i] = scanner.nextInt() - 1;
				z[i] = scanner.nextInt() - 1;
				w[i] = scanner.nextLong();
			});
			System.out.println(IntStream.range(0, N).mapToLong(i -> {
				IntStream.range(0, q).forEach(j -> w2[j] = (w[j] >> i) & 1L);
				return IntStream.range(0, 1 << n).filter(j -> {
					long[] bit = new long[n];
					Arrays.fill(bit, 0L);
					IntStream.range(0, n).forEach(k -> bit[k] = (j >> k) & 1L);
					return 0 == IntStream.range(0, q).filter(k -> (bit[x[k]] | bit[y[k]] | bit[z[k]]) != w2[k]).count();
				}).count();
			}).reduce(1L, (s, ai) -> s * ai % MOD));
		}
	}
}
