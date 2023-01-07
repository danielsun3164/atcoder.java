package other.typical90;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * サンプルコードではTLEが発生するため、https://atcoder.jp/contests/typical90/submissions/23831973 にも参考
 */
public class Problem071 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			int[] degrees = new int[n];
			Arrays.fill(degrees, 0);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				edges[a].add(b);
				degrees[b]++;
			});
			Deque<Integer> st = new ArrayDeque<>();
			List<String> answers = new ArrayList<>();
			IntStream.range(0, n).filter(i -> 0 == degrees[i]).forEach(i -> st.add(i));
			dfs(n, k, edges, degrees, 0, new int[n], st, answers);
			if (k != answers.size()) {
				System.out.println(-1);
			} else {
				// TLE対策のため、結果をStringBuilderに入れる
				StringBuilder sb = new StringBuilder();
				answers.forEach(answer -> sb.append(answer).append(System.lineSeparator()));
				System.out.print(sb.toString());
				System.out.flush();
			}
		}
	}

	/**
	 * 結果を再帰的に計算する
	 *
	 * @param n       ノードの数
	 * @param k       結果の数
	 * @param edges   辺の一覧
	 * @param degrees 各ノードの上位ノード数の一覧
	 * @param depth   現在何番目を計算中か
	 * @param perm    途中結果
	 * @param st      上位ノードが存在しないノードの一覧
	 * @param answers 結果の一覧
	 * @return 正しく計算できているか
	 */
	private static boolean dfs(int n, int k, List<Integer>[] edges, int[] degrees, int depth, int[] perm,
			Deque<Integer> st, List<String> answers) {
		if (n == depth) {
			answers.add(Arrays.stream(perm).mapToObj(p -> Integer.toString(p + 1)).collect(Collectors.joining(" ")));
			return true;
		}
		if (st.isEmpty()) {
			return false;
		}

		int stSize = st.size();
		for (int i = 0; i < stSize; i++) {
			if (answers.size() >= k) {
				return true;
			}
			int x = st.pollFirst();
			for (int j : edges[x]) {
				if (0 == --degrees[j]) {
					st.addLast(j);
				}
			}
			perm[depth] = x;
			boolean sign = dfs(n, k, edges, degrees, depth + 1, perm, st, answers);
			if (!sign) {
				return false;
			}
			for (int j : edges[x]) {
				if (0 == degrees[j]++) {
					st.pollLast();
				}
			}
			st.addLast(x);
		}
		return true;
	}
}
