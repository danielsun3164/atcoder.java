package abc015;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String a = scanner.nextLine();
			String b = scanner.nextLine();
			System.out.println((a.length() > b.length()) ? a : b);
		}
	}
}
