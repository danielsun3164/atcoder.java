package abc.abc151_200.abc176;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), t = scanner.nextInt();
			System.out.println((n + x - 1) / x * t);
		}
	}
}
