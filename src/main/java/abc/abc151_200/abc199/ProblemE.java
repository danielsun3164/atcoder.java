package abc.abc151_200.abc199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc199/submissions/22040868 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Rule>[] rules = new List[n + 1];
			IntStream.rangeClosed(0, n).forEach(i -> rules[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
				rules[x].add(new Rule(y, z));
			});
			long[] dp = new long[1 << n];
			dp[0] = 1L;
			IntStream.range(0, 1 << n).forEach(mask -> IntStream.range(0, n).forEach(next -> {
				if (0 == (mask & (1 << next))) {
					if (check(n, rules, mask + (1 << next))) {
						dp[mask + (1 << next)] += dp[mask];
					}
				}
			}));
			System.out.println(dp[(1 << n) - 1]);
		}
	}

	/**
	 * maskで表す数列が条件に満たしているかどうか
	 *
	 * @param n     数列の要素の数
	 * @param rules 条件の一覧
	 * @param mask
	 * @return maskで表す数列が条件に満たしているか
	 */
	private static boolean check(int n, List<Rule>[] rules, int mask) {
		int[] tot = new int[n + 1];
		Arrays.fill(tot, 0);
		IntStream.range(0, n).filter(i -> (mask & (1 << i)) > 0).forEach(i -> tot[i + 1]++);
		IntStream.range(0, n).forEach(i -> tot[i + 1] += tot[i]);
		for (Rule rule : rules[Integer.bitCount(mask)]) {
			if (rule.z < tot[rule.y]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * y,zを格納するクラス
	 */
	private static class Rule {
		int y, z;

		Rule(int y, int z) {
			super();
			this.y = y;
			this.z = z;
		}
	}
}
