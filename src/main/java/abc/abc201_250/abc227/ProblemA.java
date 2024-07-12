package abc.abc201_250.abc227;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt(), a = scanner.nextInt();
			System.out.println((k + n + a - 2) % n + 1);
		}
	}
}
