package abc.abc114;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 100までの素数 */
	private static final int[] PRIMES = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
			67, 71, 73, 79, 83, 89, 97 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Integer, Integer> primeMap = new HashMap<>();
			IntStream.rangeClosed(2, n).forEach(i -> {
				int m = i, j = 0;
				while ((m > 1) && (m >= PRIMES[j])) {
					while (0 == (m % PRIMES[j])) {
						m /= PRIMES[j];
						primeMap.put(PRIMES[j], primeMap.getOrDefault(PRIMES[j], 0) + 1);
					}
					j++;
				}
			});
			// 約数が74個以上の素数の数
			int over74Count = (int) primeMap.values().stream().filter(i -> i >= 74).count();
			// 約数が24個以上の素数の数
			int over24Count = (int) primeMap.values().stream().filter(i -> i >= 24).count();
			// 約数が14個以上の素数の数
			int over14Count = (int) primeMap.values().stream().filter(i -> i >= 14).count();
			// 約数が4個以上の素数の数
			int over4Count = (int) primeMap.values().stream().filter(i -> i >= 4).count();
			// 約数が2個以上の素数の数
			int over2Count = (int) primeMap.values().stream().filter(i -> i >= 2).count();
			int answer = 0;
			// 75x1=75
			answer += over74Count;
			// 25x3=75
			answer += over24Count * (over2Count - 1);
			// 15x5=75
			answer += over14Count * (over4Count - 1);
			// 5x5x3=75
			answer += over4Count * (over4Count - 1) / 2 * (over2Count - 2);
			System.out.println(answer);
		}
	}
}
