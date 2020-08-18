package abc173;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 黒のマスを代表する文字 */
	private static final char BLACK = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), k = scanner.nextInt();
			boolean[][] c = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> {
				char[] ci = scanner.next().toCharArray();
				IntStream.range(0, w).forEach(j -> c[i][j] = (BLACK == ci[j]));
			});
			System.out.println(IntStream
					.range(0, 1 << (h + w)).filter(
							i -> k == IntStream.range(0, h).filter(j -> 0 == (i & (1 << j)))
									.map(j -> (int) IntStream.range(0, w)
											.filter(l -> (0 == (i & (1 << (l + h))) && c[j][l])).count())
									.sum())
					.count());
		}
	}
}
