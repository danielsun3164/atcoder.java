package abc.abc201_250.abc236;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt() << 1;
			long[][] a = new long[n - 1][];
			IntStream.range(0, n - 1)
					.forEach(i -> a[i] = IntStream.range(0, n - i - 1).mapToLong(j -> scanner.nextLong()).toArray());
			boolean[] used = new boolean[n];
			Arrays.fill(used, false);
			int[] order = new int[n];
			System.out.println(dfs(n, a, used, order, 0));
		}
	}

	/**
	 * 結果を再帰的に計算する
	 *
	 * @param n     人数
	 * @param a     相性の配列
	 * @param used  該当の人が参加したかどうかの配列
	 * @param order 順番の配列
	 * @param index 現在の処理対象インデックス
	 * @return 結果
	 */
	private static long dfs(int n, long[][] a, boolean[] used, int[] order, int index) {
		if (n == index) {
			return IntStream.iterate(0, i -> i < n, i -> i += 2)
					.mapToLong(i -> a[order[i]][order[i + 1] - order[i] - 1]).reduce(0L, (s, bi) -> s ^ bi);
		}
		int start = IntStream.range(0, n).filter(i -> !used[i]).findFirst().getAsInt();
		order[index++] = start;
		used[start] = true;
		long answer = 0L;
		for (int i = start + 1; i < n; i++) {
			if (!used[i]) {
				order[index++] = i;
				used[i] = true;
				answer = Math.max(answer, dfs(n, a, used, order, index));
				used[i] = false;
				index--;
			}
		}
		used[start] = false;
		return answer;
	}
}
