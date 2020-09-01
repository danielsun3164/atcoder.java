package other.past201912;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] b = new int[n + 1];
			Arrays.fill(b, 0);
			b[0] = 1;
			IntStream.range(0, n).forEach(i -> b[scanner.nextInt()]++);
			int max = Arrays.stream(b).max().getAsInt();
			if (2 == max) {
				System.out.println(findIndex(b, 2) + " " + findIndex(b, 0));
			} else {
				System.out.println("Correct");
			}
		}
	}

	/**
	 * 配列の中で指定された数値のindexを返す
	 * 
	 * @param array 配列
	 * @param value 数値
	 * @return 配列の中で指定された数値のindex
	 */
	private static int findIndex(final int[] array, final int value) {
		for (int i = 0; i < array.length; i++) {
			if (value == array[i]) {
				return i;
			}
		}
		return 0;
	}

}
