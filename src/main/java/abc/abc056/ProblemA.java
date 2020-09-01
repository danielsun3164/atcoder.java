package abc.abc056;

import java.util.Scanner;

public class ProblemA {

	/** 正直者 */
	private static final String HONEST = "H";
	/** 嘘つき */
	private static final String DISHONEST = "D";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String a = scanner.next();
			String b = scanner.next();
			System.out.println((HONEST.equals(a) ? b : reverse(b)));
		}
	}

	/**
	 * @param input
	 * @return inputの反対
	 */
	private static String reverse(String input) {
		return (HONEST.equals(input) ? DISHONEST : HONEST);
	}
}
