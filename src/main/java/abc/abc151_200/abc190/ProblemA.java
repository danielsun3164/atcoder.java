package abc.abc151_200.abc190;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			a = a + ((1 == c) ? 1 : 0);
			System.out.println((a <= b) ? "Aoki" : "Takahashi");
		}
	}
}
