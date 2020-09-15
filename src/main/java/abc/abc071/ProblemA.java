package abc.abc071;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((Math.abs(a - x) > Math.abs(b - x)) ? "B" : "A");
		}
	}
}
