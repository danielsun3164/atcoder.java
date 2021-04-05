package abc.abc101_150.abc146;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemF {

	/** ゲームオーバーマスを表す文字 */
	private static final char GAME_OVER = '1';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			// 現在の位置
			int now = n;
			// 結果を保存用
			Deque<Integer> que = new ArrayDeque<>();
			while (now > 0) {
				boolean found = false;
				for (int i = Math.max(0, now - m); i < now; i++) {
					if (s[i] != GAME_OVER) {
						found = true;
						que.addFirst(now - i);
						now = i;
						break;
					}
				}
				if (!found) {
					System.out.println(-1);
					return;
				}
			}
			System.out.println(que.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
