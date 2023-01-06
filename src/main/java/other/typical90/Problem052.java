package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem052 {

	/** サイコロの6面 */
	private static final int N = 6;
	/** mod対象数字 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(
					IntStream.range(0, n).mapToLong(i -> IntStream.range(0, N).map(j -> scanner.nextInt()).sum())
							.reduce(1L, (s, sum) -> s * sum % MOD));
		}
	}
}
