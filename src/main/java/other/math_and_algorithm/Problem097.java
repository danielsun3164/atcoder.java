package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem097 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long l = scanner.nextLong(), r = scanner.nextLong();
			boolean[] isPrime = new boolean[(int) (r - l + 1)];
			Arrays.fill(isPrime, true);
			isPrime[0] = (1L != l);
			LongStream.iterate(2L, i -> i * i <= r, i -> i + 1)
					.forEach(i -> LongStream.iterate((l + i - 1) / i * i, j -> j <= r, j -> j += i).filter(j -> j != i)
							.forEach(j -> isPrime[(int) (j - l)] = false));
			System.out.println(IntStream.range(0, isPrime.length).filter(i -> isPrime[i]).count());
		}
	}
}
