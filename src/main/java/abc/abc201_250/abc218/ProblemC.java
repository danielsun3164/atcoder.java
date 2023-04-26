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
		int sr = Integer.MAX_VALUE, er = 0, sc = Integer.MAX_VALUE, ec = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (BLANK != s[i][j]) {
					sr = Math.min(sr, i);
					er = Math.max(er, i);
					sc = Math.min(sc, j);
					ec = Math.max(ec, j);
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
