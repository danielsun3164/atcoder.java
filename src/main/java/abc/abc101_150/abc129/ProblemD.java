package abc.abc101_150.abc129;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 障害物を表す文字 */
	private static final char OBSTACLE = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			int[][] t = new int[h][w];
			// 左から右へ、右から左へ、上から下へ、下から上へそれぞれ計算する
			for (int i = 0; i < h; i++) {
				int count = 0;
				for (int j = 0; j < w; j++) {
					t[i][j] = (OBSTACLE != s[i][j]) ? ++count : (count = 0);
				}
			}
			for (int i = 0; i < h; i++) {
				int count = 0;
				for (int j = w - 1; j >= 0; j--) {
					t[i][j] += (OBSTACLE != s[i][j]) ? count++ : (count = 0);
				}
			}
			for (int j = 0; j < w; j++) {
				int count = 0;
				for (int i = 0; i < h; i++) {
					t[i][j] += (OBSTACLE != s[i][j]) ? count++ : (count = 0);
				}
			}
			for (int j = 0; j < w; j++) {
				int count = 0;
				for (int i = h - 1; i >= 0; i--) {
					t[i][j] += (OBSTACLE != s[i][j]) ? count++ : (count = 0);
				}
			}
			System.out.println(IntStream.range(0, h).map(i -> IntStream.range(0, w).map(j -> t[i][j]).max().getAsInt())
					.max().getAsInt());
		}
	}
}
