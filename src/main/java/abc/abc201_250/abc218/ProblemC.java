package abc.abc201_250.abc218;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 回転の回数 */
	private static final int N = 4;
	/** 空白を表す文字 */
	private static final char BLANK = '.';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[][] s = new char[n][], t = new char[n][];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			IntStream.range(0, n).forEach(i -> t[i] = scanner.next().toCharArray());
			char[][] ts = trim(s), tt = t;
			for (int i = 0; i < N; i++) {
				if (same(ts, trim(tt))) {
					System.out.println("Yes");
					return;
				}
				tt = rotate(tt);
			}
			System.out.println("No");
		}
	}

	/**
	 * 図形の周りの空白文字を取り除く
	 *
	 * @param s 図形を表す文字の配列
	 * @return 周りの空白文字がない図形の配列
	 */
	private static char[][] trim(char[][] s) {
		int n = s.length;
		int sr = 0, er = 0, sc = 0, ec = 0;
		main1: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (BLANK != s[i][j]) {
					sr = i;
					break main1;
				}
			}
		}
		main2: for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (BLANK != s[i][j]) {
					er = i;
					break main2;
				}
			}
		}
		main3: for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (BLANK != s[i][j]) {
					sc = j;
					break main3;
				}
			}
		}
		main4: for (int j = n - 1; j >= 0; j--) {
			for (int i = 0; i < n; i++) {
				if (BLANK != s[i][j]) {
					ec = j;
					break main4;
				}
			}
		}
		char[][] result = new char[er - sr + 1][ec - sc + 1];
		for (int i = 0; i < result.length; i++) {
			System.arraycopy(s[sr + i], sc, result[i], 0, result[i].length);
		}
		return result;
	}

	/**
	 * sとtが同じ図形かどうかを判定する
	 *
	 * @param s 図形を表す文字の配列
	 * @param t 図形を表す文字の配列
	 * @return sとtが同じ図形かどうか
	 */
	private static boolean same(char[][] s, char[][] t) {
		if ((s.length == t.length) && (s[0].length == t[0].length)) {
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s[i].length; j++) {
					if (s[i][j] != t[i][j]) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * 図形を回転する
	 *
	 * @param s 図形を表す文字の配列
	 * @return 回転後の図形を表す文字の配列
	 */
	private static char[][] rotate(char[][] s) {
		int n = s.length;
		char[][] result = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = s[n - 1 - j][i];
			}
		}
		return result;
	}
}
