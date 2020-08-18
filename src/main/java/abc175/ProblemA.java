package abc175;

import java.util.Scanner;

public class ProblemA {

	/** 雨を表す符号 */
	private static final char RAIN = 'R';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int max = 0, count = 0;
			for (char c : s) {
				if (RAIN == c) {
					max = Math.max(max, ++count);
				} else {
					count = 0;
				}
			}
			System.out.println(max);
		}
	}
}
