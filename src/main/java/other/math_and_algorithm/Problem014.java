package other.math_and_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem014 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int q = (int) Math.sqrt(n);
			boolean[] isPrime = calcIsPrime(q);
			List<Long> answer = new ArrayList<>();
			for (int i = 2; i <= q; i++) {
				if (isPrime[i]) {
					while (0L == n % i) {
						n /= i;
						answer.add((long) i);
					}
				}
			}
			if (n > 1L) {
				answer.add(n);
			}
			System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * n以下の素数かどうかの配列を計算する
	 *
	 * @param n
	 * @return n以下の素数かどうかの配列
	 */
	private static boolean[] calcIsPrime(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		IntStream.rangeClosed(2, n).filter(i -> isPrime[i]).forEach(i -> {
			for (int j = i + i; j <= n; j += i) {
				isPrime[j] = false;
			}
		});
		return isPrime;
	}
}
