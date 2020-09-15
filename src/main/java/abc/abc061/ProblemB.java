package abc.abc061;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] result = new int[n];
			Arrays.fill(result, 0);
			IntStream.range(0, 2 * m).forEach(i -> result[scanner.nextInt() - 1]++);
			Arrays.stream(result).forEach(System.out::println);
		}
	}
}
