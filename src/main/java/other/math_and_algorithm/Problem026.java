package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem026 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, n).mapToDouble(i -> n * 1.0d / i).sum());
		}
	}
}
