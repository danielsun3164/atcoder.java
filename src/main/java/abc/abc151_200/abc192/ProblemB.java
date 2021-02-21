package abc.abc151_200.abc192;

import java.util.Scanner;

public class ProblemB {

	private static final char[] START = { 'a', 'A' };
	private static final char[] END = { 'z', 'Z' };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			for (int i = 0; i < s.length; i++) {
				if ((START[1 & i] > s[i]) || (END[i & 1] < s[i])) {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
		}
	}
}
