package other.zone2021;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ProblemD {

	/** 反転する文字 */
	private static final char REVERSE = 'R';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			Deque<Character> que = new ArrayDeque<>();
			boolean reverse = false;
			for (char c : s) {
				if (REVERSE == c) {
					reverse = !reverse;
				} else {
					if (reverse) {
						que.addFirst(c);
					} else {
						que.addLast(c);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			while (!que.isEmpty()) {
				char c = (reverse) ? que.pollLast() : que.pollFirst();
				if ((sb.length() > 0) && (sb.charAt(sb.length() - 1) == c)) {
					sb.deleteCharAt(sb.length() - 1);
				} else {
					sb.append(c);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
