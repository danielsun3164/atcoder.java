package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Problem092 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println(LongStream.iterate(1L, i -> i * i <= n, i -> i + 1).filter(i -> 0 == n % i)
					.map(i -> (i + n / i) << 1).min().getAsLong());
		}
	}
}
