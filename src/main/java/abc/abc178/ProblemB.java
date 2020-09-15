package abc.abc178;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong(), d = scanner.nextLong();
			// 解説通りの判定条件
			System.out.println(max(a * c, a * d, b * c, b * d));
		}
	}

	/**
	 * 配列の最大値を計算する
	 * 
	 * @param a 配列
	 * @return 配列の最大値
	 */
	private static long max(long... a) {
		return Arrays.stream(a).max().getAsLong();
	}
}
