package abc.abc115;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] h = new int[n];
			IntStream.range(0, n).forEach(i -> h[i] = scanner.nextInt());
			Arrays.sort(h);
			System.out.println(IntStream.rangeClosed(0, n - k).map(i -> h[i + k - 1] - h[i]).min().getAsInt());
		}
	}
}
