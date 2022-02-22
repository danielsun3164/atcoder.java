package abc.abc101_150.abc106;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, (n + 1) / 2).map(i -> 2 * i - 1)
					.filter(i -> 8 == getDivisorNumber(i)).count());
		}
	}

	/**
	 * nの約数の数を計算する
	 *
	 * @param n
	 * @return nの約数の数
	 */
	private static int getDivisorNumber(int n) {
		int count = 0;
		for (int i = 1; i * i <= n; i++) {
			if (0 == n % i) {
				count += (i == n / i) ? 1 : 2;
			}
		}
		return count;
	}
}
