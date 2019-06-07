package abc007;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String a = scanner.nextLine();
			if (a.length() > 1) {
				System.out.println(a.substring(0, a.length() - 1));
			} else if (1 == a.length()) {
				char c = a.charAt(0);
				System.out.println((c == 'a') ? "-1" : (char) (c - 1));
			}
		}
	}
}
