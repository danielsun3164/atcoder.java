package abc085;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int y = scanner.nextInt();
			System.out.println(
					Arrays.stream(getResult(n, y)).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * @param n 合計枚数
	 * @param y 合計金額
	 * @return [1万円札の枚数, 5千円札の枚数, 1千円札の枚数]の配列
	 */
	private static int[] getResult(final int n, final int y) {
		for (int i = 0; i <= Math.min(y / 5000, n); i++) {
			int count = n - i;
			int sum = y - i * 5000;
			int diff = sum - count * 1000;
			if ((diff >= 0) && (0 == diff % 9000) && (diff / 9000 <= count)) {
				return new int[] { diff / 9000, i, count - diff / 9000 };
			}
		}
		return new int[] { -1, -1, -1 };
	}
}
