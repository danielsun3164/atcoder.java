package abc.abc151_200.abc162;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, n).map(a -> IntStream.rangeClosed(1, n).map(b -> {
				int g = gcd(a, b);
				return IntStream.rangeClosed(1, n).map(c -> gcd(g, c)).sum();
			}).sum()).sum());
		}
	}

	/**
	 * aとbの最大公約数を求める
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static int gcd(int a, int b) {
		return (0 == b) ? a : gcd(b, a % b);
	}
}
