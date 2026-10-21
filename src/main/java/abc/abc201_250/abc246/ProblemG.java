package abc.abc201_250.abc246;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3706 の実装<br/>
 * https://atcoder.jp/contests/abc246/submissions/33008731 にも参考
 */
public class ProblemG {

	/** 共通変数 */
	private static int[] a;
	private static List<Integer>[] edges;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			a = new int[n];
			IntStream.range(1, n).forEach(i -> a[i] = scanner.nextInt());
			edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(_ -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			long low = 0, high = Integer.MAX_VALUE;
			while (high - low > 1) {
				long med = (high + low) >> 1;
				if (dfs(0, -1, med) > 0L) {
					low = med;
				} else {
					high = med;
				}
			}
			System.out.println(low);
		}
	}

	/**
	 * 頂点 v を根とする部分木について、条件を満たす値の寄与を再帰的に計算する。
	 *
	 * <p>
	 * 親頂点 p を除く隣接頂点を再帰的に探索し、各子部分木の計算結果を合算する。 その後、合計値から 1 を引いた値と 0 の大きい方を採用し、 頂点 v の値 a[v] が閾値 m 以上であれば 1 を加算する。
	 * </p>
	 *
	 * <p>
	 * この計算は、二分探索で用いる閾値 m に対して条件を満たすかどうかを 判定するために使用する。
	 * </p>
	 *
	 * @param now    現在探索している頂点番号
	 * @param prev   頂点 v の親頂点番号。根からの探索開始時は -1
	 * @param target 判定に使用する閾値
	 * @return 頂点 now を根とする部分木について計算した値
	 */
	private static long dfs(int now, int prev, long target) {
		long result = 0L;
		for (int next : edges[now]) {
			if (next != prev) {
				result += dfs(next, now, target);
			}
		}
		return Math.max(0L, result - 1) + ((a[now] >= target) ? 1 : 0);
	}
}
