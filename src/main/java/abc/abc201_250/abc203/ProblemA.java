package abc.abc201_250.abc203;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemA {

	/** 数字の数 */
	private static int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<Integer> set = new HashSet<>();
			IntStream.range(0, N).forEach(i -> {
				int a = scanner.nextInt();
				if (set.contains(a)) {
					set.remove(a);
				} else {
					set.add(a);
				}
			});
			System.out.println((1 == set.size()) ? set.stream().findFirst().get() : 0);
		}
	}
}
