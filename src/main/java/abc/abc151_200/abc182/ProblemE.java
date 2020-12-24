package abc.abc151_200.abc182;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** 何もないものを表す文字 */
	private static final byte NONE = 0x0;
	/** ブロックを表す文字 */
	private static final byte BLOCK = 0x1;
	/** 電球を表す文字 */
	private static final byte LAMP = 0x2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), n = scanner.nextInt(), m = scanner.nextInt();
			// hxwのマスの中身を表す配列
			byte[][] a = new byte[h][w];
			// hxwのマスが光っているかどうかを表す配列
			boolean[][] b = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> {
				Arrays.fill(a[i], NONE);
				Arrays.fill(b[i], false);
			});
			IntStream.range(0, n).forEach(i -> a[scanner.nextInt() - 1][scanner.nextInt() - 1] = LAMP);
			IntStream.range(0, m).forEach(i -> a[scanner.nextInt() - 1][scanner.nextInt() - 1] = BLOCK);
			// 左から右へ、右から下へ、上から下へ、下から上へそれぞれ光っているマスを計算
			for (int i = 0; i < h; i++) {
				boolean light = false;
				for (int j = 0; j < w; j++) {
					light = (LAMP == a[i][j]) ? true : (BLOCK == a[i][j]) ? false : light;
					b[i][j] = light ? light : b[i][j];
				}
			}
			for (int i = 0; i < h; i++) {
				boolean light = false;
				for (int j = w - 1; j >= 0; j--) {
					light = (LAMP == a[i][j]) ? true : (BLOCK == a[i][j]) ? false : light;
					b[i][j] = light ? light : b[i][j];
				}
			}
			for (int j = 0; j < w; j++) {
				boolean light = false;
				for (int i = 0; i < h; i++) {
					light = (LAMP == a[i][j]) ? true : (BLOCK == a[i][j]) ? false : light;
					b[i][j] = light ? light : b[i][j];
				}
			}
			for (int j = 0; j < w; j++) {
				boolean light = false;
				for (int i = h - 1; i >= 0; i--) {
					light = (LAMP == a[i][j]) ? true : (BLOCK == a[i][j]) ? false : light;
					b[i][j] = light ? light : b[i][j];
				}
			}
			System.out.println(
					IntStream.range(0, h).map(i -> (int) IntStream.range(0, w).filter(j -> b[i][j]).count()).sum());
		}
	}
}
