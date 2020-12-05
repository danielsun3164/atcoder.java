package other.joi2007ho;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long[] s = new long[n + 1];
			s[0] = 0L;
			IntStream.range(0, n).forEach(i -> s[i + 1] = s[i] + a[i]);
			System.out.println(IntStream.rangeClosed(k, n).mapToLong(i -> s[i] - s[i - k]).max().getAsLong());
		}
	}
}
