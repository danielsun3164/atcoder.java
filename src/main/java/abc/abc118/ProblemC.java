package abc.abc118;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(1, n).reduce(scanner.nextInt(), (a, b) -> gcd(a, scanner.nextInt())));
		}
	}

	/**
	 * 最大公約数を計算
	 * 
	 * @param x
	 * @param y
	 * @return 最大公約数
	 */
	private static int gcd(int x, int y) {
		if (x < y) {
			return gcd(y, x);
		}
		int tmp = 0;
		while (0 != (tmp = x % y)) {
			x = y;
			y = tmp;
		}
		return y;
	}
}
