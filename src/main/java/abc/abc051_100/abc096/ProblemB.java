package abc.abc051_100.abc096;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = IntStream.range(0, N).map(i -> scanner.nextInt()).sorted().toArray();
			int k = scanner.nextInt();
			a[N - 1] = a[N - 1] << k;
			System.out.println(Arrays.stream(a).sum());
		}
	}
}
