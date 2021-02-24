package abc.abc101_150.abc138;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(Arrays.stream(a).mapToDouble(ai -> (double) ai).reduce(a[0], (x, ai) -> (x + ai) / 2.0d));
		}
	}
}
