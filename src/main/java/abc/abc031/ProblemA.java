package abc.abc031;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), d = scanner.nextInt();
			System.out.println(Math.max((a + 1) * d, a * (d + 1)));
		}
	}
}
