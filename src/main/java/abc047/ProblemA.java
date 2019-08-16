package abc047;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int NUM = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[NUM];
			IntStream.range(0, NUM).forEach(i -> a[i] = scanner.nextInt());
			int sum = Arrays.stream(a).sum();
			int max = Arrays.stream(a).max().getAsInt();
			System.out.println((sum == max + max) ? "Yes" : "No");
		}
	}
}
