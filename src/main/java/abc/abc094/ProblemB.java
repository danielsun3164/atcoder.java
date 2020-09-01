package abc.abc094;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.nextInt();
			int m = scanner.nextInt(), x = scanner.nextInt();
			int[] a = new int[m];
			IntStream.range(0, m).forEach(i -> a[i] = scanner.nextInt());
			System.out.println(
					Math.min(Arrays.stream(a).filter(i -> i > x).count(), Arrays.stream(a).filter(i -> i < x).count()));
		}
	}
}
