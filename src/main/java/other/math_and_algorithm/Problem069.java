package other.math_and_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Problem069 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong(), d = scanner.nextLong();
			System.out.println(max(a * c, a * d, b * c, b * d));
		}
	}

	/**
	 * lの最大値を取得する
	 *
	 * @param l
	 * @return lの最大値
	 */
	private static long max(long... l) {
		return Arrays.stream(l).max().getAsLong();
	}
}
