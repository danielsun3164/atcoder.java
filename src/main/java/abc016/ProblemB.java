package abc016;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
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
