package abc.abc151_200.abc197;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(s.substring(1) + s.charAt(0));
		}
	}
}
