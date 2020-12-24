package abc.abc151_200.abc176;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = new long[n];
			// max[i]=max(a[0],...,a[i-1])
			long[] max = new long[n];
			a[0] = scanner.nextInt();
			max[0] = 0;
			System.out.println(IntStream.range(1, n).mapToLong(i -> {
				a[i] = scanner.nextInt();
				max[i] = Math.max(max[i - 1], a[i - 1]);
				return (max[i] > a[i]) ? max[i] - a[i] : 0;
			}).sum());
		}
	}
}
