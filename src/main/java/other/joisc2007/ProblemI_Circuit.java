package other.joisc2007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/joisc2007/submissions/10228535 に参考して作成
 */
public class ProblemI_Circuit {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int[] d = IntStream.rangeClosed(1, k).filter(i -> 0 == k % i).toArray();
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			int[] v = new int[n + 1], p = new int[n];
			Arrays.fill(v, 0);
			@SuppressWarnings("unchecked")
			List<Integer>[] vs = new List[n], rt = new List[n + 1];
			IntStream.range(0, n).forEach(i -> vs[i] = new ArrayList<>());
			IntStream.range(0, n + 1).forEach(i -> rt[i] = new ArrayList<>());
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					int u = i, co = 1;
					vs[i].add(i);
					visited[i] = true;
					while (a[u] != i) {
						u = a[u];
						vs[i].add(u);
						visited[u] = true;
						co++;
					}
					v[co]++;
					rt[co].add(i);
				}
			}
			BitSet[] dp = new BitSet[d.length + 1];
			IntStream.range(0, dp.length).forEach(i -> dp[i] = new BitSet(n));
			for (int s = 1; s <= n; s++) {
				if (v[s] > 0) {
					dp[0].clear();
					dp[0].set(0, true);
					for (int i = 0; i < d.length; i++) {
						boolean f = 1 == gcd(s, k / d[i]);
						for (int j = 0; j <= v[s]; j++) {
							dp[i + 1].set(j, dp[i].get(j));
							if (f && (j >= d[i])) {
								dp[i + 1].set(j, dp[i + 1].get(j) || dp[i + 1].get(j - d[i]));
							}
						}
					}
					if (!dp[d.length].get(v[s])) {
						System.out.println(0);
						return;
					}
					int id = v[s];
					List<Integer> ds = new ArrayList<>();
					for (int i = d.length; i > 0; i--) {
						for (int j = id; j >= 0; j -= d[i - 1]) {
							if (dp[i - 1].get(j)) {
								for (int l = 0; l < (id - j) / d[i - 1]; l++) {
									ds.add(d[i - 1]);
								}
								id = j;
								break;
							}
						}
					}
					id = 0;
					for (int e : ds) {
						int l = s * e;
						for (int i = id; i < id + e; i++) {
							int r = rt[s].get(i), u = 0;
							int[] nv = new int[s];
							Arrays.fill(nv, 0);
							for (int j = 0; j < s; j++) {
								nv[u] = vs[r].get(j);
								u = (u + (k % l) / e) % s;
							}
							vs[r].clear();
							Arrays.stream(nv).forEach(nvi -> vs[r].add(nvi));
						}
						for (int i = id; i < id + e; i++) {
							int r = rt[s].get(i);
							for (int j = 0; j < s; j++) {
								if (i + 1 == id + e) {
									p[vs[r].get(j)] = vs[rt[s].get(id)].get((j + 1) % s);
								} else {
									p[vs[r].get(j)] = vs[rt[s].get(i + 1)].get(j);
								}
							}
						}
						id += e;
					}
				}
			}
			Arrays.stream(p).forEach(pi -> System.out.println(pi + 1));
		}
	}

	/**
	 * aとbの最大公約数を計算する
	 * 
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static int gcd(int a, int b) {
		return (0 == b) ? a : gcd(b, a % b);
	}

}
