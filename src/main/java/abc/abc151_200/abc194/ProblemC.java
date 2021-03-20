package abc.abc151_200.abc194;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			int[] sum = new int[n];
			sum[0] = 0;
			IntStream.range(1, n).forEach(i -> sum[i] = sum[i - 1] + a[i - 1]);
			System.out.println(IntStream.range(0, n).mapToLong(i -> (n - 1) * (long) a[i] * a[i]).sum()
					- 2L * IntStream.range(0, n).mapToLong(i -> a[i] * (long) sum[i]).sum());
		}
	}
}
