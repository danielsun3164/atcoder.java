package other.math_and_algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem068 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int k = scanner.nextInt();
			int[] v = IntStream.range(0, k).map(i -> scanner.nextInt()).distinct().toArray();
			int l = v.length;
			System.out.println(IntStream.range(1, 1 << l)
					.mapToLong(bit -> ((1 == (1 & Integer.bitCount(bit))) ? 1 : -1) * (n / IntStream.range(0, l)
							.filter(i -> 1 == (1 & (bit >> i))).mapToLong(i -> v[i]).reduce(1L, (s, vi) -> lcm(s, vi))))
					.sum());
		}
	}

	/**
	 * aとbの最小公倍数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最小公倍数
	 */
	private static long lcm(long a, long b) {
		return a / gcd(a, b) * b;
	}

	/**
	 * aとbの最大公約数を計算する
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static long gcd(long a, long b) {
		return (0 == b) ? a : gcd(b, a % b);
	}
}
