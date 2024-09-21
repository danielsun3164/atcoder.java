package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem094 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n], b = IntStream.range(0, n - 1).map(i -> scanner.nextInt()).toArray();
			a[0] = b[0];
			a[n - 1] = b[n - 2];
			IntStream.range(0, n - 2).forEach(i -> a[i + 1] = Math.min(b[i], b[i + 1]));
			System.out.println(Arrays.stream(a).sum());
		}
	}
}
