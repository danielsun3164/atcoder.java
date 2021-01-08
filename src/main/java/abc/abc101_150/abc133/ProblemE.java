package abc.abc101_150.abc133;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] lists = new List[n];
			IntStream.range(0, n).forEach(i -> lists[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				lists[a].add(b);
				lists[b].add(a);
			});
			System.out.println(k * dfs(k, lists, 0, -1) % MOD);
		}
	}

	/**
	 * fromからnowへ遷移したとき、now以降の木の塗り方の数を計算する
	 * 
	 * @param k     色の数
	 * @param lists 辺の一覧の配列
	 * @param now   現在処理対象のノード
	 * @param from  現在の処理対象の直前のノード
	 * @return fromからnowへ遷移したとき、now以降の木の塗り方の数
	 */
	private static long dfs(final int k, final List<Integer>[] lists, final int now, final int from) {
		if (k < lists[now].size()) {
			return 0L;
		}
		int canUseColorNum = (-1 == from) ? k - 1 : k - 2;
		long result = 1L;
		for (Integer next : lists[now]) {
			if (from != next) {
				result = result * (canUseColorNum--) % MOD;
				result = result * dfs(k, lists, next, now) % MOD;
			}
		}
		return result;
	}
}
