package abc.abc088;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			Arrays.sort(a);
			System.out.println(IntStream.range(0, n).filter(i -> (i & 1) == 0).map(i -> a[n - 1 - i]).sum()
					- IntStream.range(0, n).filter(i -> (i & 1) == 1).map(i -> a[n - 1 - i]).sum());
		}
	}
}
