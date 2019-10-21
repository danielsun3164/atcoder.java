package abc062;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int N = 3;

	@SuppressWarnings("unchecked")
	private static final Set<Integer>[] SETS = new Set[N];

	static {
		IntStream.range(0, N).forEach(i -> SETS[i] = new HashSet<>());
	}

	static {
		SETS[0].add(1);
		SETS[0].add(3);
		SETS[0].add(5);
		SETS[0].add(7);
		SETS[0].add(8);
		SETS[0].add(10);
		SETS[0].add(12);
	}

	static {
		SETS[1].add(4);
		SETS[1].add(6);
		SETS[1].add(9);
		SETS[1].add(11);
	}

	static {
		SETS[2].add(2);
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
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
