package abc.abc151_200.abc153;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), a = scanner.nextInt();
			System.out.println((h + a - 1) / a);
		}
	}
}
