package abc.abc151_200.abc187;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 * 
 * https://atcoder.jp/contests/abc187/submissions/19103187 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n - 1], b = new int[n - 1], depths = new int[n];
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
				childrens[a[i]].add(b[i]);
				childrens[b[i]].add(a[i]);
			});
			setDepths(0, -1, depths, 0, childrens);
			long[] answer = new long[n];
			Arrays.fill(answer, 0L);
			int q = scanner.nextInt();
			IntStream.range(0, q).forEach(i -> {
				int t = scanner.nextInt(), e = scanner.nextInt() - 1, x = scanner.nextInt();
				int to = (depths[a[e]] > depths[b[e]]) ? a[e] : b[e];
				t = (depths[a[e]] > depths[b[e]]) ? 3 - t : t;
				if (1 == t) {
					answer[0] += x;
					answer[to] -= x;
				} else {
					answer[to] += x;
				}
			});
			Queue<Integer> que = new ArrayDeque<>();
			que.add(0);
			while (!que.isEmpty()) {
				int now = que.poll();
				for (int next : childrens[now]) {
					if (depths[now] < depths[next]) {
						answer[next] += answer[now];
						que.add(next);
					}
				}
			}
			// TLE対策のためのStringBuilder
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append("\n"));
			System.out.print(sb.toString());
		}
	}

	/**
	 * depthsの配列を入れる
	 * 
	 * @param now       現在の処理対象
	 * @param from      直前の処理対象
	 * @param depths    depths
	 * @param depth     深さ
	 * @param childrens 子どもの配列
	 */
	private static void setDepths(int now, int from, int[] depths, int depth, final List<Integer>[] childrens) {
		depths[now] = depth;
		for (int child : childrens[now]) {
			if (child != from) {
				setDepths(child, now, depths, depth + 1, childrens);
			}
		}
	}
}
