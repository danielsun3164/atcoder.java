package abc.abc127;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((a < 6) ? 0 : (a > 12) ? b : b / 2);
		}
	}
}
