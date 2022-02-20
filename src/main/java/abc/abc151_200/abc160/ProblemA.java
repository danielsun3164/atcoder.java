package abc.abc151_200.abc160;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			System.out.println(((s[2] == s[3]) && (s[4] == s[5])) ? "Yes" : "No");
		}
	}
}
