package abc.abc001_050.abc037;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = new int[n];
			Arrays.fill(a, 0);
			IntStream.range(0, q).forEach(i -> {
				int l = scanner.nextInt() - 1;
				int r = scanner.nextInt();
				int t = scanner.nextInt();
				Arrays.fill(a, l, r, t);
			});
			Arrays.stream(a).forEach(System.out::println);
		}
	}
}
