package abc.abc001_050.abc017;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ProblemB {

	/** choku語の正規表現 */
	private static final Pattern PATTERN = Pattern.compile("^(ch|o|k|u)*$");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(PATTERN.matcher(s).matches() ? "YES" : "NO");
		}
	}
}
