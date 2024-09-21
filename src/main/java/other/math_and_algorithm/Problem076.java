package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem076 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			System.out.println(IntStream.range(0, n).mapToLong(i -> a[i] * (i * 2 - (n - 1))).sum());
		}
	}
}
