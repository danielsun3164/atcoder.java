package abc.abc201_250.abc220;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			List<Long> sums = new ArrayList<>();
			sums.add(a[0]);
			IntStream.range(1, n).forEach(i -> sums.add(sums.get(i - 1) + a[i]));
			long x = scanner.nextLong(), d = x % sums.get(n - 1);
			System.out.println(x / sums.get(n - 1) * n
					+ (~Collections.binarySearch(sums, d, (p, q) -> (p.compareTo(q) > 0) ? 1 : -1)) + 1);
		}
	}
}
