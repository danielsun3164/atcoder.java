package abc.abc075;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 爆弾を表す文字 */
	private static final char BOMB = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> calcCount(i, j, h, w, s)));
			IntStream.range(0, h).forEach(i -> System.out.println(s[i]));
		}
	}

	/**
	 * x,yが爆弾でないとき、周りの爆弾の合計数を計算
	 * 
	 * @param x X座標
	 * @param y Y座標
	 * @param h 縦幅
	 * @param w 横幅
	 * @param s マスを表す配列
	 */
	private static void calcCount(final int x, final int y, final int h, final int w, char[][] s) {
		if (BOMB != s[x][y]) {
			int count = 0;
			if (x > 0) {
				if (y > 0) {
					count += (BOMB == s[x - 1][y - 1]) ? 1 : 0;
				}
				count += (BOMB == s[x - 1][y]) ? 1 : 0;
				if (y < w - 1) {
					count += (BOMB == s[x - 1][y + 1]) ? 1 : 0;
				}
			}
			if (y > 0) {
				count += (BOMB == s[x][y - 1]) ? 1 : 0;
			}
			if (y < w - 1) {
				count += (BOMB == s[x][y + 1]) ? 1 : 0;
			}
			if (x < h - 1) {
				if (y > 0) {
					count += (BOMB == s[x + 1][y - 1]) ? 1 : 0;
				}
				count += (BOMB == s[x + 1][y]) ? 1 : 0;
				if (y < w - 1) {
					count += (BOMB == s[x + 1][y + 1]) ? 1 : 0;
				}
			}
			s[x][y] = (char) ('0' + count);
		}
	}
}
