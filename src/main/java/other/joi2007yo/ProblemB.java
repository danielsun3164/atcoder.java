package other.joi2007yo;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	/** クラスの人数 */
	private static final int N = 30;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<Integer> set = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toSet());
			IntStream.range(0, N - 2).forEach(i -> set.remove(scanner.nextInt()));
			set.stream().sorted().forEach(System.out::println);
		}
	}
}
