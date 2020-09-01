package abc.abc174;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			System.out.println((x >= 30) ? "Yes" : "No");
		}
	}
}
