package abc.abc201_250.abc248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/3796 の実装<br/>
 * https://atcoder.jp/contests/abc248/submissions/30998243 にも参考
 */
public class ProblemG別回答 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** Aの最大値 */
	private static final int N = 100_000;
	/** ローカル変数 */
	private static int[] a;
	@SuppressWarnings("unchecked")
	private static List<Integer>[] edges, indexes = new List[N + 1];
	private static int[] visited;
	private static long[] results;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			IntStream.rangeClosed(0, N).forEach(i -> indexes[i] = new ArrayList<>());
			a = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				indexes[a[i]].add(i);
			});
			edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(_ -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			visited = new int[n];
			Arrays.fill(visited, 0);
			results = new long[N + 1];
			long answer = 0;
			for (int i = N; i > 0; i--) {
				for (int d = i; d <= N; d += i) {
					for (int v : indexes[d]) {
						if (visited[v] != i) {
							List<Long> list = new ArrayList<>();
							dfs(v, -1, i, list);
							long num = list.get(list.size() - 1);
							list.remove(list.size() - 1);
							for (long x : list) {
								results[i] = (results[i] + (num - x + MOD) % MOD * x % MOD) % MOD;
							}
							results[i] = (results[i] + num * (num - 1) % MOD * powMod(2, MOD - 2) % MOD) % MOD;
						}
					}
				}
				for (int d = 2 * i; d <= N; d += i) {
					results[i] = (results[i] - results[d] + MOD) % MOD;
				}
				answer = (answer + results[i] * i % MOD) % MOD;
			}
			System.out.println(answer);
		}
	}

	/**
	 * nowを根とし、dの倍数のみが書かれた頂点からなる部分木Tを考え、<br/>
	 * Tの各頂点について部分木の頂点数を求め、listの末尾に追加する<br/>
	 * listの最後の要素がnowの部分木の頂点数になるようにする
	 *
	 * @param now
	 * @param prev
	 * @param d
	 * @param list
	 */
	private static void dfs(int now, int prev, int d, List<Long> list) {
		visited[now] = d;
		list.add((edges[now].stream().filter(next -> (next != prev) && (0 == a[next] % d)).mapToLong(next -> {
			dfs(next, now, d, list);
			return list.get(list.size() - 1);
		}).sum() + 1) % MOD);
	}

	/**
	 * n^m mod MOD を計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1L == (1L & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
