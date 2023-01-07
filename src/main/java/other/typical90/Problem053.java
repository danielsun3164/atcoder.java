package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/typical90/submissions/23063924 にも参考
 */
public class Problem053 {

	/** 質問するときの文字 */
	private static final String QUESTION = "? ";

	/** 回答するときの文字 */
	private static final String ANSWER = "! ";

	/** フィボナッチ数列 */
	private static final int[] FIBONACCIS = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int n = scanner.nextInt(), index = 0;
				while (FIBONACCIS[index] <= n + 2) {
					index++;
				}
				int fn = FIBONACCIS[index];
				int[] a = new int[fn + 1];
				Arrays.fill(a, -1);
				a[0] = -2;
				IntStream.rangeClosed(n + 1, fn).forEach(i -> a[i] = -i);
				System.out.println(ANSWER + calcMax(scanner, a, 0, fn, -1, -1, index - 2));
			}
		}
	}

	/**
	 * 配列aの[start,end]の最大値を計算する
	 *
	 * @param scanner
	 * @param a
	 * @param start
	 * @param end
	 * @return 配列aの[start,end]の最大値
	 */
	private static long calcMax(Scanner scanner, int[] a, int start, int end, int dl, int dr, int fIndex) {
		if (end - start <= 3) {
			IntStream.rangeClosed(start, end).forEach(i -> input(scanner, a, i));
			return IntStream.rangeClosed(start, end).mapToLong(i -> a[i]).max().getAsLong();
		}
		if (-1 == dl) {
			dl = start + FIBONACCIS[fIndex];
			input(scanner, a, dl);
		}
		if (-1 == dr) {
			dr = end - FIBONACCIS[fIndex];
			input(scanner, a, dr);
		}
		if (a[dl] < a[dr]) {
			return calcMax(scanner, a, dl, end, dr, -1, fIndex - 1);
		} else {
			return calcMax(scanner, a, start, dr, -1, dl, fIndex - 1);
		}
	}

	/**
	 * 配列aのindex番目(0-index)の要素を入力する
	 *
	 * @param scanner
	 * @param a       配列
	 * @param index
	 */
	private static void input(Scanner scanner, int[] a, int index) {
		if (-1 == a[index]) {
			System.out.println(QUESTION + index);
			a[index] = scanner.nextInt();
		}
	}
}
