package abc050;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] t = new int[n];
			IntStream.range(0, n).forEach(i -> t[i] = scanner.nextInt());
			int m = scanner.nextInt();
			int[] p = new int[m], x = new int[m];
			IntStream.range(0, m).forEach(i -> {
				p[i] = scanner.nextInt() - 1;
				x[i] = scanner.nextInt();
			});
			int sum = Arrays.stream(t).sum();
			IntStream.range(0, m).map(i -> sum - t[p[i]] + x[i]).forEach(System.out::println);
		}
	}
}
