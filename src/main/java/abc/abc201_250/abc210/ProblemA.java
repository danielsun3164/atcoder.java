package abc.abc201_250.abc210;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			System.out.println((x * Math.min(a, n) + y * Math.max(0, n - a)));
		}
	}
}
