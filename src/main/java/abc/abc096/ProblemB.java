package abc.abc096;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[N];
			IntStream.range(0, N).forEach(i -> a[i] = scanner.nextInt());
			int k = scanner.nextInt();
			Arrays.sort(a);
			a[N - 1] = a[N - 1] << k;
			System.out.println(Arrays.stream(a).sum());
		}
	}
}
