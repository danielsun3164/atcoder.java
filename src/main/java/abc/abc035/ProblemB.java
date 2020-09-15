package abc.abc035;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {

	// 移動に使う定数
	private static final char UP = 'U';
	private static final char DOWN = 'D';
	private static final char LEFT = 'L';
	private static final char RIGHT = 'R';
	private static final char UNKNOWN = '?';
	/** 最大値を取得する定数 */
	private static final int MAX = 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int t = scanner.nextInt();
			Map<Character, Integer> map = new HashMap<>();
			for (char c : s) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			int dist = Math.abs(map.getOrDefault(UP, 0) - map.getOrDefault(DOWN, 0))
					+ Math.abs(map.getOrDefault(LEFT, 0) - map.getOrDefault(RIGHT, 0));
			if (MAX == t) {
				System.out.println(dist + map.getOrDefault(UNKNOWN, 0));
			} else {
				int result = dist - map.getOrDefault(UNKNOWN, 0);
				// 最小値の場合、resultが負の場合、奇数なら1、偶数なら0
				System.out.println((result < 0) ? (result & 1) : result);
			}
		}
	}
}
