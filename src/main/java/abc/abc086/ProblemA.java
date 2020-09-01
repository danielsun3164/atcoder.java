package abc.abc086;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(((a & 1) == 0) || ((b & 1) == 0) ? "Even" : "Odd");
		}
	}
}
