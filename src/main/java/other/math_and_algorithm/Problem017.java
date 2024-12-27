package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem017 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			System.out.println(IntStream.range(1, n).mapToLong(i -> a[i]).reduce(a[0], (s, ai) -> s / gcd(s, ai) * ai));
		}
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0L == b) ? a : gcd(b, a % b);
	}
}
