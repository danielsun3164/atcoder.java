package abc.abc001_050.abc006;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	private static final int BIG = 10007;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] r = new int[Math.max(n, 3)];
			r[0] = r[1] = 0;
			r[2] = 1;
			IntStream.range(3, n).forEach(i -> r[i] = (r[i - 1] + r[i - 2] + r[i - 3]) % BIG);
			System.out.println(r[n - 1]);
		}
	}
}
