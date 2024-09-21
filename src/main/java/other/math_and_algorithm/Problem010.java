package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem010 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] fact = new long[n + 1];
			fact[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> fact[i] = fact[i - 1] * i);
			System.out.println(fact[n]);
		}
	}
}
