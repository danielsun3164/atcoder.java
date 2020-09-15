package abc.abc047;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** 入力数字の数 */
	private static final int NUM = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[NUM];
			int sum = IntStream.range(0, NUM).map(i -> a[i] = scanner.nextInt()).sum();
			int max = Arrays.stream(a).max().getAsInt();
			System.out.println((sum == max + max) ? "Yes" : "No");
		}
	}
}
