package abc.abc101_150.abc149;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc149/submissions/9268460 にも参考
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				childrens[a].add(b);
				childrens[b].add(a);
			});
			long[] invPow2 = new long[n + 1];
			invPow2[0] = 1L;
			long invTwo = powMod(2L, MOD - 2);
			IntStream.rangeClosed(1, n).forEach(i -> invPow2[i] = invPow2[i - 1] * invTwo % MOD);
			long[] prob = new long[n];
			dfs(n, childrens, invPow2, prob, 0, -1);
			System.out.println(IntStream.range(0, n).filter(i -> childrens[i].size() > 1).mapToLong(i -> prob[i])
					.reduce(0L, (s, si) -> (s + si) % MOD) * invPow2[1] % MOD);
		}
	}

	/**
	 * n^m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}

	/**
	 * 各ノードの確率を再帰的に計算する
	 *
	 * @param n         ノードの数
	 * @param childrens 辺の一覧
	 * @param invPow2   1/2^i mod MOD の一覧
	 * @param prob      確率の一覧
	 * @param now       現在処理中のノード
	 * @param prev      直前のノード
	 * @return 現在のノードとつながっているノードの数
	 */
	private static int dfs(int n, List<Integer>[] childrens, long[] invPow2, long[] prob, int now, int prev) {
		int count = 1;
		prob[now] = (MOD + 1 - invPow2[n - 1]);
		for (int next : childrens[now]) {
			if (next != prev) {
				int x = dfs(n, childrens, invPow2, prob, next, now);
				count += x;
				prob[now] = (prob[now] + MOD - (MOD + 1 - invPow2[x]) * invPow2[n - 1 - x] % MOD) % MOD;
			}
		}
		if (-1 != prev) {
			prob[now] = (prob[now] + MOD - (MOD + 1 - invPow2[n - count]) * invPow2[count - 1] % MOD) % MOD;
		}
		return count;
	}
}
