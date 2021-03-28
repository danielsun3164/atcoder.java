package abc.abc151_200.abc197;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 障害物を表す文字 */
	private static final char OBSTACLE = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
			char[][] s = new char[h][];
			IntStream.range(0, h).forEach(i -> s[i] = scanner.next().toCharArray());
			int answer = 1;
			// マスの左を計算
			for (int i = y - 1; (i >= 0) && (OBSTACLE != s[x][i]); i--) {
				answer++;
			}
			// マスの右を計算
			for (int i = y + 1; (i < w) && (OBSTACLE != s[x][i]); i++) {
				answer++;
			}
			// マスの上を計算
			for (int i = x - 1; (i >= 0) && (OBSTACLE != s[i][y]); i--) {
				answer++;
			}
			// マスの下を計算
			for (int i = x + 1; (i < h) && (OBSTACLE != s[i][y]); i++) {
				answer++;
			}
			System.out.println(answer);
		}
	}
}
