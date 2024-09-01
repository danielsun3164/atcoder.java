package abc.abc201_250.abc230;

import java.util.Scanner;

public class ProblemB {

	/** oxx */
	private static final String OXX = "oxx";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(OXX.repeat(4).contains(s) ? "Yes" : "No");
		}
	}
}
