package abc018;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.nextLine().toCharArray();
			int n = scanner.nextInt();
			IntStream.range(0, n).forEach(i -> reverse(scanner.nextInt() - 1, scanner.nextInt() - 1, s));
			System.out.println(s);
		}
	}

	/**
	 * 入力文字列sのlからrまでの位置の文字を反転する
	 * 
	 * @param l
	 * @param r
	 * @param s 入力文字列
	 */
	private static void reverse(int l, int r, char[] s) {
		IntStream.range(0, (r - l + 1) / 2).forEach(i -> swap(l + i, r - i, s));
	}

	/**
	 * 入力文字列sのlとrの位置の文字を置き換える
	 * 
	 * @param l
	 * @param r
	 * @param s 入力文字列
	 */
	private static void swap(int l, int r, char[] s) {
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;
	}
}
