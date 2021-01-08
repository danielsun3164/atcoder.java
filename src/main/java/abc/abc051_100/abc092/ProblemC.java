package abc.abc051_100.abc092;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n + 2];
			a[0] = a[n + 1] = 0;
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = scanner.nextInt());
			int sum = IntStream.rangeClosed(0, n).map(i -> Math.abs(a[i] - a[i + 1])).sum();
			IntStream.rangeClosed(1, n).map(
					i -> sum - Math.abs(a[i] - a[i - 1]) - Math.abs(a[i] - a[i + 1]) + Math.abs(a[i - 1] - a[i + 1]))
					.forEach(System.out::println);
		}
	}
}
