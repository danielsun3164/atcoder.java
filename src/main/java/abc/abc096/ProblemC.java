package abc.abc096;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 黒のコマを表す文字 */
	private static final char BLACK = '#';

	/** 上下左右の座標を表す配列 */
	private static final int[] X = { 0, 1, 0, -1 };
	private static final int[] Y = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			boolean[][] s = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> {
				char[] t = scanner.next().toCharArray();
				IntStream.range(0, w).forEach(j -> s[i][j] = (t[j] == BLACK));
			});
			for (int i = 0; i < h; i++) {
				KOMA: for (int j = 0; j < w; j++) {
					if (s[i][j]) {
						for (int k = 0; k < X.length; k++) {
							int newX = i + X[k], newY = j + Y[k];
							if ((newX >= 0) && (newX < h) && (newY >= 0) && (newY < w)) {
								if (s[newX][newY]) {
									continue KOMA;
								}
							}
						}
						System.out.println("No");
						return;
					}
				}
			}
			System.out.println("Yes");
		}
	}
}
