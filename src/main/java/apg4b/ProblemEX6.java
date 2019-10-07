package apg4b;

import java.util.Scanner;

public class ProblemEX6 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			String op = scanner.next();
			int b = scanner.nextInt();
			switch (op) {
			case "+":
				System.out.println(a + b);
				break;
			case "-":
				System.out.println(a - b);
				break;
			case "*":
				System.out.println(a * b);
				break;
			case "/":
				System.out.println((b == 0) ? "error" : a / b);
				break;
			default:
				System.out.println("error");
				break;
			}
		}
	}
}
