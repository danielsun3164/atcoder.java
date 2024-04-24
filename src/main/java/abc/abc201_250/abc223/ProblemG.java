package abc.abc201_250.abc223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc223/editorial/2775 の実装<br/>
 * https://atcoder.jp/contests/abc223/submissions/26639590 にも参考
 */
public class ProblemG {

	// TLE対策のため、メンバー変数を使う
	private static List<Integer>[] edges;
	private static int[] counts;
	private static int answer = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			counts = new int[n];
			Arrays.fill(counts, 0);
			dfs1(0, -1);
			answer = 0;
			dfs2(0, -1, counts[0] == 0);
			System.out.println(answer);
		}
	}

	private static void dfs1(int now, int prev) {
		for (int next : edges[now]) {
			if (next != prev) {
				dfs1(next, now);
				if (0 == counts[next]) {
					counts[now]++;
				}
			}
		}
	}

	private static void dfs2(int now, int prev, boolean ok) {
		if ((now > 0) && (counts[now] > 0) && (counts[prev] > 0)) {
			ok = false;
		}
		if (counts[now] > 1) {
			ok = true;
		}
		if ((0 == counts[now]) && ok) {
			answer++;
		}
		for (int next : edges[now]) {
			if (next != prev) {
				dfs2(next, now, ok);
			}
		}
	}
}
