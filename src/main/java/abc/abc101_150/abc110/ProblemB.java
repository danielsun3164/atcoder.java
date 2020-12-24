package abc.abc101_150.abc110;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] x = new int[n + 1], y = new int[m + 1];
			x[0] = scanner.nextInt();
			y[0] = scanner.nextInt();
			IntStream.rangeClosed(1, n).forEach(i -> x[i] = scanner.nextInt());
			IntStream.rangeClosed(1, m).forEach(i -> y[i] = scanner.nextInt());
			System.out.println(
					(Arrays.stream(x).max().getAsInt() < Arrays.stream(y).min().getAsInt()) ? "No War" : "War");
		}
	}
}
