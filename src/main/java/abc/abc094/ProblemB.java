package abc.abc094;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), m = scanner.nextInt(), x = scanner.nextInt();
			int[] a = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			System.out.println(
					Math.min(Arrays.stream(a).filter(i -> i > x).count(), Arrays.stream(a).filter(i -> i < x).count()));
		}
	}
}
