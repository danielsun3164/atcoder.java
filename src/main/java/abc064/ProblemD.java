package abc064;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	/** 左括弧 */
	private static final char LEFT = '(';

	/** 右括弧 */
	private static final char RIGHT = ')';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			// 現在までの閉じていない左括弧と右括弧の数
			int noRight = 0, noLeft = 0;
			for (char c : s) {
				if (LEFT == c) {
					if (noRight >= 0) {
						noRight++;
					} else {
						noLeft -= noRight;
						noRight = 1;
					}
				} else {
					noRight--;
				}
			}
			if (noRight < 0) {
				noLeft -= noRight;
				noRight = 0;
			}
			System.out.println(repeat(LEFT, noLeft) + String.valueOf(s) + repeat(RIGHT, noRight));
		}
	}

	/**
	 * @param c 文字
	 * @param n 数
	 * @return 文字をn回繰り返した文字列
	 */
	private static String repeat(char c, int n) {
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, n).forEach(i -> sb.append(c));
		return sb.toString();
	}
}
