package abc.abc001_050.abc015;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String a = scanner.next(), b = scanner.next();
			System.out.println((a.length() > b.length()) ? a : b);
		}
	}
}
