package abc.abc051_100.abc094;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = new int[n], sortedX = new int[n];
			IntStream.range(0, n).forEach(i -> x[i] = sortedX[i] = scanner.nextInt());
			Arrays.sort(sortedX);
			IntStream.range(0, n).map(i -> {
				int index = Arrays.binarySearch(sortedX, x[i]);
				return (index <= (n - 1) / 2) ? sortedX[n / 2] : sortedX[(n - 1) / 2];
			}).forEach(System.out::println);
		}
	}
}
