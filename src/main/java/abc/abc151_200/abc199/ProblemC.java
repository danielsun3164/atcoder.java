package abc.abc151_200.abc199;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			char[][] ss = new char[2][n];
			System.arraycopy(s, 0, ss[0], 0, n);
			System.arraycopy(s, n, ss[1], 0, n);
			int q = scanner.nextInt();
			IntStream.range(0, q).forEach(i -> {
				int t = scanner.nextInt(), a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				if (1 == t) {
					swap(ss, n, a, b);
				} else {
					swap(ss);
				}
			});
			StringBuilder sb = new StringBuilder();
			Arrays.stream(ss).forEach(str -> sb.append(str));
			System.out.println(sb.toString());
		}
	}

	/**
	 * 文字列のa番目の文字とb番目の文字を交換する
	 *
	 * @param ss 文字列sの前半と後半の配列
	 * @param n  文字列sの半分の長さ
	 * @param a
	 * @param b
	 */
	private static void swap(char[][] ss, int n, int a, int b) {
		char tmp = ss[a / n][a % n];
		ss[a / n][a % n] = ss[b / n][b % n];
		ss[b / n][b % n] = tmp;
	}

	/**
	 * 文字列sの前半と後半を交換
	 *
	 * @param ss 文字列sの前半と後半の配列
	 */
	private static void swap(char[][] ss) {
		char[] tmp = ss[0];
		ss[0] = ss[1];
		ss[1] = tmp;
	}
}
