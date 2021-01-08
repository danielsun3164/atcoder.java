package abc.abc001_050.abc049;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ProblemC {

	/** 条件に満たす文字の正規表現 */
	private static final Pattern PATTERN = Pattern.compile("^(dream|dreamer|erase|eraser)+$");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(PATTERN.matcher(s).matches() ? "YES" : "NO");
		}
	}
}
