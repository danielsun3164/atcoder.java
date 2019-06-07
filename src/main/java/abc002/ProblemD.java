package abc002;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			scanner.nextLine();
			boolean relation[][] = new boolean[n][n];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> relation[i][j] = false));
			IntStream.range(0, n).forEach(i -> relation[i][i] = true);
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				scanner.nextLine();
				relation[x - 1][y - 1] = relation[y - 1][x - 1] = true;
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

	private static boolean check(Set<Integer> set, boolean[][] relation) {
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
