package abc.abc201_250.abc244;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemG {

	/** 1を表す文字 */
	private static final char ONE = '1';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n + 1];
			IntStream.range(0, n + 1).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(_ -> {
				int u = scanner.nextInt(), v = scanner.nextInt();
				edges[u].add(v);
				edges[v].add(u);
			});
			char[] s = scanner.next().toCharArray();
			boolean[] ss = new boolean[n + 1], used = new boolean[n + 1];
			IntStream.range(0, n).forEach(i -> ss[i + 1] = ONE == s[i]);
			Arrays.fill(used, false);
			List<Integer> answer = new ArrayList<>();
			dfs(1, edges, ss, used, answer);
			if (ss[1]) {
				answer.add(edges[1].get(0));
				answer.add(1);
				answer.add(edges[1].get(0));
			}
			System.out.println(answer.size());
			System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * 結果を再帰的に組み立てる
	 *
	 * @param now    現在処理中のノード
	 * @param edges  辺の一覧
	 * @param ss     ノードの数の偶数、奇数の配列
	 * @param used   ノードが使用されたかどうかの配列
	 * @param answer 結果
	 */
	private static void dfs(int now, List<Integer>[] edges, boolean[] ss, boolean[] used, List<Integer> answer) {
		used[now] = true;
		answer.add(now);
		ss[now] = !ss[now];
		for (int next : edges[now]) {
			if (!used[next]) {
				dfs(next, edges, ss, used, answer);
				answer.add(now);
				ss[now] = !ss[now];
				if (ss[next]) {
					answer.add(next);
					ss[next] = !ss[next];
					answer.add(now);
					ss[now] = !ss[now];
				}
			}
		}
	}
}
