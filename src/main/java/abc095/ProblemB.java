package abc095;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			int[] m = new int[n];
			int sum = IntStream.range(0, n).map(i -> m[i] = scanner.nextInt()).sum();
			int min = Arrays.stream(m).min().getAsInt();
			System.out.println((x - sum) / min + n);
		}
	}
}
