package abc.abc040;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int x = scanner.nextInt();
			System.out.println(Math.min(n + 1 - x, x) - 1);
		}
	}
}
