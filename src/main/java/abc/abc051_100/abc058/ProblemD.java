package abc.abc051_100.abc058;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			long sumX = mod(IntStream.range(0, n).mapToLong(i -> mod((2 * i + 1 - n) * scanner.nextLong())).sum());
			long sumY = mod(IntStream.range(0, m).mapToLong(i -> mod((2 * i + 1 - m) * scanner.nextLong())).sum());
			System.out.println(mod(sumX * sumY));
		}
	}

	/**
	 * @param l
	 * @return l mod MOD
	 */
	private static long mod(long l) {
		long result = l % MOD;
		return (result >= 0) ? result : result + MOD;
	}
}
