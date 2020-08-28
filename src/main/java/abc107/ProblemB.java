package abc107;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 黒のマスを表す文字 */
	private static final char BLACK = '#';
	/** 空のマスを表す文字 */
	private static final char EMPTY = 0;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] a = new char[h][];
			IntStream.range(0, h).forEach(i -> a[i] = scanner.next().toCharArray());
			// 列を確認する
			IntStream.range(0, w).forEach(j -> {
				boolean hasBlack = false;
				for (int i = 0; i < h; i++) {
					if (BLACK == a[i][j]) {
						hasBlack = true;
						break;
					}
				}
				if (!hasBlack) {
					IntStream.range(0, h).forEach(i -> a[i][j] = EMPTY);
				}
			});
			StringBuilder sb = new StringBuilder();
			// 行を確認する
			IntStream.range(0, h).forEach(i -> {
				boolean hasBlack = false;
				for (int j = 0; j < w; j++) {
					if (BLACK == a[i][j]) {
						hasBlack = true;
						break;
					}
				}
				if (hasBlack) {
					IntStream.range(0, w).map(j -> a[i][j]).filter(c -> EMPTY != (char) c)
							.forEach(c -> sb.append((char) c));
					sb.append("\n");
				}
			});
			System.out.print(sb);
		}
	}
}
