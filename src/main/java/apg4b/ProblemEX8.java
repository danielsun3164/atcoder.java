package apg4b;

import java.util.Scanner;

public class ProblemEX8 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int pattern = scanner.nextInt();
			if (2 == pattern) {
				String text = scanner.next();
				System.out.println(text + "!");
			}
			int price = scanner.nextInt();
			int n = scanner.nextInt();
			System.out.println(price * n);
		}
	}
}
