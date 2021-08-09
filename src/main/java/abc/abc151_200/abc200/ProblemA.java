package abc.abc151_200.abc200;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(((n + 100) - 1) / 100);
		}
	}
}
