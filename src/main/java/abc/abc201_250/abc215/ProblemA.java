package abc.abc201_250.abc215;

import java.util.Scanner;

public class ProblemA {

	/** 比較対象文字列 */
	private static final String HELLO_WORLD = "Hello,World!";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println((HELLO_WORLD.equals(s) ? "AC" : "WA"));
		}
	}
}
