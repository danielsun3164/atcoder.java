package abc.abc101_150.abc145;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], y = new int[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			boolean[] visited = new boolean[n];
			Arrays.fill(visited, false);
			double answer = calc(0, n, x, y, visited, new ArrayList<>());
			for (int i = 2; i <= n; i++) {
				answer /= i;
			}
			System.out.println(answer);
		}
	}

	/**
	 * すべての経路の移動距離の合計を計算する
	 *
	 * @param current 現在計算した町
	 * @param n       町の総数
	 * @param x       X座標の配列
	 * @param y       Y座標の配列
	 * @param visited 各座標がアクセスされたかどうかを保存する配列
	 * @param list    たどった経路を保存するリスト
	 * @return すべての経路の移動距離の合計
	 */
	private static double calc(int current, final int n, final int[] x, final int[] y, boolean[] visited,
			List<Integer> list) {
		if (n == current) {
			return IntStream.range(1, list.size())
					.mapToDouble(
							i -> Math.hypot(x[list.get(i)] - x[list.get(i - 1)], y[list.get(i)] - y[list.get(i - 1)]))
					.sum();
		}
		double answer = 0.0d;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(i);
				answer += calc(current + 1, n, x, y, visited, list);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
		return answer;
	}
}
