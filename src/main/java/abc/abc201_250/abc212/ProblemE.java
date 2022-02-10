package abc.abc201_250.abc212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			long[][] dp = new long[2][n];
			Arrays.fill(dp[0], 0L);
			dp[0][0] = 1L;
			IntStream.range(0, k).forEach(i -> {
				long sum = Arrays.stream(dp[i & 1]).sum();
				IntStream.range(0, n).forEach(j -> dp[(i + 1) & 1][j] = (sum - dp[i & 1][j]
						- edges[j].stream().mapToLong(ei -> dp[i & 1][ei]).sum()) % MOD);
			});
			System.out.println(dp[k & 1][0]);
		}
	}
}
