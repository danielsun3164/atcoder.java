package other.hhkb2020;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 右と下の座標の差分の配列 */
	private static final int[] XS = { 0, 1 };
	private static final int[] YS = { 1, 0 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			boolean[][] s = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> {
				char[] t = scanner.next().toCharArray();
				IntStream.range(0, w).forEach(j -> s[i][j] = '.' == t[j]);
			});
			System.out.println(IntStream.range(0, h)
					.map(i -> IntStream.range(0, w).map(j -> (int) IntStream.range(0, XS.length).filter(k -> {
						int x = i + XS[k], y = j + YS[k];
						return (x < h) && (y < w) && s[i][j] && s[x][y];
					}).count()).sum()).sum());
		}
	}
}
