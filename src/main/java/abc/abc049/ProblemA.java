package abc.abc049;

import java.util.Scanner;
import java.util.Set;

public class ProblemA {

	/** 母音の文字の一覧 */
	private static final Set<String> SET = Set.of("a", "e", "i", "o", "u");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(SET.contains(s) ? "vowel" : "consonant");
		}
	}
}
