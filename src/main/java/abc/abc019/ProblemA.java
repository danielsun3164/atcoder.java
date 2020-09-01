package abc.abc019;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] array = new int[N];
			IntStream.range(0, N).forEach(i -> array[i] = scanner.nextInt());
			Arrays.sort(array);
			System.out.println(array[1]);
		}
	}
}
