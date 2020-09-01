package other.past201912;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	private static final int N = 6;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = new int[N];
			IntStream.range(0, N).forEach(i -> a[i] = scanner.nextInt());
			Arrays.sort(a);
			System.out.println(a[3]);
		}
	}
}
