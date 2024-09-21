package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem011 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			boolean[] isPrime = new boolean[n + 1];
			Arrays.fill(isPrime, true);
			isPrime[0] = isPrime[1] = false;
			IntStream.rangeClosed(2, n).filter(i -> isPrime[i]).forEach(i -> {
				for (int j = i + i; j <= n; j += i) {
					isPrime[j] = false;
				}
			});
			System.out.println(IntStream.rangeClosed(1, n).filter(i -> isPrime[i]).mapToObj(String::valueOf)
					.collect(Collectors.joining(" ")));
		}
	}
}
