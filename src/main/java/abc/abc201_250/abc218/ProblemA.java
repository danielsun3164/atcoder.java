package abc.abc201_250.abc218;

import java.util.Scanner;

public class ProblemA {

	/** 晴れを表す文字 */
	private static final char SUNNY = 'o';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt() - 1;
			char[] s = scanner.next().toCharArray();
			System.out.println((SUNNY == s[n]) ? "Yes" : "No");
		}
	}
}
