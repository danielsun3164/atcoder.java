package abc.abc201_250.abc211;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println((a + 2 * b) / 3.0d);
		}
	}
}
