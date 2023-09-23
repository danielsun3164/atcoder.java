package abc.abc201_250.abc219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * クエリ平方分割による解法を実装したソースコード
 *
 * https://atcoder.jp/contests/abc219/submissions/25968805 にも参考
 */
public class ProblemG別回答 {

	/** 1回の処理件数 */
	private static final int B = 7_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			int[] x = IntStream.range(0, q).map(i -> scanner.nextInt() - 1).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] induced = new List[n];
			IntStream.range(0, n).forEach(i -> induced[i] = new ArrayList<>());
			int[] answer = IntStream.range(0, n).map(i -> i + 1).toArray();
			for (int ql = 0; ql < q; ql += B) {
				int qr = Math.min(q, ql + B);
				boolean[] need = new boolean[n];
				IntStream.range(ql, qr).forEach(qi -> need[x[qi]] = true);
				IntStream.range(0, n).forEach(u -> {
					induced[u].clear();
					if (need[u]) {
						edges[u].stream().filter(v -> need[v]).forEach(v -> induced[u].add(v));
					}
				});
				int[] lastQueryTime = new int[n], lastQueryValue = new int[n];
				Arrays.fill(lastQueryTime, ql - 1);
				IntStream.range(ql, qr).forEach(qi -> {
					int u = x[qi];
					lastQueryTime[u] = qi;
					lastQueryValue[u] = answer[u];
					induced[u].stream().forEach(v -> answer[v] = answer[u]);
				});
				for (int u = 0; u < n; u++) {
					if (!need[u]) {
						int time = ql - 1;
						for (int v : edges[u]) {
							if (lastQueryTime[v] > time) {
								time = lastQueryTime[v];
								answer[u] = lastQueryValue[v];
							}
						}
					}
				}
			}
			System.out.println(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
