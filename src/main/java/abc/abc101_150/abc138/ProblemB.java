package abc.abc101_150.abc138;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 割り算の被除数 */
	private static final double N = 10_000.0d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(N / Arrays.stream(a).mapToDouble(ai -> N / ai).sum());
		}
	}
}
