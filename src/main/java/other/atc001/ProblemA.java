package other.atc001;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	/** X座標の差分一覧 */
	private static final int[] XS = { 1, -1, 0, 0 };
	/** Y座標の差分一覧 */
	private static final int[] YS = { 0, 0, 1, -1 };
	/** ブロックを表す文字 */
	private static final char BLOCK = '#';
	/** 家を表す文字 */
	private static final char START = 's';
	/** 魚屋を表す文字 */
	private static final char GOAL = 'g';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			char[][] c = new char[h][];
			IntStream.range(0, h).forEach(i -> c[i] = scanner.next().toCharArray());
			int startX = 0, startY = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (START == c[i][j]) {
						startX = i;
						startY = j;
						break;
					}
				}
			}
			BitSet visited = new BitSet(h * w);
			visited.clear();
			Queue<Integer> que = new ArrayDeque<>();
			final int start = startX * w + startY;
			que.add(start);
			visited.set(start, true);
			while (!que.isEmpty()) {
				int now = que.poll();
				int x = now / w, y = now % w;
				for (int i = 0; i < XS.length; i++) {
					int nx = x + XS[i], ny = y + YS[i], next = nx * w + ny;
					if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w) && (BLOCK != c[nx][ny])) {
						if (GOAL == c[nx][ny]) {
							System.out.println("Yes");
							return;
						}
						if (!visited.get(next)) {
							que.add(next);
							visited.set(next, true);
						}
					}
				}
			}
			System.out.println("No");
		}
	}
}
