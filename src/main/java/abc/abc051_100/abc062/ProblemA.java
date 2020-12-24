package abc.abc051_100.abc062;

import java.util.Scanner;
import java.util.Set;

public class ProblemA {

	@SuppressWarnings("unchecked")
	private static final Set<Integer>[] SETS = new Set[] { Set.of(1, 3, 5, 7, 8, 10, 12), Set.of(4, 6, 9, 11),
			Set.of(12) };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			System.out.println((getSet(x) == getSet(y)) ? "Yes" : "No");
		}
	}

	/**
	 * @param n 入力数字
	 * @return 入力数字を含まれるセット
	 */
	private static Set<Integer> getSet(int n) {
		for (Set<Integer> set : SETS) {
			if (set.contains(n)) {
				return set;
			}
		}
		return null;
	}
}
