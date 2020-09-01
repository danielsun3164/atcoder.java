package abc.abc064;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			int number = Integer.parseInt(s.replaceAll(" ", ""));
			System.out.println((0 == (number % 4)) ? "YES" : "NO");
		}
	}
}
