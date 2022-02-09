package abc.abc151_200.abc158;

import java.util.Scanner;
import java.util.Set;

public class ProblemA {

	/** AかBのみ管理する場合の文字の一覧 */
	private static final Set<String> SET = Set.of("AAA", "BBB");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(SET.contains(scanner.next()) ? "No" : "Yes");
		}
	}
}
