package abc.abc201_250.abc233;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int l = scanner.nextInt() - 1, r = scanner.nextInt() - 1;
			char[] s = scanner.next().toCharArray();
			while (r > l) {
				swap(s, l, r);
				l++;
				r--;
			}
			System.out.println(s);
		}
	}

	/**
	 * 文字列sのl番目の文字とr番目の文字を交換する
	 *
	 * @param s 文字列
	 * @param l
	 * @param r
	 */
	private static void swap(char[] s, int l, int r) {
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;
	}
}
