package abc.abc001_050.abc039;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			System.out.println(2 * a * b + 2 * a * c + 2 * b * c);
		}
	}
}
