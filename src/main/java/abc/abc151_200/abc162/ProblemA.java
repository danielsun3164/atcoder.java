package abc.abc151_200.abc162;

import java.util.Scanner;

public class ProblemA {

	/** 7を表す文字 */
	private static final String SEVEN = "7";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String n = scanner.next();
			System.out.println(n.contains(SEVEN) ? "Yes" : "No");
		}
	}
}
