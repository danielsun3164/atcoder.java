package other.joi2006ho;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			for (int i = 0; i < n; i++) {
				s = convert(s);
			}
			System.out.println(s);
		}
	}

	/**
	 * 入力文字列のそれぞれの文字の数を数えて、数の文字列へ変換する
	 * 
	 * @param s 入力文字列
	 * @return 変換された文字列
	 */
	private static char[] convert(char[] s) {
		StringBuilder sb = new StringBuilder();
		char prev = 0;
		int count = 0;
		for (char c : s) {
			if (c != prev) {
				if (0 != prev) {
					sb.append(count).append(prev);
				}
				prev = c;
				count = 1;
			} else {
				count++;
			}

		}
		if (count > 0) {
			sb.append(count).append(prev);
		}
		return sb.toString().toCharArray();
	}
}
