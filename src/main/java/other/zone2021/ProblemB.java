package other.zone2021;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt(), h = scanner.nextInt();
			int[] di = new int[n], hi = new int[n];
			IntStream.range(0, n).forEach(i -> {
				di[i] = scanner.nextInt();
				hi[i] = scanner.nextInt();
			});
			System.out.println(Math.max(0.0d, IntStream.range(0, n)
					.mapToDouble(i -> (h - ((((h - hi[i]) * 1.0d) / (d - di[i])) * d))).max().getAsDouble()));
		}
	}
}
