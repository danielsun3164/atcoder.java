package abc.abc151_200.abc200;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 200の定数 */
	private static final int N = 200;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] count = new int[N];
			Arrays.fill(count, 0);
			IntStream.range(0, n).forEach(i -> count[scanner.nextInt() % N]++);
			System.out.println(Arrays.stream(count).mapToLong(ci -> (ci * (long) (ci - 1)) / 2L).sum());
		}
	}
}
