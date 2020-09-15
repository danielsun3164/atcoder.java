package abc.abc024;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), t = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(IntStream.range(1, n).map(i -> Math.min(a[i] - a[i - 1], t)).sum() + t);
		}
	}
}
