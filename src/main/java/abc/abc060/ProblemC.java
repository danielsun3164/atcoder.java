package abc.abc060;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long t = scanner.nextLong();
			long[] a = new long[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextLong());
			System.out.println(IntStream.range(1, n).mapToLong(i -> Math.min(a[i] - a[i - 1], t)).sum() + t);
		}
	}
}
