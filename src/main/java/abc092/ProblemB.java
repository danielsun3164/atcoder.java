package abc092;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int d = scanner.nextInt(), x = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			System.out.println(x + IntStream.range(0, n).map(i -> (d - 1) / a[i] + 1).sum());
		}
	}
}
