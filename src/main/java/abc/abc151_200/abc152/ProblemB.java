package abc.abc151_200.abc152;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(String.valueOf(Math.min(a, b)).repeat(Math.max(a, b)));
		}
	}
}
