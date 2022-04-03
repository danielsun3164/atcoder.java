package abc.abc201_250.abc214;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((n <= 125) ? 4 : ((n >= 212) ? 8 : 6));
		}
	}
}
