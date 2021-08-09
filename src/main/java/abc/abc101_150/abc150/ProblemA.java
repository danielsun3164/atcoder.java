package abc.abc101_150.abc150;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt(), x = scanner.nextInt();
			System.out.println((k * 500 >= x) ? "Yes" : "No");
		}
	}
}
