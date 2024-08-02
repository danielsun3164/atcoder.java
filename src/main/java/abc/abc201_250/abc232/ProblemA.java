package abc.abc201_250.abc232;

import java.util.Scanner;

public class ProblemA {

	/** xを表す文字 */
	private static final String X = "x";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String[] s = scanner.next().split(X);
			System.out.println(Integer.parseInt(s[0]) * Integer.parseInt(s[1]));
		}
	}
}
