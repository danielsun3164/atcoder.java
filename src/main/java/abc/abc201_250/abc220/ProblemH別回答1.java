package abc.abc201_250.abc220;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc220/editorial/2835 解法の実装<br/>
 * https://atcoder.jp/contests/abc220/submissions/26813870 にも参考
 */
public class ProblemH別回答1 {

	/** 2^n の数字（ビット計算用） */
	private static final int[] BITS = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
			65536, 131072, 262144, 524288, 1048576, 2097152 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] deg = new int[n + 1];
			Arrays.fill(deg, 0);
			Edge[] adj = new Edge[n + 1], e = new Edge[m];
			for (int i = 0; i < m; i++) {
				int a = scanner.nextInt(), b = scanner.nextInt();
				e[i] = new Edge(a, adj[b]);
				adj[b] = e[i];
				deg[a] ^= 1;
				deg[b] ^= 1;
			}
			int halfN = (n - 1) >> 1;
			long[][] dp = new long[2][1 << (n - halfN)];
			dfs(adj, deg, dp[0], n, halfN);
			int cur = 1, prev = 0;
			for (int u = halfN; u >= 1; u--, cur ^= 1, prev ^= 1) {
				for (int i = 0; i < BITS[u + 1]; i++) {
					if (0L != dp[prev][i]) {
						long tmp = dp[prev][i];
						dp[prev][i] = 0L;

						int j = i & (BITS[u] - 1);
						dp[cur][j] += tmp;
						if (0 != (i & BITS[u])) {
							j ^= BITS[0];
						}
						for (Edge p = adj[u]; p != null; p = p.next) {
							j ^= BITS[p.v];
						}
						dp[cur][j] += tmp;
					}
				}
			}
			System.out.println(dp[prev][0]);
		}
	}

	private static void dfs(Edge[] adj, int[] deg, long[] dp, int u, int n) {
		int k = 0;
		if (u == n) {
			for (int w = 0; w <= n; w++) {
				if (0 != deg[w]) {
					k += BITS[w];
				}
			}
			dp[k]++;
			return;
		}

		dfs(adj, deg, dp, u - 1, n);
		for (Edge p = adj[u]; p != null; p = p.next) {
			deg[p.v] ^= 1;
		}
		deg[0] ^= deg[u];
		dfs(adj, deg, dp, u - 1, n);
		for (Edge p = adj[u]; p != null; p = p.next) {
			deg[p.v] ^= 1;
		}
		deg[0] ^= deg[u];
	}

	/**
	 * 辺を表すクラス
	 */
	private static class Edge {
		int v;
		Edge next;

		Edge(int v, Edge next) {
			this.v = v;
			this.next = next;
		}
	}
}
