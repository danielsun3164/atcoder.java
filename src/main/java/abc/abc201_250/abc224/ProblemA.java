package abc.abc201_250.abc224;

import java.util.Scanner;

public class ProblemA {

	/** er */
	private static final String ER = "er";
	/** ist */
	private static final String IST = "ist";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println((s.endsWith(ER)) ? ER : IST);
		}
	}
}
