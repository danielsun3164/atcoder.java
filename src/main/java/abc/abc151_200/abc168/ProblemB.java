package abc.abc151_200.abc168;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			String s = scanner.next();
			System.out.println((k >= s.length()) ? s : s.substring(0, k) + "...");
		}
	}
}
