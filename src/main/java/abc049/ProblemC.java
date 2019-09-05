package abc049;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ProblemC {

	private static final Pattern pattern = Pattern.compile("^(dream|dreamer|erase|eraser)+$");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			System.out.println(pattern.matcher(s).matches() ? "YES" : "NO");
		}
	}
}
