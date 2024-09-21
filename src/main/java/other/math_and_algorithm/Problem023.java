package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem023 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			double bSum = IntStream.range(0, n).mapToDouble(i -> scanner.nextDouble()).sum(),
					rSum = IntStream.range(0, n).mapToDouble(i -> scanner.nextDouble()).sum();
			System.out.println((bSum + rSum) / n);
		}
	}
}
