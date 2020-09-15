package abc.abc041;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc041/submissions/1293286 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Set<Integer>[] edges = new Set[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new HashSet<>());
			IntStream.range(0, m).forEach(i -> edges[scanner.nextInt() - 1].add(scanner.nextInt() - 1));
			int pow2_n = (int) Math.pow(2, n);
			long[] dp = new long[pow2_n];
			Arrays.fill(dp, 0L);
			dp[0] = 1;
			IntStream.range(1, pow2_n).forEach(i -> IntStream.range(0, n).filter(j -> (i & (1 << j)) > 0).forEach(j -> {
				boolean notInEdges = true;
				for (int k = 0; k < n; k++) {
					if (((i & (1 << k)) > 0) && (edges[j].contains(k))) {
						notInEdges = false;
						break;
					}
				}
				if (notInEdges) {
					dp[i] += dp[i - (1 << j)];
				}
			}));
			System.out.println(dp[pow2_n - 1]);
		}
	}
}
