package other.hhkb2020;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next(), t = scanner.next();
			System.out.println("Y".equals(s) ? t.toUpperCase() : t);
		}
	}
}
