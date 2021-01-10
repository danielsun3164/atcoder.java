package abc.abc151_200.abc188;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long sum = IntStream.range(0, n).mapToLong(i -> a[i] * b[i]).sum();
			System.out.println((0L == sum) ? "Yes" : "No");
		}
	}
}
