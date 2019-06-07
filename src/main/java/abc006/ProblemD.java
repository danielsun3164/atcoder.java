package abc006;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = new int[n];
			IntStream.range(0, n).forEach(i -> c[i] = scanner.nextInt());
			int[] r = new int[n + 1];
			r[0] = Integer.MIN_VALUE;
			IntStream.rangeClosed(1, n).forEach(i -> r[i] = Integer.MAX_VALUE);
			Arrays.stream(c).forEach(i -> {
				int index = -Arrays.binarySearch(r, i) - 1;
				r[index] = i;
			});
			System.out.println(Arrays.stream(r).filter(i -> i == Integer.MAX_VALUE).count());
		}
	}
}
