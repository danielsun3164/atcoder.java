package abc.abc151_200.abc188;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			int min = Math.min(x, y), max = Math.max(x, y);
			System.out.println((min + 3 > max) ? "Yes" : "No");
		}
	}
}
