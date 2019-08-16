package abc048;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ProblemA {

	private static final Pattern pattern = Pattern.compile("(A)tCoder\\s([A-Z])[a-z]*\\s(C)ontest");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			System.out.println(pattern.matcher(s).replaceFirst("$1$2$3"));
		}
	}
}
