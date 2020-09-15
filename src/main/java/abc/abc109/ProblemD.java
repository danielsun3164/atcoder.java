package abc.abc109;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			int[][] a = new int[h][w];
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w).forEach(j -> a[i][j] = scanner.nextInt()));
			List<Move> moves = new ArrayList<>(), currentMoves = new ArrayList<>();
			int prevX = -1, prevY = -1;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					int x = i, y = (0 == (x & 1)) ? j : w - 1 - j;
					if ((prevX >= 0) && (prevY >= 0)) {
						currentMoves.add(new Move(prevX, prevY, x, y));
						if (0 != (a[x][y] & 1)) {
							prevX = -1;
							prevY = -1;
							moves.addAll(currentMoves);
							currentMoves.clear();
						} else {
							prevX = x;
							prevY = y;
						}
					} else if (0 != (a[x][y] & 1)) {
						prevX = x;
						prevY = y;
					}
				}
			}
			System.out.println(moves.size());
			moves.stream().forEach(System.out::println);
		}
	}

	/**
	 * 移動方法を表すクラス
	 */
	private static class Move {
		int x1, y1, x2, y2;

		Move(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(x1 + 1).append(" ");
			sb.append(y1 + 1).append(" ");
			sb.append(x2 + 1).append(" ");
			sb.append(y2 + 1);
			return sb.toString();
		}
	}
}
