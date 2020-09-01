package abc.abc046;

import java.util.Scanner;

/**
 * 解説通り実装したソースコード
 */
public class ProblemD {

	// private static final char GU = 'g';
	private static final char PA = 'p';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.nextLine().toCharArray();
			int p = 0;
			for (char c : s) {
				if (PA == c) {
					p++;
				}
			}
			System.out.println(s.length / 2 - p);
		}
	}
}
