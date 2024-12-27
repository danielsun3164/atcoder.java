package abc.abc201_250.abc238;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 360 */
	private static final int N = 360;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n + 2];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				IntStream.range(0, i).forEach(j -> a[j] = (a[j] + a[i]) % N);
			});
			a[n] = 0;
			a[n + 1] = N;
			Arrays.sort(a);
			System.out.println(IntStream.rangeClosed(0, n).map(i -> a[i + 1] - a[i]).max().getAsInt());
		}
	}
}
