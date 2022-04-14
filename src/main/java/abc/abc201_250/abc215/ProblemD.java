package abc.abc201_250.abc215;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemD {

	/** 最大値 */
	private static final int N = 100_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] primes = calcPrimes();
			// 処理したaのセットと処理した素数のセット
			Set<Integer> processedSet = new HashSet<>(), primeSet = new HashSet<>();
			boolean[] isAnswer = new boolean[m + 1];
			Arrays.fill(isAnswer, true);
			isAnswer[0] = false;
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				if (!processedSet.contains(a)) {
					processedSet.add(a);
					for (int prime : primes) {
						if (prime > a) {
							break;
						}
						if (0 == a % prime) {
							while (0 == a % prime) {
								a /= prime;
							}
							if (!primeSet.contains(prime)) {
								primeSet.add(prime);
								for (int j = prime; j <= m; j += prime) {
									isAnswer[j] = false;
								}
							}
						}
					}
				}
			});
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			int[] answer = IntStream.rangeClosed(1, m).filter(i -> isAnswer[i]).toArray();
			sb.append(answer.length).append(System.lineSeparator());
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * Nまでの素数の配列を計算する
	 *
	 * @return Nまでの素数の配列
	 */
	private static int[] calcPrimes() {
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		IntStream.rangeClosed(2, N).filter(i -> isPrime[i]).forEach(i -> {
			for (int j = i + i; j <= N; j += i) {
				isPrime[j] = false;
			}
		});
		return IntStream.rangeClosed(0, N).filter(i -> isPrime[i]).toArray();
	}
}
