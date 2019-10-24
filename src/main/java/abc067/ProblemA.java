package abc067;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(((a % 3 == 0) || (b % 3 == 0) || ((a + b) % 3 == 0)) ? "Possible" : "Impossible");
		}
	}
}
