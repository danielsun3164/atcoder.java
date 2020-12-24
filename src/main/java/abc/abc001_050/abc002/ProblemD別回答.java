package abc.abc001_050.abc002;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 深さ優先探索で実装したソースコード
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			boolean[][] relation = new boolean[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(relation[i], false));
			IntStream.range(0, n).forEach(i -> relation[i][i] = true);
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
				relation[x][y] = relation[y][x] = true;
			});
			Stack<Integer> stack = new Stack<>();
			System.out.println(dfs(n, stack, relation, 0));
		}
	}

	/**
	 * 深さ優先探索で最大派閥人数を計算する
	 * 
	 * @param n        議員の総数
	 * @param stack    派閥に属する議員
	 * @param relation 議員間の関係を表す配列
	 * @param k        現在処理した人数
	 * @return 最大派閥人数
	 */
	private static int dfs(int n, Stack<Integer> stack, final boolean[][] relation, int k) {
		int answer = 0;
		if (n == k) {
			for (int i = 0; i < stack.size(); i++) {
				for (int j = i + 1; j < stack.size(); j++) {
					if (!relation[stack.get(i)][stack.get(j)]) {
						return answer;
					}
				}
			}
			answer = Math.max(answer, stack.size());
		} else {
			answer = Math.max(answer, dfs(n, stack, relation, k + 1));
			stack.add(k);
			answer = Math.max(answer, dfs(n, stack, relation, k + 1));
			stack.pop();
		}
		return answer;
	}
}
