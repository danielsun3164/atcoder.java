package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem025 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			double[] a = IntStream.range(0, n).mapToDouble(i -> scanner.nextDouble()).toArray(),
					b = IntStream.range(0, n).mapToDouble(i -> scanner.nextDouble()).toArray();
			System.out.println(IntStream.range(0, n).mapToDouble(i -> a[i] / 3 + b[i] * 2 / 3).sum());
		}
	}
}
