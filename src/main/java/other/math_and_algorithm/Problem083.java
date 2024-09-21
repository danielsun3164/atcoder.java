package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem083 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).sorted().toArray(),
					b = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			System.out.println(IntStream.range(0, n).mapToLong(i -> Math.abs(b[i] - a[i])).sum());
		}
	}
}
