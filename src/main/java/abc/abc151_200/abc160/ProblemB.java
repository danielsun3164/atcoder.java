package abc.abc151_200.abc160;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			System.out.println((x / 500) * 1000 + (x % 500) / 5 * 5);
		}
	}
}
