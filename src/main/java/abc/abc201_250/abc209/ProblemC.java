package abc.abc201_250.abc209;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] c = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			System.out.println(
					IntStream.range(0, n).mapToLong(i -> Math.max(0, c[i] - i)).reduce(1, (s, ci) -> s * ci % MOD));
		}
	}
}
