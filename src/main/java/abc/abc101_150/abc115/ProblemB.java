package abc.abc101_150.abc115;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = new int[n];
			int sum = IntStream.range(0, n).map(i -> p[i] = scanner.nextInt()).sum();
			System.out.println(sum - Arrays.stream(p).max().getAsInt() / 2);
		}
	}
}
