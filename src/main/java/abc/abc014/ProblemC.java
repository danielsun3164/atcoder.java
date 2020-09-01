package abc.abc014;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	private static final int N = 1_000_001 + 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = new int[N];
			IntStream.range(0, N).forEach(i -> c[i] = 0);
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				c[a]++;
				c[b + 1]--;
			});
			IntStream.range(1, N).forEach(i -> c[i] += c[i - 1]);
			System.out.println(Arrays.stream(c).max().getAsInt());
		}
	}
}
