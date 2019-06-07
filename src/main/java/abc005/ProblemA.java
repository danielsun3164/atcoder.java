package abc005;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			System.out.println(y / x);
		}
	}
}
