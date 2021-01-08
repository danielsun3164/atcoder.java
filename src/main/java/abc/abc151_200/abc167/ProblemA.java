package abc.abc151_200.abc167;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next(), t = scanner.next();
			System.out.println((t.startsWith(s)) ? "Yes" : "No");
		}
	}
}
