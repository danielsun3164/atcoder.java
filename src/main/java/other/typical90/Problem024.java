package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem024 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long sum = IntStream.range(0, n).mapToLong(i -> Math.abs(a[i] - scanner.nextLong())).sum();
			System.out.println(((k >= sum) && (0 == ((k - sum) & 1L))) ? "Yes" : "No");
		}
	}
}
