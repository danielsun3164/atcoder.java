package abc.abc101_150.abc140;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] c = IntStream.range(0, n - 1).map(i -> scanner.nextInt()).toArray();
			System.out.println(IntStream.range(0, n)
					.map(i -> b[a[i]] + (((i < n - 1) && (a[i] + 1 == a[i + 1])) ? c[a[i]] : 0)).sum());
		}
	}
}
