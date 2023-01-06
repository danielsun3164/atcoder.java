package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem075 {

	/** 10^6 */
	private static final int N = 1_000_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int[] primes = calcPrimes(N);
			int count = 0, answer = 0;
			for (int p : primes) {
				if (0L == n % p) {
					while (0L == n % p) {
						n /= p;
						count++;
					}
				}
				if (p * p > n) {
					break;
				}
			}
			count += (n > 1) ? 1 : 0;
			while ((1 << answer) < count) {
				answer++;
			}
			System.out.println(answer);
		}
	}

	/**
	 * n以下の素数の一覧を計算する
	 *
	 * @param n
	 * @return n以下の素数の一覧
	 */
	private static int[] calcPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		return IntStream.range(0, n).filter(i -> isPrime[i]).toArray();
	}
}
