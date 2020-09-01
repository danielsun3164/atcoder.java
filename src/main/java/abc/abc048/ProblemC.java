package abc.abc048;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int x = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			long sum = 0L;
			for (int i = 0; i < n - 1; i++) {
				if (a[i] + a[i + 1] > x) {
					sum += a[i] + a[i + 1] - x;
					a[i + 1] -= Math.min(a[i] + a[i + 1] - x, a[i + 1]);
				}
			}
			System.out.println(sum);
		}
	}
}
