package abc.abc201_250.abc223;

import java.util.Scanner;

public class ProblemA {

	/** 100 */
	private static final int HUNDRED = 100;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			System.out.println(((x > 0) && (0 == x % HUNDRED)) ? "Yes" : "No");
		}
	}
}
