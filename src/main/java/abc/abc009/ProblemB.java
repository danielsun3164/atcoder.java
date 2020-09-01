package abc.abc009;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			IntStream.range(0, n).map(i -> scanner.nextInt()).distinct().boxed().sorted((x, y) -> y.compareTo(x))
					.skip(1).findFirst().ifPresent(System.out::println);
		}
	}
}
