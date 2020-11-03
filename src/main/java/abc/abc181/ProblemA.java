package abc.abc181;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((0 == (n & 1)) ? "White" : "Black");
		}
	}
}
