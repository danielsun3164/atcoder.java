package abc.abc039;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 白の画素の表現 */
	private static final char WHITE = '.';

	/** 黒の画素の表現 */
	private static final char BLACK = '#';

	/** デフォルトの画素の表現 */
	private static final char DEFAULT = ' ';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] s = new char[h][w];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			char[][] result = reverse(s, h, w);
			if (check(result, s, h, w)) {
				System.out.println("possible");
				IntStream.range(0, h).forEach(i -> System.out.println(result[i]));
			} else {
				System.out.println("impossible");
			}
		}
	}

	/**
	 * @param s 画像表現の配列
	 * @param h 画像の高さ
	 * @param w 画像の幅
	 * @return sの収縮する前の画像表現
	 */
	private static char[][] reverse(char[][] s, final int h, final int w) {
		char[][] result = new char[h][w];
		IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> result[i][j] = DEFAULT));
		IntStream.range(0, h).forEach(
				i -> IntStream.range(0, w).filter(j -> WHITE == s[i][j]).forEach(j -> reverse(result, i, j, h, w)));
		IntStream.range(0, h).forEach(
				i -> IntStream.range(0, w).filter(j -> DEFAULT == result[i][j]).forEach(j -> result[i][j] = BLACK));
		return result;
	}

	/**
	 * (i,j)の画素に対して収縮する作業の逆を実施
	 * 
	 * @param result 収縮する前画像の表現
	 * @param i
	 * @param j
	 * @param h      画像の高さ
	 * @param w      画像の幅
	 */
	private static void reverse(char[][] result, final int i, final int j, final int h, final int w) {
		if (i > 0) {
			if (j > 0) {
				result[i - 1][j - 1] = WHITE;
			}
			result[i - 1][j] = WHITE;
			if (j < w - 1) {
				result[i - 1][j + 1] = WHITE;
			}
		}
		if (j > 0) {
			result[i][j - 1] = WHITE;
		}
		result[i][j] = WHITE;
		if (j < w - 1) {
			result[i][j + 1] = WHITE;
		}
		if (i < h - 1) {
			if (j > 0) {
				result[i + 1][j - 1] = WHITE;
			}
			result[i + 1][j] = WHITE;
			if (j < w - 1) {
				result[i + 1][j + 1] = WHITE;
			}
		}
	}

	/**
	 * @param result 収縮する前の画像の表現
	 * @param s      収縮した後の画像の表現
	 * @param h      画像の高さ
	 * @param w      画像の幅
	 * @return resultがsの収縮する前の画像かどうか
	 */
	private static boolean check(char[][] result, char[][] s, final int h, final int w) {
		return isSame(s, convert(result, h, w), h, w);
	}

	/**
	 * @param s 入力画像
	 * @param h 画像の高さ
	 * @param w 画像の幅
	 * @return 入力画像を収縮した画像
	 */
	private static char[][] convert(final char[][] s, final int h, final int w) {
		char[][] result = new char[h][w];
		int[][] counts = new int[h][w];
		IntStream.range(0, h).forEach(i -> Arrays.fill(counts[i], 0));
		IntStream.range(0, h).forEach(
				i -> IntStream.range(0, w).filter(j -> BLACK == s[i][j]).forEach(j -> increase(counts, i, j, h, w)));
		IntStream.range(0, h)
				.forEach(i -> IntStream.range(0, w).forEach(j -> result[i][j] = (counts[i][j] > 0) ? BLACK : s[i][j]));
		return result;
	}

	/**
	 * (i,j)の周りの黒の画素数を更新
	 * 
	 * @param counts 周りに黒の画素の数
	 * @param i
	 * @param j
	 * @param h      画像の高さ
	 * @param w      画像の幅
	 */
	private static void increase(int[][] counts, final int i, final int j, final int h, final int w) {
		if (i > 0) {
			if (j > 0) {
				counts[i - 1][j - 1]++;
			}
			counts[i - 1][j]++;
			if (j < w - 1) {
				counts[i - 1][j + 1]++;
			}
		}
		if (j > 0) {
			counts[i][j - 1]++;
		}
		counts[i][j]++;
		if (j < w - 1) {
			counts[i][j + 1]++;
		}
		if (i < h - 1) {
			if (j > 0) {
				counts[i + 1][j - 1]++;
			}
			counts[i + 1][j]++;
			if (j < w - 1) {
				counts[i + 1][j + 1]++;
			}
		}
	}

	/**
	 * @param s1
	 * @param s2
	 * @param h  画像の高さ
	 * @param w  画像の幅
	 * @return 画像s1とs2が同じかどうか
	 */
	private static boolean isSame(final char[][] s1, final char[][] s2, final int h, final int w) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (s1[i][j] != s2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
