package apg4b;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX14 {

	/** 整数の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[N];
			IntStream.range(0, N).forEach(i -> a[i] = scanner.nextInt());
			Arrays.sort(a);
			System.out.println(a[N - 1] - a[0]);
		}
	}
}
