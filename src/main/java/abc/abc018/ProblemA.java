package abc.abc018;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] array = new int[N];
			IntStream.range(0, N).forEach(i -> array[i] = scanner.nextInt());
			int[] sortedArray = array.clone();
			Arrays.sort(sortedArray);
			IntStream.range(0, N).map(i -> N - Arrays.binarySearch(sortedArray, array[i])).forEach(System.out::println);
		}
	}
}
