package abc.abc151_200.abc164;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
			System.out.println(((c + b - 1) / b <= (a + d - 1) / d) ? "Yes" : "No");
		}
	}
}
