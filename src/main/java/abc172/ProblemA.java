package abc172;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			System.out.println((a + a * a + a * a * a));
		}
	}
}
