package abc.abc101_150.abc149;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 答えとして最大の素数 */
	private static final int N = 100_003;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			boolean[] isPrimes = new boolean[N + 1];
			Arrays.fill(isPrimes, true);
			isPrimes[0] = isPrimes[1] = false;
			IntStream.rangeClosed(2, N).forEach(i -> {
				if (isPrimes[i]) {
					for (int j = i + i; j <= N; j += i) {
						isPrimes[j] = false;
					}
				}
			});
			System.out.println(IntStream.rangeClosed(x, N).filter(i -> isPrimes[i]).findFirst().getAsInt());
		}
	}
}
