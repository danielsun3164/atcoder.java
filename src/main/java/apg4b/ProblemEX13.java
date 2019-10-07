package apg4b;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX13 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int average = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).sum() / n;
			IntStream.range(0, n).map(i -> Math.abs(a[i] - average)).forEach(System.out::println);
		}
	}
}
