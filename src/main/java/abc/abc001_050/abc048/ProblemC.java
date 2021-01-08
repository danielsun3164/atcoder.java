package abc.abc001_050.abc048;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
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
