package apg4b;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX17 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			int[] p = new int[n];
			IntStream.range(0, n).forEach(i -> p[i] = scanner.nextInt());
			System.out.println(IntStream.range(0, n)
					.map(i -> (int) IntStream.range(0, n).filter(j -> a[i] + p[j] == s).count()).sum());
		}
	}
}
