package abc.abc201_250.abc229;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** マスの数 */
	private static final int N = 2;
	/** 黒いマスを表す文字 */
	private static final char BLACK = '#';
	/** X座標の差分 */
	private static final int[] XS = { 0, 0, -1, 1 };
	/** Y座標の差分 */
	private static final int[] YS = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[][] s = new char[N][];
			IntStream.range(0, N).forEach(i -> s[i] = scanner.next().toCharArray());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (BLACK == s[i][j]) {
						int count = 0;
						for (int k = 0; k < XS.length; k++) {
							int nx = i + XS[k], ny = j + YS[k];
							if ((nx >= 0) && (nx < N) && (ny >= 0) && (ny < N) && (BLACK == s[nx][ny])) {
								count++;
							}
						}
						if (0 == count) {
							System.out.println("No");
							return;
						}
					}
				}
			}
			System.out.println("Yes");
		}
	}
}
