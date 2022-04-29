package abc.abc151_200.abc161;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[n];
			int line = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt() * 4 * m).sum() / 4 / m;
			System.out.println((IntStream.range(0, n).filter(i -> a[i] >= line).count() >= m) ? "Yes" : "No");
		}
	}
}
