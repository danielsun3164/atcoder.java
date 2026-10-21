package abc.abc201_250.abc246;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<Integer> xSet = new HashSet<>(), ySet = new HashSet<>();
			IntStream.range(0, N).forEach(i -> {
				add(xSet, scanner.nextInt());
				add(ySet, scanner.nextInt());
			});
			System.out.println(xSet.stream().findFirst().get() + " " + ySet.stream().findFirst().get());
		}
	}

	/**
	 * setに値を追加・削除する
	 *
	 * <pre>
	 * setに値が入っている場合は削除、入っていない場合は追加
	 * </pre>
	 *
	 * @param set
	 * @param x   値
	 */
	private static void add(Set<Integer> set, int x) {
		if (set.contains(x)) {
			set.remove(x);
		} else {
			set.add(x);
		}
	}
}
