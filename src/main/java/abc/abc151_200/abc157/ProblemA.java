package abc.abc151_200.abc157;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((n + 1) >> 1);
		}
	}
}
