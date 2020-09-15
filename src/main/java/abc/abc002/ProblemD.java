package abc.abc002;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

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
			List<Integer> list = IntStream.range(1, (int) Math.pow(2, n)).boxed()
					.sorted((x, y) -> Integer.bitCount(y) - Integer.bitCount(x)).collect(Collectors.toList());
			for (Integer integer : list) {
				Set<Integer> set = IntStream.range(0, n).filter(j -> (1 == (1 & (integer >> j)))).boxed()
						.collect(Collectors.toSet());
				if (check(set, relation)) {
					System.out.println(set.size());
					break;
				}
			}
		}
	}

	/**
	 * 派閥に所属する議員がお互い知っているかどうかをチェック
	 * 
	 * @param set      派閥に所属する議員のセット
	 * @param relation お互いの関係の配列
	 * @return 派閥に所属する議員がお互い知っている
	 */
	private static boolean check(Set<Integer> set, final boolean[][] relation) {
		for (Integer i : set) {
			for (Integer j : set) {
				if (!relation[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
