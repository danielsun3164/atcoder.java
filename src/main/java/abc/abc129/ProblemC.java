package abc.abc129;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			if (m > 1) {
				int diff = IntStream.range(1, m).map(i -> a[i] - a[i - 1]).min().getAsInt();
				if (1 == diff) {
					// 隣り合う階段が壊れた場合、答えは0
					System.out.println(0);
					return;
				}
			}
			// containsを計算するためのSet
			Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
			long[] dp = new long[n + 1];
			dp[0] = 1;
			IntStream.rangeClosed(1, n).forEach(i -> {
				if (set.contains(i)) {
					dp[i] = 0;
				} else {
					dp[i] = (dp[i - 1] + ((i > 1) ? dp[i - 2] : 0)) % MOD;
				}
			});
			System.out.println(dp[n]);
		}
	}
}
