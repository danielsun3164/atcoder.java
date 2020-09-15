package abc.abc016;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			if (c == a + b) {
				if (c != a - b) {
					System.out.println("+");
				} else {
					System.out.println("?");
				}
			} else {
				if (c != a - b) {
					System.out.println("!");
				} else {
					System.out.println("-");
				}
			}
		}
	}
}
