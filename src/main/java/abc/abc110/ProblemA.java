package abc.abc110;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[N];
			int sum = IntStream.range(0, N).map(i -> a[i] = scanner.nextInt()).sum();
			System.out.println(sum + Arrays.stream(a).max().getAsInt() * 9);
		}
	}
}
