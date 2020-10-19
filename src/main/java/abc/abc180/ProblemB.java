package abc.abc180;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] x = IntStream.range(0, n).map(i -> Math.abs(scanner.nextInt())).toArray();
			System.out.println(Arrays.stream(x).mapToLong(xi -> xi).sum());
			System.out.println(Math.sqrt(Arrays.stream(x).mapToDouble(xi -> (double) xi * xi).sum()));
			System.out.println(Arrays.stream(x).max().getAsInt());
		}
	}
}
