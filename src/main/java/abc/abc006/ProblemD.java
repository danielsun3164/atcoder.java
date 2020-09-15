package abc.abc006;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] r = new int[n + 1];
			Arrays.fill(r, Integer.MAX_VALUE);
			r[0] = Integer.MIN_VALUE;
			Arrays.stream(c).forEach(i -> {
				int index = ~Arrays.binarySearch(r, i);
				r[index] = i;
			});
			System.out.println(Arrays.stream(r).filter(i -> i == Integer.MAX_VALUE).count());
		}
	}
}
