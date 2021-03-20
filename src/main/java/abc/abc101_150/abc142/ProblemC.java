package abc.abc101_150.abc142;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] b = new int[n];
			IntStream.range(0, n).forEach(i -> b[scanner.nextInt() - 1] = i + 1);
			System.out.println(Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
